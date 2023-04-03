import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom';

export default function SortAgeEmployee() {
    const [employees,setEmployees]= useState([]);

    useEffect(() => {
        loadEmployee();




    }, []);

    function compare( a, b ) {
        if ( a.age < b.age ){
          return -1;
        }
        if ( a.age > b.age ){
          return 1;
        }
        return 0;
      }

    const loadEmployee = async () => {
        const resulte = await axios.get("api/restaurantemployee-details");
        const result = await axios.get("api/employees-details");
        
        setEmployees(result.data);
        //  SortEmployee();

        employees.sort((a, b) => {
            return a.age - b.age;
        });
        

    }

    // const SortEmployee = async () => {
    //     employees.sort((a, b) => (a.age > b.age) ? 1 : -1)
    //     setEmployees(employees);

    // }

 
      
    const handleSort = (e) => {

        const sortedEmployees = [...employees].sort((a,b)=>{
            return a.age > b.age ?1 : -1
        });
        setEmployees(sortedEmployees);
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
            <button className="btn btn-primary" onClick={handleSort}>Sort by Age</button>
            </div>
        </div>
    );
}
