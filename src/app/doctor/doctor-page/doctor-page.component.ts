import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {RouterOutlet} from "@angular/router";
import {DoctorPageNavComponent} from "./doctor-page-nav/doctor-page-nav.component";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";

@Component({
  selector: 'app-doctor-page',
  templateUrl: './doctor-page.component.html',
  styleUrls: ['./doctor-page.component.css'],
  standalone: true,
  imports: [
    RouterOutlet,
    DoctorPageNavComponent,
    AsyncPipe,
    AsyncPipe
  ]
})
export class DoctorPageComponent implements OnInit {
  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string | undefined> = this.store$.pipe(select(selectToken));
  constructor(
    private store$: Store<UserState>) { }

  ngOnInit(): void {
  }

}
