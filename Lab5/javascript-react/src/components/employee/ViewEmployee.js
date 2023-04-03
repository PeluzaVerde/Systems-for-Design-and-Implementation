import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'

export default function ViewEmployee() {

    const [employee,setEmployee]= useState({
        name:"",
        age:"",
        salary:"",
        restaurant:"",
        intern:""
    })

    const {id}=useParams();

    useEffect(()=>{
        loadEmployee();

    },[])

    const loadEmployee=async()=>{
        const result = await axios.get(`api/employees/${id}`);
        setEmployee(result.data);}
  return (
    <div className="container">
            <div className="row">
                <div className="col-md-6 shadow offset-md-3 border rounded mx-auto p-4 mt-2">
                    <h2 className="text-center m-4">Employee Details</h2>

                    <div className="card">
                        <div className="card-header">
                            Details of id:
                            <ul className="list-group list-group-flush">

                                <li className="list-group-item">
                                    <b>Name:</b>
                                    {employee.name}
                                </li>
                                <li className="list-group-item">
                                    <b>Age:</b>
                                    {employee.age}
                                </li>
                                <li className="list-group-item">
                                    <b>Salary:</b>
                                    {employee.salary}
                                </li>
                                <li className="list-group-item">
                                    <b>Restaurant:</b>
                                    {employee.restaurant}
                                </li>
                                <li className="list-group-item">
                                    <b>Intern:</b>
                                    {String(employee.intern)}
                                </li>

                            </ul>

                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to="/">Back to Home</Link>
               </div>
            </div>

    </div>
    
  )
}
