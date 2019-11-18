import React, { PureComponent } from "react";
import { connect } from "react-redux";
import styled from "styled-components";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Login from "./pages/login/Login";
import Registration from "./pages/registration/Registration";

const Home = styled.div``;

class App extends PureComponent {
  render() {
    return (
      <Router>
        <div>
          <Switch>
            <Route path="/login">
              <Login />
            </Route>
            <Route path="/signup">
              <Registration />
            </Route>
            <Route path="/">
              <Home>Home</Home>
            </Route>
          </Switch>
        </div>
      </Router>
    );
  }
}
export default connect()(App);
