import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';

export default function EditEmployee() {

    let navigate = useNavigate();

    const {id}= useParams();

    const [employee, setEmployee] = useState({
        name: "",
        age: 0,
        salary: 0,
        restaurant: "",
        intern: false

    })

    const { name, age, salary, restaurant, intern } = employee;

    const onInputChange = (e) => {
        setEmployee({ ...employee, [e.target.name]: e.target.value });
    };

    useEffect(() => {
        loadEmployee();
    }, []);

    const onSubmit =async (e) => {
        e.preventDefault();
        
       const result = await axios.put(`http://localhost:80/employees/${id}`, employee);
        navigate("/");
    };

    const loadEmployee = async () => {
        const result = await axios.get(`http://localhost:80/employees/${id}`);
        setEmployee(result.data);
    }

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 shadow offset-md-3 border rounded mx-auto p-4 mt-2">
                    <h2 className="text-center m-4">Edit Employee</h2>

                    <form onSubmit={(e) => onSubmit(e)}>
                    <div className="mb-3">
                        <label htmlFor="Name" className="form-label">Name</label>
                        <input type={"text"} className="form-control" placeholder="Enter Name" name="name" value={name}
                            onChange={(e) => onInputChange(e)}
                        />

                    </div>
                    <div className="mb-3">
                        <label htmlFor="Age" className="form-label">Age</label>
                        <input type={"text"} className="form-control" placeholder="Enter Age" name="age" value={age}
                            onChange={(e) => onInputChange(e)} />

                    </div>
                    <div className="mb-3">
                        <label htmlFor="Salary" className="form-label">Salary</label>
                        <input type={"text"} className="form-control" placeholder="Enter Salary" name="salary" value={salary}
                            onChange={(e) => onInputChange(e)} />


                    </div>
                    <div className="mb-3">
                        <label htmlFor="Restaurant" className="form-label">Restaurant</label>
                        <input type={"text"} className="form-control" placeholder="Enter Restaurant" name="restaurant"
                            value={restaurant}
                            onChange={(e) => onInputChange(e)}
                        />
                    </div>
                    <div className="bootstrap-switch-square">
                        <label htmlFor="Intern" className="form-label">Intern</label>
                        <br></br>
                        <input type={"checkbox"} data-toggle="switch" placeholder="Enter Intern" name="intern" id="intern" value={Boolean(intern)}


                            onChange={(e) => onInputChange(e)}
                        />
                    </div>

                    {/* <div class="form-check form-switch">
                        <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault" name="intern" value={intern} onChange={(e) => onInputChange(e)} />
                        <label class="form-check-label" for="flexSwitchCheckDefault">Intern</label>
                    </div> */}

                    {/* <div class="form-check">
                        <input class="form-check-input" type="radio" name="intern" id="flexRadioDefault1" value ='true' 
                        onChange={(e) => onInputChange(e)}
                        />
                            <label class="form-check-label" for="flexRadioDefault1">
                                Yes
                            </label>

                            
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="intern" id="flexRadioDefault2" checked value='false' 
                        onChange={(e) => onInputChange(e)}
                        />
                            <label class="form-check-label" for="flexRadioDefault2">
                                No
                            </label>

                            
                    </div> */}
                    <button type="submit" className="btn btn-outline-primary">submit</button>
                    <Link  className="btn btn-outline-danger mx-2" to="/">cancel</Link>

                    </form>

                </div>
            </div>
        </div>
    )
}
