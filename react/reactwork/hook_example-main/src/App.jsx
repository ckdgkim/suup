import { useState, useContext, createContext } from "react";
import "./App.css";
import Form from "./components/Form";
import  Context  from "./const/Context";

function App() {

  const theme = useContext(Context);
  theme.type = "display";
  theme.color = "gray";
  const [type, setType] = useState("");
  const onChange = (e) => {
    setType(e.target.value);
  };
  const [color, setColor] = useState("");
  const onColor = (e) => {
    setColor(e.target.value);
  };

  return (
    <>
      <h1>useContext 예제</h1>
      <Context.Provider value={theme}>
        <Form />
      </Context.Provider>
    </>
  );
}

export default App;
