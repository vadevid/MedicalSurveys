import { Component, OnInit } from '@angular/core';
import {select, Store} from "@ngrx/store";
import {UserState} from "../store/user.reducer";
import {tokenSelector, userSelector} from "../store/user.selectors";
import {Observable} from "rxjs";
import {UserSyncStorageService} from "../service/user-sync-storage.service";
import {UserLogoutAction} from "../store/user.actions";

@Component({
  selector: 'app-client-page',
  templateUrl: './client-page.component.html',
  styleUrls: ['./client-page.component.css']
})
export class ClientPageComponent implements OnInit {

  userId: Observable<number> = this.store$.pipe(select(userSelector));
  token: Observable<string> = this.store$.pipe(select(tokenSelector));

  constructor(
    private store$: Store<UserState>,
    private userSyncStorage: UserSyncStorageService
  ) { }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
