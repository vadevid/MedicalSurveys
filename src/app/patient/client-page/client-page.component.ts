import { Component, OnInit } from '@angular/core';
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {Observable} from "rxjs";
import {NavBarComponent} from "./nav-bar/nav-bar.component";
import {RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";

@Component({
  selector: 'app-client-page',
  templateUrl: './client-page.component.html',
  styleUrls: ['./client-page.component.css'],
  standalone: true,
  imports: [
    NavBarComponent,
    RouterOutlet,
    AsyncPipe,
    AsyncPipe
  ]
})
export class ClientPageComponent implements OnInit {
  userId: Observable<number | undefined> | undefined;
  token: Observable<string> | undefined;

  constructor(
    private store$: Store<UserState>,
    private userSyncStorage: UserSyncStorageService
  ) {
    this.userId = this.store$.pipe(select(selectUserId));
    this.token = this.store$.pipe(select(selectToken)); }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
