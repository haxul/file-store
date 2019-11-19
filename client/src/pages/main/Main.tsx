import React, { PureComponent } from "react"
import { connect } from "react-redux"
import Navbar from "./paths/Navbar"
import Content from "./paths/Content"
import Pagination from "./paths/Pagination"

class Main extends PureComponent {
  render() {
    return (
      <>
        <Navbar />
        <Content />
        <Pagination/>
      </>
    )
  }
}

export default connect()(Main)
