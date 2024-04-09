import { createReducer, on } from '@ngrx/store';
import * as UserActions from './user.actions';

export const USER_REDUCER_NODE = 'user';

export interface UserState {
  userid: number;
  token: string;
}

const initialState: UserState = {
  userid: 0,
  token: ''
};

export const userReducer = createReducer(
  initialState,
  on(UserActions.login, (state, { userid, token }) => ({ userid: userid, token: token })),
  on(UserActions.load, (state, { state: newState }) => newState),
  on(UserActions.logout, state => ({ ...state, userid: 0 }))
);
