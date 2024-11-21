import { Link  } from 'react-router-dom';
import './Home.css';

const Home = () => {
  return (
    <>
      <h2>Home.jsx</h2>
      <Link className="link" to="/param/1">
        path param 전달
      </Link>
      <Link className="link" to="/query?id=1&use-image=true">
        queryString 전달
      </Link>
    </>
  )
}

export default Home;
