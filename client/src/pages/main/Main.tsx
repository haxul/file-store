import React, { PureComponent } from "react";
import { connect } from "react-redux";

class Main extends PureComponent {
  render() {
    return (
      <h1>hello main</h1>
    );
  }
}

export default connect()(Main);
