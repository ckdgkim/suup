function NewButton({text, func}) {
  return (
    <>
      <button onClick={func}>{text}</button>
    </>
  )
}

export default NewButton;