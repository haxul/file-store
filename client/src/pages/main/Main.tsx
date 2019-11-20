import React, { PureComponent } from "react"
import { Redirect } from "react-router-dom"
import { connect } from "react-redux"
import Navbar from "./paths/Navbar"
import Content from "./paths/Content"
import Pagination from "./paths/Pagination"

class Main extends PureComponent {
  render() {
    return (
      <>
        <Redirect to={"/login"} />
        <Navbar />
        <Content />
        <Pagination />
      </>
    )
  }
}

export default connect()(Main)
