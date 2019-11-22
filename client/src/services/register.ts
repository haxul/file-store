const registerNewUser = async (username: string, password: string) => {
  return  await fetch("http://localhost:8080/register", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ username, password }),
  })
}

export default registerNewUser
