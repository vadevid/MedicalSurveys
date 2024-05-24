import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";
import {DoctorNavComponent} from "../../nav/doctor-nav/doctor-nav.component";
import {DoctorPageDashboardComponent} from "../doctor-page/doctor-page-dashboard/doctor-page-dashboard.component";
import {DoctorContactingInfoComponent} from "./doctor-contacting-info/doctor-contacting-info.component";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";

@Component({
  selector: 'app-doctor-contacting',
  templateUrl: './doctor-contacting.component.html',
  styleUrls: ['./doctor-contacting.component.css'],
  standalone: true,
  imports: [
    RouterOutlet,
    AsyncPipe,
    AsyncPipe,
    DoctorNavComponent,
    DoctorPageDashboardComponent,
    DoctorContactingInfoComponent
  ]
})
export class DoctorContactingComponent implements OnInit {

  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string | undefined> = this.store$.pipe(select(selectToken));
  constructor(
    private store$: Store<UserState>,
    private userSyncStorage: UserSyncStorageService
  ) {
    this.userId = this.store$.pipe(select(selectUserId));
    this.token = this.store$.pipe(select(selectToken));
  }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
