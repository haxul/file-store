import styled from "styled-components";

export const Wrapper = styled.div`
  margin-top: 20px;
`;

export const Button = styled.button`
  text-align:center;
  width:142px;
  background: #664956;
`
export const Block = styled.div`
  text-align:center;
`;

export const P = styled.div`
  padding-top: 4px;
`

export const Error: any = styled.div`
  display: ${(props: any): string => props.show};
  color: red;
  text-align: center;
  width: 100%;
`