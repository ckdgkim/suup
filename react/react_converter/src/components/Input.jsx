function Input({name, func}) {
  return (
    <>
      <input type="text" value={name} onChange={func} />
    </>
  )
}

export default Input;