import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {tokenSelector, userSelector} from "../../store/user.selectors";
import {UserState} from "../../store/user.reducer";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";
import {ContactingNavComponent} from "./contacting-nav/contacting-nav.component";
import {RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-contacting-doctor',
  templateUrl: './contacting-doctor.component.html',
  styleUrls: ['./contacting-doctor.component.css'],
  standalone: true,
  imports: [
    ContactingNavComponent,
    RouterOutlet,
    AsyncPipe,
    AsyncPipe
  ]
})
export class ContactingDoctorComponent implements OnInit {
  userId: Observable<number | undefined> = this.store$.pipe(select(userSelector));
  token: Observable<string | undefined> = this.store$.pipe(select(tokenSelector));
  constructor(
    private store$: Store<UserState>,
    private userSyncStorage: UserSyncStorageService) { }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
