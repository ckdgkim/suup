import { useSearchParams } from "react-router-dom";

const ParamEx2 = () => {
    console.log(useSearchParams());
    // console.log(useParams());
    let [ params ] = useSearchParams(); // {"id" : 1, "use-image" : true}
    let id = params.get("id");
    let useImage = params.get("use-image");
    let useCase = params.get("use-case");   
    console.log(params.get("id"));
    console.log(params.get("use-image"));
    console.log(params.get("use-case"));
    let useCase = params.get("use-case");
    if (!useCase) useCase = false
    // console.log(id);
    return (
        <>
        <h2>ParamEx2.jsx</h2>
        </>
    )
}

export default ParamEx2;