import { useState, useEffect } from 'react';
import { BrowserRouter, Route, Link, Routes } from 'react-router-dom'
import './App,css'
import Home from '../router/Home';
import Detail from '../router/Detail';

function App(){
    return (
        <>
        <BrowserRouter>
        <Link className="link" to="/">Home</Link>
        <Link className="link" to="/detail">Detail</Link>
        <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/detail' element={<Detail />} />
        </Routes>
        </BrowserRouter>
        </>
    );
}

export default App;