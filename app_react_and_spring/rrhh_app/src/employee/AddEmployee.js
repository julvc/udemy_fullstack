import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

export default function AddEmployee() {

    let navigation = useNavigate();

    const [employee, setEmployee] = useState({
        name: "",
        department:"",
        salary: ""
    });

    const{name,department,salary} = employee

    const onInputChange = (e) => {
        //spread operator (expandir los atributos)
        setEmployee({...employee, [e.target.name]: e.target.value})
    }

    const onSubmit = async(e) =>{
        e.preventDefault();
        const urlBase = "http://localhost:8080/rh-app/employees";
        await axios.post(urlBase, employee);
        navigation('/');
    }

    return (
        <div classNameName='container'>
            <div classNameName='container text-center' style={{ margin: "30px" }}>
                <h3>Agregar Empleado</h3>
            </div>

            <form onSubmit={(e)=>onSubmit(e)}>
                <div className="mb-3">
                    <label htmlFor="name" className="form-label">Nombre</label>
                    <input type="text" className="form-control" id="name" name="name" required={true} 
                    value={name} onChange={(e)=>onInputChange(e)}/>
                </div>
                <div className="mb-3">
                    <label htmlFor="department" className="form-label">Departamento</label>
                    <input type="text" className="form-control" id="department" name="department" 
                    value={department} onChange={(e)=>onInputChange(e)}/>
                </div>
                <div className="mb-3">
                    <label htmlFor="salary" className="form-label">Salario</label>
                    <input type="number" step="any" className="form-control" id="salary" name="salary" 
                    value={salary} onChange={(e)=>onInputChange(e)}/>
                </div>
                <div className='text-center'>
                    <button type="submit" className="btn btn-warning btn-sm me-3">Agregar</button>
                    <a href='/' className="btn btn-danger btn-sm">Regresar</a>
                        
                </div>
                </form>
        </div>
    )
}
