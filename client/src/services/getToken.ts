const getToken = async (username: string, password: string) => {
  const response = await fetch("http://localhost:8080/authenticate", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username, password }),
  })
  const { token } = await response.json()
  return token
}

export default getToken
