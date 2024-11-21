import { useSearchParams } from "react-router-dom";

const ParamEx2 = () => {
  console.log(useSearchParams());

  let [ params ] = useSearchParams(); // map["id" : 1, "use-image" : true}
  let id  = params.get("id");
  let useImage = params.get("use-image");
  let useCase = params.get("use-case");
  if (!useCase) useCase = true;

  return (
    <>
      <h2>ParamEx2.jsx</h2>
      <div>{id} : {useImage} : {useCase} </div>
    </>
  )
}

export default ParamEx2;