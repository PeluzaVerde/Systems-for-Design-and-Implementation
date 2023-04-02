import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
                <div className="container-fluid">
                    <Link className="navbar-brand" href="#" to="/">SPA Navbar</Link>
                    <button
                        className="navbar-toggler" 
                        type="button" 
                        data-bs-toggle="collapse"
                         data-bs-target="#navbarNav" 
                         aria-controls="navbarNav" 
                         aria-expanded="false"
                          aria-label="Toggle navigation">



                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <Link className="btn btn-outline-light" to="/add-employee">Add Employee</Link>
                    <button
                        className="navbar-toggler" 
                        type="button" 
                        data-bs-toggle="collapse"
                         data-bs-target="#navbarNav" 
                         aria-controls="navbarNav" 
                         aria-expanded="false"
                          aria-label="Toggle navigation">



                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <Link className="btn btn-outline-dark" to="/employee-comparison">View Employee comparison</Link>
                    
                    </div>
                    </nav>



                </div>
                )
}
