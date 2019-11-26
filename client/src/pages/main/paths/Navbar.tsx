import React, { PureComponent } from "react"
import { connect } from "react-redux"
import styled from "styled-components"
import icon from "../../../icons/linux.png"
import { withRouter } from "react-router-dom"

const Span = styled.span`
  cursor: pointer;
  :hover {
    color: #664956;
  }
`
const Nav = styled.ul`
  background: #ffc107;
`

class Navbar extends PureComponent<any> {
  
  async componentDidMount() {
    const token = localStorage.getItem("token")
    try {
      const response = await fetch("http://localhost:8080/token", { method: "GET", headers: { authorization: `Bearer ${token}` } })
    } catch (error) {
      console.log(error );
      
      // this.props.history.push("/login");
    }
  }

  logout = () => {
    localStorage.removeItem("token")
    this.forceUpdate()
  }

  render() {
    return (
      <Nav className="nav justify-content-end">
        <img src={icon} alt="icon" />
        <li className="nav-item" onClick={this.logout}>
          <Span className="nav-link ">Log out</Span>
        </li>
      </Nav>
    )
  }
}

export default withRouter(connect()(Navbar))
