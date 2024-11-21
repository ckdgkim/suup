import { useState } from 'react'
import './App.css'

function App() {

  let [todo, setTodo] = useState("");
  let [todolist, setTodolist] = useState([]);
  const changeTodo = (e) => setTodo(e.target.value);
  const addTodolist = (e) => {
    e.preventDefault();
    if(!todo) return;
    setTodo("");
    setTodolist((arr) => [todo,...arr]);
    console.log("함수 내부 ==> " + todolist);
  }
  console.log("함수 외부 ==>" + todolist);
  return (
    <>
      <form>
        <input type="text" value={todo} placeholder="할 일을 입력하세요" onChange={changeTodo}/>
        <button onClick={addTodolist}>Add</button>
        <hr />
        <ul>
          {todolist.map(todo => <li>{todo}</li>)}
        </ul>
      </form>
    </>
  )
}

export default App
