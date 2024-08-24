import {Link} from "react-router-dom";
import React from "react";
import "./NavBar.css"

// https://www.sitepoint.com/creating-a-navbar-in-react/
function NavBar() {
    return (
        <nav className="navbar">
            <div className="navbar-left">
                <a href="/" className="logo">
                    IndexDoc
                </a>
            </div>
        </nav>
    );
};

export default NavBar;