import {Component} from '@angular/core';
import {Store} from "@ngrx/store";
import {UserState} from "./store/user.reducer";
import {UserLoginAction} from "./store/user.actions";

@Component({
  selector: 'my-app',
  template: `<router-outlet></router-outlet>`
})
export class AppComponent {
  title: 'Дневник здоровья'
  constructor(
    private store$: Store<UserState>,
  ) {
  }
}
