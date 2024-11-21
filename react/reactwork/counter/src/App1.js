import {useState} from 'react';

function App1() {
    let [counter, setCounter] = useState(0);
    let onclick = () => setCounter(counter + 1);
    return (
    <>
    <p className="App">
      {counter} 번 클릭했습니다.
    </p>
    <button onclick={onclick}>클릭</button>
    </>
  );
}

export default App1;
