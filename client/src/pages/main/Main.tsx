import React, { PureComponent } from "react";
import { connect } from "react-redux";
import Navbar from "./paths/Navbar";

class Main extends PureComponent {
  render() {
    return (
      <Navbar/>
    );
  }
}

export default connect()(Main);
