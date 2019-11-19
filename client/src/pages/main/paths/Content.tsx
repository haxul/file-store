import React, { PureComponent } from "react"
import { connect } from "react-redux"
import styled from "styled-components"
import Search from "./Search"
import File from "./File"

const Window = styled.div`
  height: 50vh;
`
const Td = styled.td`
  textalign: right;
  width: 20px;
`
class Content extends PureComponent {
  render() {
    return (
      <div className="container">
        <div className="row align-items-center justify-content-center">
          <div className="col-4">
            <Search />
          </div>
          <div className="col-4">
            <File />
          </div>
        </div>
        <Window className="row justify-content-center">
          <div className="col-8">
            <table className="table">
              <tbody>
                <tr>
                  <th scope="row">1</th>
                  <td>Otto</td>
                  <Td>
                    <button className="ml-1 btn btn-warning">⬇️</button>
                  </Td>
                  <td>
                    <button className="ml-1 btn btn-warning">✖️</button>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </Window>
      </div>
    )
  }
}

export default connect()(Content)
