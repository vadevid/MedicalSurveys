import {Component, Inject, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {data} from "autoprefixer";

@Component({
  selector: 'app-register',
  template: `<div class="container">
    <div class="wrapper">
      <span class="title">Регистрация</span>
      <mat-form-field appearance="outline">
        <mat-label>Логин</mat-label>
        <input matInput>
      </mat-form-field>
      <mat-form-field appearance="outline">
        <mat-label>Пароль</mat-label>
        <input matInput>
      </mat-form-field>
      <mat-form-field appearance="outline">
        <mat-label>Фамилия</mat-label>
        <input matInput>
      </mat-form-field>
      <mat-form-field appearance="outline">
        <mat-label>Имя</mat-label>
        <input matInput>
      </mat-form-field>
      <mat-form-field appearance="outline">
        <mat-label>Отчество</mat-label>
        <input matInput>
      </mat-form-field>
      <mat-form-field appearance="outline">
        <mat-label>Дата Рождения</mat-label>
        <input matInput [matDatepicker]="datepicker">
        <mat-hint>MM/DD/YYYY</mat-hint>
        <mat-datepicker-toggle matSuffix [for]="datepicker"></mat-datepicker-toggle>
        <mat-datepicker #datepicker>
          <mat-datepicker-actions>
            <button mat-button matDatepickerCancel>Отменить</button>
            <button mat-raised-button color="primary" matDatepickerApply>Подтвердить</button>
          </mat-datepicker-actions>
        </mat-datepicker>
      </mat-form-field>
      <div class="link-btns">
        <a mat-raised-button routerLink="/login">Вход</a>
        <button mat-raised-button color="primary">Зарегистрироваться</button>
      </div>
    </div>
  </div>
  `,
  styleUrls: ['./register.component.css'.toString()]
})
export class RegisterComponent implements OnInit {
  router: Router;
  route: ActivatedRoute;
  data: {};
  constructor(@Inject(Router) router: Router, @Inject(ActivatedRoute) route: ActivatedRoute) {
    this.router = router;
    this.route = route;
  }

  ngOnInit(): void {
  }
}
