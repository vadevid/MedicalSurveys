import {Component, OnInit} from '@angular/core';
import {AsyncPipe} from "@angular/common";
import {DashboardClientComponent} from "../client-page/dashboard-client/dashboard-client.component";
import {PatientNavComponent} from "../../nav/patient-nav/patient-nav.component";
import {RouterOutlet} from "@angular/router";
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";
import {selectToken, selectUserId} from "../../store/user.selectors";
import {MessageDashboardComponent} from "./message-dashboard/message-dashboard.component";

@Component({
  selector: 'app-message-page',
  standalone: true,
  imports: [
    AsyncPipe,
    DashboardClientComponent,
    PatientNavComponent,
    RouterOutlet,
    MessageDashboardComponent
  ],
  templateUrl: './message-page.component.html',
  styleUrl: './message-page.component.css'
})
export class MessagePageComponent implements OnInit{
  userId: Observable<number | undefined>;
  token: Observable<string> | undefined;
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
