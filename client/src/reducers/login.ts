import { SET_PASSWORD_LOGIN, SET_USERNAME_LOGIN } from "../store/constant/constants";

const initialState = {
  username: "",
  password: ""
}

export default (state = initialState, action:any) => {
  switch (action.type) {
    case SET_USERNAME_LOGIN:
      return {
        ...state,
        username: action.payload,
      }
    
      case SET_PASSWORD_LOGIN:
        return {
          ...state,
          password: action.payload
        }
    default:
      return state
  }
}
