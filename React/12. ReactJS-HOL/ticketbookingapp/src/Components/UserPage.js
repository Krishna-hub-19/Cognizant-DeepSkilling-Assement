function UserPage() {

    return (

        <div>

            <h2>Welcome User</h2>

            <h3>You can now book your flight tickets.</h3>

            <table border="1" cellPadding="8">

                <thead>

                    <tr>
                        <th>Flight</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Time</th>
                        <th>Status</th>
                    </tr>

                </thead>

                <tbody>

                    <tr>
                        <td>AI101</td>
                        <td>Delhi</td>
                        <td>Mumbai</td>
                        <td>09:00 AM</td>
                        <td>
                            <button>Book Ticket</button>
                        </td>
                    </tr>

                    <tr>
                        <td>AI205</td>
                        <td>Chennai</td>
                        <td>Bangalore</td>
                        <td>12:30 PM</td>
                        <td>
                            <button>Book Ticket</button>
                        </td>
                    </tr>

                </tbody>

            </table>

        </div>

    );

}

export default UserPage;