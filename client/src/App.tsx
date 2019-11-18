import React, { PureComponent } from "react";
import { connect } from "react-redux";
import styled from "styled-components";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

const About = styled.div``;
const Home = styled.div``;

class App extends PureComponent {
  render() {
    return (
      <Router>
        <div>
          <Switch>
            <Route path="/about">
              <About>about</About>
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
