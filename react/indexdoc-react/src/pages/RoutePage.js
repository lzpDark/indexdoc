import React from 'react';
import { Link } from 'react-router-dom';

function RoutePage() {
    return (
        <div>
            <h1>Route Page</h1>
            <Link to="/manage"><button>Go to Manage Page</button></Link>
            <Link to="/search"><button>Go to Search Page</button></Link>
        </div>
    );
}

export default RoutePage;