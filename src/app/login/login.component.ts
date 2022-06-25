import {Component, EventEmitter, Inject, Injectable, Input, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {StoreRouterConfig} from "@ngrx/router-store";
import axios from "axios";
import {FormControl} from "@angular/forms";
import {select, Store} from "@ngrx/store";
import {UserState} from "../store/user.reducer";
import {UserLoginAction} from "../store/user.actions";
import {Observable} from "rxjs";
import {userSelector} from "../store/user.selectors";
import {UserSyncStorageService} from "../service/user-sync-storage.service";
import {MatSlideToggle} from "@angular/material/slide-toggle";

@Component({
  selector: 'app-login',
  templateUrl:  './login.component.html',
  styleUrls: ['./login.component.css']
})

@Injectable({providedIn: 'root'})
export class LoginComponent implements OnInit {
  login: string;
  pass: string;
  activate: boolean = false;
  routing: Router;
  route: ActivatedRoute;
  userid: number;
  token: string;
  doctorCheck: boolean = false;
  constructor(@Inject(Router) router: Router,
              @Inject(ActivatedRoute) route: ActivatedRoute,
              private store$: Store<UserState>,
              private userSyncStorage: UserSyncStorageService) {
    this.routing = router;
    this.route = route;
    this.login = this.route.snapshot.paramMap.get('login');
  }


  loginEmmit = new EventEmitter<number>();
  tokenEmmit = new EventEmitter<string>();

  onLogin() {
    this.loginEmmit.emit(this.userid);
    this.tokenEmmit.emit(this.token);
    this.onLoginDispatch(this.userid, this.token);
  }
  onLoginDispatch(userid: number, token: string) {
    this.store$.dispatch(new UserLoginAction({userid, token}))
  }

  async LoginBtn() {
    if (this.doctorCheck) {
      await axios.post('http://localhost:8080/auth/logindoctor', {
        "login": this.login,
        "password": this.pass
      },).then((response) => {
        this.userid = Number(response.data.id);
        this.token = response.data.token;
        switch (response.data.code) {
          case "0":
            this.onLogin();
            this.routing.navigate(['doctorpage']);
            break;
          case "1":
            alert("Неверный пароль.")
            break;
          case "2":
            alert("Неверный логин")
            break;
        }
        return response.data
      })
    } else {
      await axios.post('http://localhost:8080/auth/login', {
        "login": this.login,
        "password": this.pass
      },).then((response) => {
        this.userid = Number(response.data.id);
        this.token = response.data.token;
        switch (response.data.code) {
          case "0":
            this.onLogin();
            this.routing.navigate(['clientpage']);
            break;
          case "1":
            alert("Неверный пароль.")
            break;
          case "2":
            alert("Неверный логин")
            break;
        }
        return response.data
      })
    };
  }

  ngOnInit() {
    this.userSyncStorage.init();
  }
}
