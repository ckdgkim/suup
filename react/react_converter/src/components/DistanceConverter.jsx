import { useState } from 'react'

function DistanceConverter() {
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
      <label htmlFor="km">KM</label>
      <input type="number" step="10" min="0" value={invert ? Math.round(numbers*1.609) : numbers} id="km" onChange={handler} disabled={invert} />
      <label htmlFor="mile">Mile</label>
      <input type="text" id="mile" placeholder="마일" value={invert ? numbers : Math.round(numbers/1.609)} onChange={handler} disabled={!invert} />
      <button onClick={resetNumbers}>Reset</button>
      <button onClick={inverted}>{invert ? "mile을 km로" : "km를 mile로" }</button>
    </>
  );
}

export default DistanceConverter;