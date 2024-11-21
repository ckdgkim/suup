import { useState, useRef } from "react";
import "./App.css";
import Form1 from "./components/Form1";
import Form2 from "./components/Form2";
import Form3 from "./components/Form3";

function App() {
  let [student, setStudent] = useState(
      {
        id : 1,
        name : "hongkildong",
        score : 90
      }
  )
  let changeValue = (e) => {
    let {value, name} =e.target;

    console.log(value);
    console.log(name);
    setStudent({...student, [name]:value});
  }
  console.log(student);
  return (
    <>
      <Form3 student={student} changeValue={changeValue} />
    </>
  );
}

export default App;

