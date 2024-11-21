import { useState, useRef } from "react";
import "./App.css";
import Header from "./components/Header";
import TodoItem from "./components/TodoItem";
import Detail from "./components/Detail";

function App() {
  let content = "";
  let [todo, setTodo] = useState(
    {
      id : 0,
      isDone : false,
      content ,
      date : new Date().toLocaleDateString
    }
  )
  let [todolist, setTodolist] = useState([]);
  const changeTodo = (e) => setTodo({...todo, content:e.target.value});
  const onCreate = () => {
    
  }

  const onUpdate = () => {

  }

  const onDelete = () => {

  }
  
  console.log(todo);
  return (
    <>
      <Header />
      <TodoItem content={todo.content} changeTodo={changeTodo} onCreate={onCreate} />
      <Detail todolist={todolist} />
    </>
  );
}

export default App;

/*
  state 
    1. App - todo 객체 (id, isDone, content, date)
      : id 값은 useRef 를 이용하여 렌더와 관계 없이 계속 증가하는 값 유지
        isDone 은 true/false 로 checkbox 클릭시 값이 토글됨
    2. App - todolist 배열
      : 추가 버튼을 누르면 기존 배열의 맨 앞에 새로운 할 일 객체를 추가
    3. Detail - Search Value 
      : todolist 중에서 검색키워드에 해당되는 내용만 찾고자 할 때 사용

  function :
    onCreate : todoItem 으로 props 전달
    onUpdate : Detail 로 props 전달 ==> TodoList 로 props 전달
    onDelete : Detail 로 props 전달 ==> Detail 에서 TodoList로 props 전달
    onSearch : Detail 에서 TodoList로 props 전달
               SearchBar 에서 입력받는 값으로 todolist 배열에 일치하는 내용이 있는지 검색해서
               해당되는 배열만 화면에 보여지게 함.

  배열 : map, filter, include ,forEach

  component(props)
    1. Header
    2. TodoItem
    3. Detail
      3-1 SearchBar
      3-2 TodoList

*/
