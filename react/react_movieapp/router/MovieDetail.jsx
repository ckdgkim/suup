import { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import Cast from '../src/components/Cast';
import './MovieDetail.css';
import { change_title } from '../src/func/change_title';

const MovieDetail = () => {
  
  let [movie, setMovie] = useState({})
  // console.log(useParams());
  let { id } = useParams();
  console.log(id);
  let url = `https://yts.mx/api/v2/movie_details.json?movie_id=${id}&with_images=true&with_cast=true`;
  
  const getMovie = async function (){
    const response = await fetch(url);
    const json = await response.json();
    setMovie(json.data.movie);
    console.log(json.data.movie);
  }

  useEffect( () => 
        getMovie()
    ,[]);

  change_title(`${movie.title} 영화 상세 보기`);
  return (
    <>
      <h2>{movie.title}</h2>
      <div>
        <img src={movie.large_cover_image} alt="이미지" /> 
        <div>좋아요 : {movie.like_count}</div>
        <div>평점 : {movie.rating}</div>
        <ul className="cast-container">
          {Array.isArray(movie.cast) ? movie.cast.map((ch, index) => 
            <Cast key={index}
                  coverImage={ch.url_small_image} 
                  name={ch.name}
                  characterName={ch.character_name}
                  />
         ) : null} 
        </ul>
      </div>
    </>
  )
}

export default MovieDetail;