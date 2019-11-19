import React, { PureComponent } from "react"
import { connect } from "react-redux"
import styled from "styled-components"

const Nav = styled.nav`
  .active {
    background: #ffc107 !important;
  }
`
const A = styled.a`
  color: black !important;
}
 
`
class Pagination extends PureComponent {
  render() {
    return (
      <Nav>
        <ul className="pagination pagination-sm justify-content-center align-items-end">
          <li className="page-item disabled">
            <A className="page-link active" href="#">
              1
            </A>
          </li>
          <li className="page-item">
            <A className="page-link"  href="#">
              2
            </A>
          </li>
          <li className="page-item">
            <A className="page-link" href="#">
              3
            </A>
          </li>
        </ul>
      </Nav>
    )
  }
}

export default connect()(Pagination)
