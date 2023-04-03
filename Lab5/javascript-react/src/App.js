import logo from './logo.svg';
import './App.css';
import './App.css'
import React from 'react';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import AddEmployee from './components/employee/AddEmployee';
import EmployeeComparison from './components/employee/EmployeeComparison';
import UpdateEmployee from './components/employee/UpdateEmployee';
import ViewEmployee from './components/employee/ViewEmployee';
import SortAgeEmployee from './components/employee/SortAgeEmployee';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  return (
<div className="App">
  <Router>

    <Navbar />

    <Routes>
      <Route exact path="/" element={<Home />} />
      <Route exact path="/add-employee" element={<AddEmployee />} />
      <Route exact path="/employee-comparison" element={<EmployeeComparison />} />
      <Route exact path="/update-employee/:id" element={<UpdateEmployee />} />
      <Route exact path="/view-employee/:id" element={<ViewEmployee />} />
      <Route exact path="/sort-employee" element={<SortAgeEmployee />} />"
    </Routes>
  </Router>
      
      
      </div>
  );
}

export default App;
