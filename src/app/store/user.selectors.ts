import {createFeatureSelector, createSelector, State} from "@ngrx/store";
import {USER_REDUCER_NODE, UserState} from "./user.reducer";

export const userFeatureSelector = createFeatureSelector<UserState>(USER_REDUCER_NODE);

export const userSelector = createSelector(
  userFeatureSelector,
  state => state.userid
)
