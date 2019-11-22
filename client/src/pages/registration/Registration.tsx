import React, { PureComponent } from "react"
import { connect } from "react-redux"
import { Wrapper, Button, Block, P, Error } from "../components/auth"
import { setRegisterPassword, setRegisterUsername } from "../../actions/register"
import { RegisterStateProps, RegisterDispatchProps } from "./register.interface"
import { Redirect } from "react-router-dom"
import registerNewUser from "../../services/register";

class Registration extends PureComponent<any> {
  
  state = {
    redirect: false,
    error: false,
  }

  register = async ():Promise<void> => {
    const {username, password} = this.props.register
    const response = await registerNewUser(username, password)
    if (response.status !== 200) {
      this.setState({error: true})
      return;
    }
    this.setState({redirect: true})
  }

  render() {
    const { redirect, error } = this.state
    const { setRegisterPassword, setRegisterUsername } = this.props
    if (redirect) return <Redirect to={"/"} />
    return (
      <Wrapper className="container">
        <div className="row justify-content-center">
          <Block className="col-sm-4">
            <input
              type="username"
              className=""
              id="username"
              placeholder="enter username"
              onChange={e => setRegisterUsername(e.target.value)}
            />
            <input
              type="password"
              className="my-3"
              id="password"
              placeholder="password"
              onChange={e => setRegisterPassword(e.target.value)}
            />
            <Button type="button" className="btn btn-warning" onClick = {this.register}>
              Sing up
            </Button>
            <P>
              already registered? <a href="/login">login</a>
            </P>
            <Error show={error ? "block" : "none"}>Error!!!</Error>
          </Block>
        </div>
      </Wrapper>
    )
  }
}

const mapStateToProps = (state: any): RegisterStateProps => ({ register: state.register })

const mapDispatchToProps: RegisterDispatchProps = {
  setRegisterPassword,
  setRegisterUsername,
}
export default connect(mapStateToProps, mapDispatchToProps)(Registration)
