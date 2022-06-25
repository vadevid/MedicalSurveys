import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {tokenSelector, userSelector} from "../../store/user.selectors";
import {UserState} from "../../store/user.reducer";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";

@Component({
  selector: 'app-doctor-contacting',
  templateUrl: './doctor-contacting.component.html',
  styleUrls: ['./doctor-contacting.component.css']
})
export class DoctorContactingComponent implements OnInit {

  userId: Observable<number> = this.store$.pipe(select(userSelector));
  token: Observable<string> = this.store$.pipe(select(tokenSelector));
  constructor(
    private store$: Store<UserState>,
    private userSyncStorage: UserSyncStorageService) { }

  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
