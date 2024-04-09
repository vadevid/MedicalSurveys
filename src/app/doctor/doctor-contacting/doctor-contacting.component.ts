import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {DoctorContactingNavComponent} from "./doctor-contacting-nav/doctor-contacting-nav.component";
import {RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";

@Component({
  selector: 'app-doctor-contacting',
  templateUrl: './doctor-contacting.component.html',
  styleUrls: ['./doctor-contacting.component.css'],
  standalone: true,
  imports: [
    DoctorContactingNavComponent,
    RouterOutlet,
    AsyncPipe,
    AsyncPipe
  ]
})
export class DoctorContactingComponent implements OnInit {

  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string | undefined | null> = this.store$.pipe(select(selectToken));
  constructor(
    private store$: Store<UserState>) { }

  ngOnInit(): void {
  }

}
