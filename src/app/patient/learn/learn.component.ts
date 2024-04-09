import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {tokenSelector, userSelector} from "../../store/user.selectors";
import {UserState} from "../../store/user.reducer";
import {UserSyncStorageService} from "../../service/user-sync-storage.service";
import {RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";
import {LearnNavComponent} from "./learn-nav/learn-nav.component";

@Component({
  selector: 'app-learn',
  templateUrl: './learn.component.html',
  styleUrls: ['./learn.component.css'],
  imports: [
    LearnNavComponent,
    RouterOutlet,
    AsyncPipe
  ],
  standalone: true
})
export class LearnComponent implements OnInit {

  constructor(
    private store$: Store<UserState>,
    private userSyncStorage: UserSyncStorageService
  ) { }

  userId: Observable<number | undefined> = this.store$.pipe(select(userSelector));
  token: Observable<string| undefined> = this.store$.pipe(select(tokenSelector));
  ngOnInit(): void {
    this.userSyncStorage.init();
  }

}
