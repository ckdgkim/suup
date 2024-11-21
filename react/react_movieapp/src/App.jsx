import { useState, useEffect } from "react";
import { Route, Link, Routes } from "react-router-dom";
import "./App.css";
// import Home from "../router/Home";
// import Detail from "../router/Detail";
// import ParamEx1 from "../router/ParamEx1";
// import ParamEx2 from "../router/ParamEx2";
import MovieHome from "../router/MovieHome";
import MovieDetail from "../router/MovieDetail";

function App() {
  return (
    <>
      <Link className="link" to="/">MovieHome</Link>
      <Routes>
        <Route path="/" element={<MovieHome />} />
        <Route path="/detailMovie/:id" element={<MovieDetail />} />
      </Routes>
    </>
  );
}

export default App;
