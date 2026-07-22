import { useState } from "react";
import GuestPage from "./Components/GuestPage";
import UserPage from "./Components/UserPage";

function App() {

    const [isLoggedIn, setIsLoggedIn] = useState(false);

    let page;

    if (isLoggedIn) {
        page = <UserPage />;
    } else {
        page = <GuestPage />;
    }

    return (

        <div style={{ margin: "20px" }}>

            <h1>Ticket Booking App</h1>

            {

                isLoggedIn ?

                    <button
                        onClick={() => setIsLoggedIn(false)}
                    >
                        Logout
                    </button>

                    :

                    <button
                        onClick={() => setIsLoggedIn(true)}
                    >
                        Login
                    </button>

            }

            <hr />

            {page}

        </div>

    );

}

export default App;