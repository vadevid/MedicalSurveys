import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";
import {CardPageInfoComponent} from "../card-page/card-page-info/card-page-info.component";
import {PatientNavComponent} from "../../nav/patient-nav/patient-nav.component";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";
import {ContactingDashboardComponent} from "./contacting-dashboard/contacting-dashboard.component";

@Component({
  selector: 'app-contacting-doctor',
  templateUrl: './contacting-doctor.component.html',
  styleUrls: ['./contacting-doctor.component.css'],
  standalone: true,
  imports: [
    RouterOutlet,
    AsyncPipe,
    AsyncPipe,
    CardPageInfoComponent,
    PatientNavComponent,
    ContactingDashboardComponent
  ]
})
export class ContactingDoctorComponent implements OnInit {
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
    this.userSyncStorage.init()
  }

}
