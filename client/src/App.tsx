import React, { Component } from "react";
import { connect } from "react-redux";
import styled from "styled-components";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

const About = styled.div``;
const Home = styled.div``;
class App extends Component {
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
