import {Action} from "@ngrx/store";
import {UserState} from "./user.reducer";

export enum userActionsType {
  login = '[USER] login user',
  logout = '[USER] logout user',
  load = '[USER] load user state',
}

export class UserLoginAction implements Action {
  readonly type = userActionsType.login;

  constructor(public payload: { userid: number | undefined, token: string | undefined | null }) {
  }
}

export class UserLogoutAction implements Action {
  readonly type = userActionsType.logout;

  constructor(public payload: { userid: number }) {
  }
}

export class UserLoadStateAction implements Action {
  readonly type = userActionsType.load;

  constructor(public payload: { state: UserState }) {
  }
}

export type UserActions = UserLoginAction | UserLoadStateAction | UserLogoutAction;
