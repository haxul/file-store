import React, { PureComponent } from "react"
import { connect } from "react-redux"
import styled from "styled-components"

const FormGroup = styled.div`
  margin-top: 5px;
`
const Label = styled.label`
  width: 120px;
  border: 2px dashed grey;
  border-radius: 5px;
  display: block;
  padding-left: 1em;
  padding-right: 1em;
  transition: border 300ms ease;
  cursor: pointer;
  text-align: center;
  :hover {
    border: 2px solid #000;
    color: #000;
  }
`
const Input = styled.input`
  outline: 0;
  opacity: 0;
  pointer-events: none;
  user-select: none;
  :hover {
    color: #000;
  }
`
const I = styled.i`
  display: block;
  font-size: 32px;
  padding-bottom: 5px;
`
const Title = styled.span`
  color: grey;
  transition: 200ms color;
  :hover {
    color: #000;
  }
`
class File extends PureComponent {
  render() {
    return (
      <FormGroup>
        <Label>
          <I className="material-icons">attach_file</I>
          <Title>Добавить файл</Title>
          <Input type="file" />
        </Label>
      </FormGroup>
    )
  }
}

export default connect()(File)
