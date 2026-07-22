import { useContext } from "react";
import ThemeContext from "../ThemeContext";

function EmployeeCard({ employee }) {

    const theme = useContext(ThemeContext);

    return (

        <div className={`card card-${theme}`}>

            <h2>{employee.name}</h2>

            <p>
                <strong>Designation:</strong> {employee.designation}
            </p>

            <p>
                <strong>Department:</strong> {employee.department}
            </p>

            <button className={theme}>
                View Profile
            </button>

        </div>

    );

}

export default EmployeeCard;