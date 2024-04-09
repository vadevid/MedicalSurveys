import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {tokenSelector, userSelector} from "../../store/user.selectors";
import {UserState} from "../../store/user.reducer";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";
import {RouterOutlet} from "@angular/router";
import {DoctorPageNavComponent} from "./doctor-page-nav/doctor-page-nav.component";
import {AsyncPipe} from "@angular/common";

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
  userId: Observable<number | undefined> = this.store$.pipe(select(userSelector));
  token: Observable<string | undefined> = this.store$.pipe(select(tokenSelector));
  constructor(
    private store$: Store<UserState>,
    private userSyncStorage: UserSyncStorageService) { }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
