import { useState, useRef } from "react";
import "./App.css";
import Header from "./components/Header";
import ComponentObj from "./components/ComponentObj";
import TodoForm from "./components/TodoForm";

function App() {
  //const id = useRef(0);
  // let localid = 0;
  let [todo, setTodo] = useState({});
  let [todolist, setTodolist] = useState([]);
  const changeTodo = (e) => setTodo(e.target.value);
  const addTodolist = (e) => {
    e.preventDefault();
    if (!todo) return;
    setTodo("");
    const newItem = {
      id: 0,
    };
    setTodolist((arr) => [todo, ...arr]);
    id.current = id.current + 1;
    localid = localid + 1;
    console.log("함수 내부 ==> " + todolist);
    //console.log("ref id ==> " , id);
    // console.log("local id ==> " , localid);
  };
  const deleteTodo = (itemToDelete) => {
    setTodolist(todolist.filter((item) => item !== itemToDelete));
    let a = false;
    if (!a) {
      console.log("false");
    }
  };

  console.log("함수 외부 ==>" + todolist);
  return (
    <>
      <ComponentObj />
      <Header />
      <TodoForm number={200} str="hello" bool={true} todo={todo} changeTodo={changeTodo}
                addTodolist={addTodolist} todolist={todolist} deleteTodo={deleteTodo} />
    </>
  );
}

export default App;