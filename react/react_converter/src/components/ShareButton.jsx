function ShareButton({text, color, tColor, func}) {
  return (
    <>
      <button style={{
        backgroundColor:color,
        color:tColor
      }} onClick={func}>
        {text}
      </button>
    </>
  )
}

export default ShareButton;