import {Component, EventEmitter, Inject, Injectable, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterLink, RouterOutlet} from "@angular/router";
import axios from "axios";
import {Store} from "@ngrx/store";
import {UserState} from "../store/user.reducer";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatAnchor, MatButton} from "@angular/material/button";
import {MatInput} from "@angular/material/input";
import {FormsModule} from "@angular/forms";
import {login} from "../store/user.actions";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  imports: [
    MatFormField,
    FormsModule,
    MatAnchor,
    RouterLink,
    MatButton,
    RouterOutlet,
    MatLabel,
    MatFormField,
    MatInput
  ],
  standalone: true
})

@Injectable({providedIn: 'root'})
export class LoginComponent implements OnInit {
  login: string | undefined;
  pass: string | undefined;
  userid: number = 0;
  token: string = '';
  role: string | undefined;
  routing: Router;

  constructor(router: Router,
              route: ActivatedRoute,
              private store$: Store<UserState>) {
    this.routing = router;
    this.login = route.snapshot.paramMap.get('login')!;
  }

  onLogin() {
    this.onLoginDispatch(this.userid, this.token);
  }

  onLoginDispatch(userid: number, token: string) {
    console.log(token)
    this.store$.dispatch(login({userid: userid, token: token}))
  }

  async LoginBtn() {
    await axios.post('/api/auth/login', {
      "login": this.login,
      "password": this.pass
    }).then((response) => {
      console.log(response)
      this.userid = Number(response.data.id);
      this.token = response.data.token;
      this.role = response.data.role;
      if (this.role == null) {
        alert("Введены неверные данные")
      }
      if (this.role == "DOCTOR_ROLE") {
        this.onLogin()
        this.routing.navigate(['doctorpage'])
      }
      if (this.role == "PATIENT_ROLE") {
        this.onLogin()
        this.routing.navigate(['clientpage'])
      }
      return response.data
    })
  }

  ngOnInit() {
  }
}
