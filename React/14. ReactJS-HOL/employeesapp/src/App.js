import { useState } from "react";
import "./App.css";
import EmployeesList from "./Components/EmployeesList";
import ThemeContext from "./ThemeContext";

function App() {

    const [theme, setTheme] = useState("light");

    const employees = [

        {
            id:1,
            name:"Rahul Sharma",
            designation:"Software Engineer",
            department:"Development"
        },

        {
            id:2,
            name:"Priya Verma",
            designation:"QA Engineer",
            department:"Testing"
        },

        {
            id:3,
            name:"Amit Singh",
            designation:"Project Manager",
            department:"Management"
        }

    ];

    const changeTheme = () => {

        setTheme(

            theme === "light"
            ? "dark"
            : "light"

        );

    };

    return (

      <ThemeContext.Provider value={theme}>

        <div className="container">

          <h1>Employee Management System</h1>

            <button
                onClick={changeTheme}
                className={theme}
            >
                Switch Theme
            </button>

            <EmployeesList
                employees={employees}
            />

        </div>

      </ThemeContext.Provider>

  );

}

export default App;