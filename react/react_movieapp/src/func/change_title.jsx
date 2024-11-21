import { useEffect } from "react";

export const change_title =  (title) => {
  useEffect( () => {
    const titleElement = document.getElementsByTagName("title")[0];
    titleElement.innerText = title;
  }
  , [title]);
}
