import React, { PureComponent } from "react"
import { connect } from "react-redux"
import { Wrapper, Button, Block } from "../components/auth"
import getToken from "../../services/getToken"
import { setLoginUsername, setPasswordUsername } from "../../actions/login"
import styled from "styled-components"
import { LoginStateProps, LoginDispatchProps } from "./login.interface"
import { Redirect } from "react-router-dom"

const Error: any = styled.div`
  display: ${(props: any): string => props.show};
  color: red;
  text-align: center;
  width: 100%;
`
const P = styled.div`
  padding-top: 4px;
`
class Login extends PureComponent<any> {
  state = {
    error: false,
    redirect: false
  }

  getJwtToken = async (): Promise<void> => {
    const { username, password } = this.props.login
    const token = await getToken(username, password)
    if (!token) {
      this.setState({ error: true })
      return
    }
    localStorage.setItem("token", token)
    this.setState({redirect: true})
  }

  render() {
    const { setLoginUsername, setPasswordUsername } = this.props
    const { error, redirect } = this.state
    if (redirect) return <Redirect to={"/"}/>

    return (
      <Wrapper className="container">
        <div className="row justify-content-center">
          <Block className="col-sm-4">
            <input type="username" placeholder="enter username" onChange={e => setLoginUsername(e.target.value)} />
            <input
              type="password"
              className="my-2"
              placeholder="password"
              onChange={e => setPasswordUsername(e.target.value)}
            />
            <Button type="button" className="btn btn-warning" onClick={this.getJwtToken}> log in </Button>
            <P> not registered? <a href="/signup">sign up</a> </P>
            <Error show={error ? "block" : "none"}>Error!!!</Error>
          </Block>
        </div>
      </Wrapper>
    )
  }
}

const mapStateToProps = (state:any): LoginStateProps => ({ login: state.login })

const mapDispatchToProps: LoginDispatchProps = {
  setLoginUsername,
  setPasswordUsername,
}
export default connect(mapStateToProps, mapDispatchToProps)(Login)
