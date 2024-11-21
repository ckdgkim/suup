import { useState , useEffect } from 'react'
import './App.css'
import NewButton from './components/NewButton'
import Viewer from './components/Viewer';
import Input from './components/Input';


function App() {
  let [count, setCount] = useState(0);
  let [name, setName] = useState("");
  const changeCount = () => setCount(count + 1);
  const changeName = (e) => setName(e.target.value);
  // console.log("rendered");
  // console.log(count);
  // console.log(name);
  useEffect(() => console.log("mount 되었습니다.") ,[]);
  useEffect(() => console.log("count 또는 name 이 변경되었습니다.") ,[count,name]);
  //useEffect(() => console.log("name 이 변경되었습니다.") ,[name]);
  return (
    <>
      <Viewer count={count}/>
      <NewButton text="click" func={changeCount}/>
      <br />
      <Input name={name} func={changeName}/>
    </>
  )
}

export default App
