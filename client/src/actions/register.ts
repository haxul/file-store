import { SET_PASSWORD_REGISTER, SET_USERNAME_REGISTER } from "../store/constant/constants";

export const setRegisterUsername = (username: string) => (dispatch: Function) => {
  dispatch({
    type: SET_USERNAME_REGISTER,
    payload: username
  })
}

export const setRegisterPassword = (password: string) => (dispatch: Function) => {
  dispatch({
    type: SET_PASSWORD_REGISTER,
    payload: password
  })
}