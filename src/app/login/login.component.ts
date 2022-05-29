import {Component, Inject, Injectable, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {StoreRouterConfig} from "@ngrx/router-store";

@Component({
  selector: 'app-login',
  template: `
    <div class="container">
      <div class="wrapper">
        <span class="title">Вход</span>
        <mat-form-field appearance="outline">
          <mat-label>Логин</mat-label>
          <input name="loginInput" [(ngModel)]="login" matInput>
        </mat-form-field>
        <mat-form-field appearance="outline">
          <mat-label>Пароль</mat-label>
          <input name="passInput" [(ngModel)]="pass" matInput>
        </mat-form-field>
        <div class="link-btns">
          <a mat-raised-button routerLink="/register">Регистрация</a>
          <button mat-raised-button color="primary" (click)="LoginBtn()">Войти</button>
        </div>
      </div>
    </div>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['./login.component.css'.toString()]
})
@Injectable({providedIn: 'root'})
export class LoginComponent implements OnInit {
  login: string;
  pass: string;
  activate: boolean = false;
  routing: Router;

  constructor(@Inject(Router) router: Router) {
    this.routing = router;
  }

  LoginBtn() {
    if (this.login == 'vadevid' && this.pass == 'pass') this.routing.navigate(['register', {login : this.login, pass : this.pass}])
  }

  ngOnInit() {
  }

}
