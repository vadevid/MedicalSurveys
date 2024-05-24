import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";
import {DoctorNavComponent} from "../../nav/doctor-nav/doctor-nav.component";
import {CardPageInfoComponent} from "../../patient/card-page/card-page-info/card-page-info.component";
import {DoctorPageDashboardComponent} from "./doctor-page-dashboard/doctor-page-dashboard.component";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";

@Component({
  selector: 'app-doctor-page',
  templateUrl: './doctor-page.component.html',
  styleUrls: ['./doctor-page.component.css'],
  standalone: true,
  imports: [
    RouterOutlet,
    AsyncPipe,
    AsyncPipe,
    DoctorNavComponent,
    CardPageInfoComponent,
    DoctorPageDashboardComponent
  ]
})
export class DoctorPageComponent implements OnInit {
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
