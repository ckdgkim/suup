import { useContext } from "react";
import Button from "./Button";
import Context from "../const/Context";

const Form = () => {
  const theme = useContext(Context);
  console.log(theme)
  return (
    <>
      <Button />
      <Button />
    </>
  );
};

export default Form;
