import { useState, useEffect } from 'react'
import './App.css'
import Movie from './components/Movie';

function App() {
  const [isLoading, setIsLoading] = useState(true);
  const [movies, setMovies] = useState([]);

  console.log(isLoading, setIsLoading);
  const getMovies = async () => {
    const response = await fetch("https://yts.mx/api/v2/list_movies.json?minimun_rating=8.5&sort_by=year")
    const json = await response.json();
    setMovies(json.data.movies);
    setIsLoading(false);
  }

  //async function getMovies() {} 

  useEffect(() => {
    getMovies();
  }  
  , []);
  console.log(movies);
  return (
    <>
      <h1>Movie App !</h1> 
      {isLoading ? "로딩중..." : 
                    <div>
                      {movies.map( movie => <Movie key={movie.id} 
                                                   coverImage={movie.medium_cover_image}
                                                   title={movie.title}
                                                   summary={movie.summary}
                                                   genres={movie.genres}
                                                   /> )}
                    </div>
      }
    </>
  )
}

export default App
