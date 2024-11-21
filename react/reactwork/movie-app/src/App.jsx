import { useState, useEffect } from "react";
import { BrowserRouter, Route, Link, Routes } from "react-router-dom";
import "./App.css";
import Home from "../router/Home";
import Detail from "../router/Detail";
import ParamEx1 from "../router/Info";
import ParamEx2 from "../router/ParamEx2";

function App() {
  return (
    <>
      <BrowserRouter>
        <Link className="link" to="/">Home</Link>
        <Link className="link" to="/detail">Detail</Link>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/detail" element={<Detail />} />
          <Route path="/param/:id" element={<ParamEx1 />} />
          <Route path="/query" element={<ParamEx2 />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;