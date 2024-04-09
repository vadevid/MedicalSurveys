// import { Injectable } from '@angular/core';
// import {select, Store} from "@ngrx/store";
// import {UserState} from "../store/user.reducer";
// import {UserLoadStateAction} from "../store/user.actions";
// import {userFeatureSelector} from "../store/user.selectors";
// import {filter} from "rxjs";
//
// export const USER_LOCALSTORAGE_KEY = 'user';
//
// @Injectable({
//   providedIn: 'root'
// })
// export class UserSyncStorageService {
//   private isInit = false;
//
//   constructor(private store$: Store<UserState>) {
//   }
//
//   init() {
//     if (this.isInit) {
//       return
//     }
//     this.isInit = true;
//     this.loadFormStorage();
//
//     this.store$.pipe(
//       select(userFeatureSelector),
//       filter(state => !!state)
//     ).subscribe(state => {
//       localStorage.setItem(USER_LOCALSTORAGE_KEY, JSON.stringify(state));
//     })
//     window.addEventListener('storage', () => this.loadFormStorage());
//   }
//
//   private loadFormStorage() {
//     const storageState = localStorage.getItem(USER_LOCALSTORAGE_KEY);
//     if (storageState) {
//       this.store$.dispatch(new UserLoadStateAction({
//         state: JSON.parse(storageState)
//       }))
//     }
//   }
// }
