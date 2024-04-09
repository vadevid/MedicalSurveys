import { Component, OnInit } from '@angular/core';
import {select, Store} from "@ngrx/store";
import {UserState} from "../../store/user.reducer";
import {Observable} from "rxjs";
import {NavBarComponent} from "./nav-bar/nav-bar.component";
import {RouterOutlet} from "@angular/router";
import {AsyncPipe} from "@angular/common";
import {selectToken, selectUserId} from "../../store/user.selectors";

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

  userId: Observable<number | undefined> = this.store$.pipe(select(selectUserId));
  token: Observable<string | undefined | null> = this.store$.pipe(select(selectToken));

  constructor(
    private store$: Store<UserState>
  ) { }

  ngOnInit(): void {
  }

}
