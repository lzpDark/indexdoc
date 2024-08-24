import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import RoutePage from './pages/RoutePage';
import ManagePage from './pages/ManagePage';
import SearchPage from './pages/SearchPage';
import NavBar from "./pages/NavBar";

function App() {
    return (
        <div>
            <NavBar />
            <Router>
                <Routes>
                    <Route path="/" element={<RoutePage/>}/>
                    <Route path="/manage" element={<ManagePage/>}/>
                    <Route path="/search" element={<SearchPage/>}/>
                </Routes>
            </Router>
        </div>
    );
}

export default App;
