import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { NumericFormat } from 'react-number-format';
import { Link } from 'react-router-dom';

export default function ListEmployees() {
    const urlBase = "http://localhost:8080/rh-app/employees";

    const [employees, setEmployees] = useState([]);

    useEffect(() => {
        loadEmployees();
    }, []);


    const loadEmployees = async () => {
        const result = await axios.get(urlBase);
        console.log("Resultado de cargar empleados");
        console.log(result.data);
        setEmployees(result.data)
    }

    const deleteEmployee = async (id) => {
        await axios.delete(`${urlBase}/${id}`);
        loadEmployees();
    }

    return (
        <div className='container'>
            <div className='container text-center' style={{ margin: "30px" }}>
                <h3>Sistema de Recursos Humanos</h3>
            </div>

            <table className="table table-striped table-hover align-middle">
                <thead className='table-primary'>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Empleado</th>
                        <th scope="col">Departamento</th>
                        <th scope="col">Sueldo</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                {employees.map((employee, index) => (
                        <tr key={index}>
                            <th scope="row">{employee.id}</th>
                            <td>{employee.name}</td>
                            <td>{employee.department}</td>
                            <td><NumericFormat value={employee.salary}
                                displayType={'text'}
                                thousandSeparator=','
                                prefix={'$'} decimalScale={2} fixedDecimalScale />
                            </td>
                            <td>
                                <div>
                                <Link to={`/edit/${employee.id}`}
                                className="btn btn-warning btn-sm me-3">Editar</Link>  
                                <button 
                                onClick={()=> deleteEmployee(employee.id)}
                                    className='btn btn-danger btn-sm'>Eliminar</button>
                                </div>
                            </td>
                        </tr>
                    ))
                    }
                </tbody>
            </table>
        </div>
    )
}
