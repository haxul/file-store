import React, { PureComponent } from "react";
import { connect } from "react-redux";
import styled from "styled-components";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Login from "./pages/login/Login";
import Registration from "./pages/registration/Registration";
import Main from "./pages/main/Main";

const NoMatch = styled.div``;

class App extends PureComponent {
  render() {
    return (
      <Router>
        <div>
          <Switch>
            <Route exact path="/">
              <Main />
            </Route>
            <Route path="/login">
              <Login />
            </Route>
            <Route path="/signup">
              <Registration />
            </Route>
            <Route path="*">
              <NoMatch>404 Not Found</NoMatch>
            </Route>
          </Switch>
        </div>
      </Router>
    );
  }
}
export default connect()(App);
