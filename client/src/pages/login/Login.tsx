import React, { PureComponent } from "react"
import { connect } from "react-redux"
import { Wrapper, Button, Block } from "../components/auth"
import getToken from "../../services/getToken";

class Login extends PureComponent {

  state = {
    username: "",
    password: ""
  }

  getJwtToken = async () => {
    const { username, password } = this.state
    const token:string = await getToken(username, password)
    if (!token) this.setState({error: true })
    localStorage.setItem("token", token)
  }

  render() {
    return (
      <Wrapper className="container">
        <div className="row justify-content-center">
          <Block className="col-sm-4">
            <input
              type="username"
              placeholder="enter username"
              onChange={e => this.setState({ username: e.target.value })}
            />
            <input type="password" className="my-2" placeholder="password" onChange={e => this.setState({ password: e.target.value })} />
            <Button type="button" className="btn btn-warning" onClick={this.getJwtToken}>
              log in
            </Button>
          </Block>

        </div>
      </Wrapper>
    )
  }
}

export default connect()(Login)
