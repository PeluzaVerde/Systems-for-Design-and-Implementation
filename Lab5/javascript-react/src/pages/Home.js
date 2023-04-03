import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom';

export default function Home() {
    const [employees, setEmployees] = useState([]); //useState is a hook

    const{id}=useParams();

    useEffect(() => {
        loadEmployee();




    }, []);

    const loadEmployee = async () => {
        const resulte = await axios.get("api/restaurantemployee-details");
        const result = await axios.get("api/employees-details");
        setEmployees(result.data);

    }

    const deleteEmployee = async (id) => {
        await axios.delete(`api/employees/${id}`);
        loadEmployee();
    }


    return ( 
        <div className='container'>
            <div className='py-4'>
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Age</th>
                            <th scope="col">Salary</th>
                            <th scope="col">Restaurant</th>
                            <th scope="col">Intern</th>
                            
                            <th scope='col'>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {employees.map((employee, index) => (
                            <tr>
                                <th scope ="row" key = {index}>
                                    {index+1}
                                </th>
                                <td>{employee.name}</td>
                                <td>{employee.age}</td>
                                <td>{employee.salary}</td>
                                <td>{employee.restaurant}</td>
                                <td>{String(employee.intern)}</td>
                                <td>
                                    <Link className="btn btn-primary mx-2" to={`/view-employee/${employee.id}`}>View</Link>
                                    <Link className="btn btn-outline-primary mx-2" to={`/update-employee/${employee.id}`}>Edit</Link>
                                    <button className="btn btn-danger mx-2"
                                    onClick={()=>deleteEmployee(employee.id)}>Delete</button>

                                </td>
                            </tr>
                        ))}
                        
                    </tbody>
                </table>
            </div>
        </div>
    );
}
