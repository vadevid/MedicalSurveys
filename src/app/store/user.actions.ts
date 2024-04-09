import { createAction, props } from '@ngrx/store';
import { UserState } from './user.reducer';

export const login = createAction(
  '[USER] login user',
  props<{ userid: number; token: string }>()
);

export const logout = createAction(
  '[USER] logout user',
  props<{ userid: number }>()
);

export const load = createAction(
  '[USER] load user state',
  props<{ state: UserState }>()
);
