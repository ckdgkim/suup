import { useParams } from "react-router-dom";

const ParamEx1 = () => {
  console.log(useParams());
  let { id } = useParams(); // {"id" : 1}
  console.log(id);
  return (
    <>
      <h2>ParamEx1.jsx</h2>
      <div>id 가 {id} 입니다.</div>
    </>
  )
}

export default ParamEx1;