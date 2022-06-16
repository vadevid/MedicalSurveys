import {Component, EventEmitter, Inject, Injectable, OnInit, Output} from '@angular/core';
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
  loginErr: boolean = false;
  passErr: boolean = false;
  userid: number;
  constructor(@Inject(Router) router: Router,
              @Inject(ActivatedRoute) route: ActivatedRoute,
              private store$: Store<UserState>,
              private userSyncStorage: UserSyncStorageService) {
    this.routing = router;
    this.route = route;
    this.login = this.route.snapshot.paramMap.get('login');
  }

  loginEmmit = new EventEmitter<number>();

  onLogin() {
    this.loginEmmit.emit(this.userid);
    this.onLoginDispatch(this.userid);
  }
  onLoginDispatch(userid: number) {
    this.store$.dispatch(new UserLoginAction({userid}))
  }

  async LoginBtn() {
    await axios.post('http://localhost:8080/patient/login', {
      "login": this.login,
      "password": this.pass
    }).then((response) => {
      this.userid = Number(response.data.toString().substring(1));
      switch (response.data.toString().substring(0, 1)) {
        case "0":
          this.onLogin();
          this.routing.navigate(['clientpage']);
          break;
        case "1":
          this.passErr = true;
          break;
        case "2":
          this.loginErr = true;
          break;
      }
      console.log(this.passErr, this.loginErr)
      this.loginErr = false;
      this.passErr = false;
      return response.data
    });
  }

  ngOnInit() {
    this.userSyncStorage.init();
  }
}
