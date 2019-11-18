import React, { PureComponent } from "react";
import { connect } from "react-redux";
import { Wrapper, Button, Block } from "../components/auth";

class Registration extends PureComponent {
  render() {
    return (
      <Wrapper className="container">
        <div className="row justify-content-center">
          <Block className="col-sm-4">
            <input type="username" className="" id="username" placeholder="enter username" />
            <input type="password" className="my-3" id="password" placeholder="password" />
            <Button type="button" className="btn btn-warning"> Sing up </Button>
          </Block>
        </div>
      </Wrapper>
    );
  }
}

export default connect()(Registration);
