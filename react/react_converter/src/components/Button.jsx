function Button({text, countUpNDown}) {
  return (
    <button onClick={countUpNDown}>
      {text}
    </button>
  )
}

export default Button;