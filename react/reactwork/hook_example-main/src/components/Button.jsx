import { useContext } from "react";
import  Context  from "../const/Context";

const Button = () => {
  const {color, type} = useContext(Context);
  return (
    <button type="submit" 
      style={{backgroundColor:color}}
    >{type}</button>
  )
}

export default Button;