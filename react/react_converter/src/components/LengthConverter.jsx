import { useState } from 'react'

function LengthConverter() {
  let [numbers, setNumbers] = useState(0);
  let [invert, setInvert] = useState(false);
  const handler = (event) => {
    setNumbers(event.target.value);
  }
  const resetNumbers = () => {
    setNumbers(0);
  }
  const inverted = () => {
    setInvert(cur => !cur);
    setNumbers(0);
  }
  return (
    <>
      <label htmlFor="cm">CM</label>
      <input type="number" step="10" min="0" value={invert ? Math.round(numbers*2.54) : numbers} id="cm" onChange={handler} disabled={invert} />
      <label htmlFor="inch">INCH</label>
      <input type="text" id="inch" placeholder="inch" value={invert ? numbers : Math.round(numbers/2.54)} onChange={handler} disabled={!invert} />
      <button onClick={resetNumbers}>Reset</button>
      <button onClick={inverted}>{invert ? "inch를 cm로" : "cm를 inch로" }</button>
    </>
  );
}

export default LengthConverter;