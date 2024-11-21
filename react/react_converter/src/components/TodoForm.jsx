function TodoForm({
  number,
  todo,
  bool,
  str,
  changeTodo,
  addTodolist,
  todolist,
  deleteTodo,
}) {
  return (
    <>
      <form>
        <p>
          {number} : {str}: {bool ? "true" : "false"}
        </p>
        <input
          type="text"
          value={todo}
          placeholder="할 일을 입력하세요"
          onChange={changeTodo}
        />
        <button onClick={addTodolist}>Add</button>
        <hr />
        <ul>
          {todolist.map((todo) => (
            <li key={todo}>
              {todo}
              <button onClick={deleteTodo}>삭제</button>
            </li>
          ))}
        </ul>
      </form>
    </>
  );
}

export default TodoForm;
