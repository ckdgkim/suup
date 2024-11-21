import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <>
    <h2>Home.jsx</h2>
    <Link to="/param/1">
      path param 전달
    </Link>
    <Link to="/query?id=1&use-image=true">
      queryString 전달
    </Link>
    </>
  )
}

export default Home;