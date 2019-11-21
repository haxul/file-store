import { SET_PASSWORD_LOGIN, SET_USERNAME_LOGIN } from "../store/constant/constants";

export const setLoginUsername = (username: string) => (dispatch: Function) => {
  dispatch({
    type: SET_USERNAME_LOGIN,
    payload: username
  })
}

export const setPasswordUsername = (password: string) => (dispatch: Function) => {
  dispatch({
    type: SET_PASSWORD_LOGIN,
    payload: password
  })
}