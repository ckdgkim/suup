import { useState } from 'react'
import './App.css'
import Button from './components/Button';
import Viewer from './components/Viewer';

function App() {
  const [count, setCount] = useState(0)
  const handler = num => {
    setCount(count + num);
  }
  console.log("rendered");
  console.log(count);
  return (
    <>
      <h1>Counter</h1>
      <div className="card">
        <Viewer count={count} />
        <Button text="-1" countUpNDown={() => handler(-1)}/>
        <Button text="-10" countUpNDown={() => handler(-10)}/>
        <Button text="-100" countUpNDown={() => handler(-100)}/>
        <Button text="+100" countUpNDown={() => handler(100)}/>
        <Button text="+10" countUpNDown={() => handler(10)}/>
        <Button text="+1" countUpNDown={() => handler(1)}/>
      </div>
    </>
  )
}

export default App
