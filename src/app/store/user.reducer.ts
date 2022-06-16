import {UserActions, userActionsType} from "./user.actions";

export const USER_REDUCER_NODE = 'user';

export interface UserState {
  userid: number;
}

const initialState: UserState = {
  userid: 0,
}

export const userReducer = (state = initialState, action: UserActions) => {
  switch (action.type) {
    case userActionsType.login:
      return {
        ...state,
        userid: action.payload.userid
      }
    case userActionsType.load:
      return {
        ...action.payload.state
      }
    case userActionsType.logout:
      return {
        ...state,
        userid: 0
      }
    default:
      return state
  }
}
