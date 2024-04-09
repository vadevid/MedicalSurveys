import { Injectable } from '@angular/core';
import {select, Store} from "@ngrx/store";
import {UserState} from "../store/user.reducer";
import {filter} from "rxjs";
import {load} from "../store/user.actions";
import {selectUserState} from "../store/user.selectors";

export const USER_LOCALSTORAGE_KEY = 'user';

@Injectable({
  providedIn: 'root'
})
export class UserSyncStorageService {
  private isInit = false;

  constructor(private store$: Store<UserState>) {
  }

  init() {
    if (this.isInit) {
      return
    }
    this.isInit = true;
    this.loadFormStorage();

    this.store$.pipe(
      select(selectUserState),
      filter(state => !!state)
    ).subscribe(state => {
      localStorage.setItem(USER_LOCALSTORAGE_KEY, JSON.stringify(state));
    })
    window.addEventListener('storage', () => this.loadFormStorage());
  }

  private loadFormStorage() {
    const storageState = localStorage.getItem(USER_LOCALSTORAGE_KEY);
    if (storageState) {
      this.store$.dispatch(load({
        state: JSON.parse(storageState)
      }))
    }
  }
}
