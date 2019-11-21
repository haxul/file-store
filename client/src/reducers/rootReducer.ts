import { combineReducers } from 'redux';
import test from './testreducer';
import login from './login';
export default combineReducers({
  test,
  login
});