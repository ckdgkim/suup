import { useState } from 'react'
import './App.css'
import ShareButton from './components/ShareButton'


function App() {
  const handler = () => console.log("클릭되었습니다.");
  return (
    <>
      <ShareButton text="Save" color="red" tColor="black" func={handler} />
      <ShareButton text="Confirm" color="purple" tcolor="yellow" func={handler} />
    </>
  )
}

export default App
