import { useState } from 'react'
import './App.css'
import TimeConverter from './components/TimeConverter'
import DistanceConverter from './components/DistanceConverter'
import LengthConverter from './components/LengthConverter'

function App() {
  let [option, setOption] = useState("0");
  const handleOption = (e) => {
    setOption(e.target.value);
  };
  console.log(option);
  return (
    <>
      <h1>Converter</h1>
      <select name="type" id="select" value={option} onChange={handleOption}>
        <option value="0">Select Unit Converter</option>
        <option value="1">Time Converter</option>
        <option value="2">Distance Converter</option>
        <option value="3">Length Converter</option>
      </select> 
      <hr />
      {option == 0? "Please select the option which you want to convert" : null}
      {option == 1 ? <TimeConverter />: null}
      {option == 2 ? <DistanceConverter /> : null}
      {option == 3 ? <LengthConverter /> : null}
    </>
  )
}

export default App
