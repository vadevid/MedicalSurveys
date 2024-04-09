import { createSelector, createFeatureSelector } from '@ngrx/store';
import { USER_REDUCER_NODE, UserState } from './user.reducer';

export const selectUserState = createFeatureSelector<UserState>(USER_REDUCER_NODE);

export const selectUserId = createSelector(
  selectUserState,
  state => state.userid
);

export const selectToken = createSelector(
  selectUserState,
  state => state.token
);

