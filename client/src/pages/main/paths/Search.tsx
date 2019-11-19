import React, { PureComponent } from "react"
import { connect } from "react-redux"
import styled from "styled-components"

class Search extends PureComponent {
  render() {
    return (
      <nav className="navbar navbar-light bg-light">
        <form className="form-inline">
          <input className="form-control warning  mr-sm-2" type="search" placeholder="Search" aria-label="Search" />
          <button className="btn btn-warning my-2 my-sm-0" type="submit">
            Search
          </button>
        </form>
      </nav>
    )
  }
}

export default connect()(Search)
