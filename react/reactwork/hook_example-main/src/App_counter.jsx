import { useState, useReducer } from "react";
import "./App.css";
import { ACTION_TYPE , reducer } from './functions/changeCount'

function App() {
  let value = 0;
  console.log("호출되었음" + (++value));
  // dispatch => reducer 에게 일을 시키는 함수
  const [name, setName] = useState("");
  const onChange = (e) => {
    setName(e.target.value);
  }
  const [rCount, dispatch] = useReducer(reducer, 0);
  const up = () => {
    dispatch({ type: ACTION_TYPE.up , payload: 1 });
  }
  const down = () => {
    dispatch({ type: ACTION_TYPE.down , payload: 1 });
  }
  return (
    <>
      <h1>New Counter using Reducer</h1>
      <input type="text" value={name} onChange={onChange} />
      <p>{rCount}</p>
      <button
        onClick={up}
      >
        1 증가
      </button>
      <button
        onClick={down}
      >
        1 감소
      </button>
    </>
  );
}

export default App;









function add(a,b){
  return a + b;
}
console.log(add(10,5));



let e = 10;
function add2(c,d){
  return c + d + e;
}

console.log(add2(10, 5));

e = 20;
console.log(add2(10, 5));


const h = 10;
function add3(f,g){
  return f + g + h;
}

console.log(add3(10, 5));

//상수 h는 값 변경 불가능
console.log(add3(10, 5));

