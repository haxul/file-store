import { SET_PASSWORD_REGISTER, SET_USERNAME_REGISTER } from "../store/constant/constants"

const initialState = {
  username: "",
  password: "",
}

export default (state = initialState, action: any) => {
  const { type, payload } = action
  switch (type) {
    case SET_USERNAME_REGISTER:
      return {
        ...state,
        username: payload,
      }

    case SET_PASSWORD_REGISTER:
      return {
        ...state,
        password: payload,
      }
    default:
      return state
  }
}
