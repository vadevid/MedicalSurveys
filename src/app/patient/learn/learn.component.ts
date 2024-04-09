import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";
import {LearnNavComponent} from "./learn-nav/learn-nav.component";
import {selectToken, selectUserId} from "../../store/user.selectors";

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
    // private userSyncStorage: UserSyncStorageService
  ) { }

  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string| undefined | null> = this.store$.pipe(select(selectToken));
  ngOnInit(): void {
    // this.userSyncStorage.init();
  }

}
