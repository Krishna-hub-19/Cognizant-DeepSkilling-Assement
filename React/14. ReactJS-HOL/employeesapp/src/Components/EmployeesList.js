import EmployeeCard from "./EmployeeCard";

function EmployeesList({ employees }) {

    return (

        <div className="list">

            {

                employees.map(employee => (

                    <EmployeeCard

                        key={employee.id}

                        employee={employee}

                    />

                ))

            }

        </div>

    );

}

export default EmployeesList;