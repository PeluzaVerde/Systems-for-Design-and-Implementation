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
    
        const result = await axios.get("http://localhost:80/employee/comparison");
        setEmployees(result.data);

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
                            
                            </tr>
                        ))}
                        
                    </tbody>
                </table>

            
            <Link className="btn btn-primary" to="/">Back to Home</Link>
            </div>
        </div>
    );
}
