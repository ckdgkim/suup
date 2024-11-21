import { useState, useRef } from "react";
import "./App.css";
import ShareButton from "./components/ShareButton";
import Text from "./components/Text";

function App() {
  let [isLogin, setIsLogin] = useState(false);
  let login = () => {
    setIsLogin((cur) => !cur);
  }
  return (
    <>
      <Text text={isLogin ? "반갑습니다." : "로그인하세요"} />      
      <ShareButton text={isLogin ? "Logout" : "Login"}
                   func={login} 
                   color={isLogin ? "navy" : "black"} 
                   tColor={isLogin ? "yellow" : "white"} /> 
    </>
  );
}

export default App;

