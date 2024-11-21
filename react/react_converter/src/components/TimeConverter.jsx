import { useState } from 'react'

function TimeConverter() {
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
      <label htmlFor="minutes">분</label>
      <input type="number" step="10" min="0" value={invert ? numbers*60 : numbers} id="minutes" onChange={handler} disabled={invert} />
      <label htmlFor="hour">시간</label>
      <input type="text" id="hour" placeholder="시간" value={invert ? numbers : Math.round(numbers/60)} onChange={handler} disabled={!invert} />
      <button onClick={resetNumbers}>Reset</button>
      <button onClick={inverted}>{invert ? "시간을 분으로" : "분을 시간으로" }</button>
    </>
  );
}

export default TimeConverter;