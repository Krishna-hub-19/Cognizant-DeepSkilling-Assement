function ListOfPlayers() {

    const players = [
        { name: "Virat Kohli", score: 95 },
        { name: "Rohit Sharma", score: 88 },
        { name: "Shubman Gill", score: 65 },
        { name: "KL Rahul", score: 55 },
        { name: "Hardik Pandya", score: 72 },
        { name: "Ravindra Jadeja", score: 68 },
        { name: "R Ashwin", score: 45 },
        { name: "Mohammed Shami", score: 35 },
        { name: "Jasprit Bumrah", score: 20 },
        { name: "Mohammed Siraj", score: 18 },
        { name: "Kuldeep Yadav", score: 40 }
    ];

    const lowScorers = players.filter(player => player.score < 70);

    return (

        <div>

            <h2>List of Players</h2>

            <ul>
                {
                    players.map((player, index) => (
                        <li key={index}>
                            {player.name} - {player.score}
                        </li>
                    ))
                }
            </ul>

            <h2>Players with Score below 70</h2>

            <ul>
                {
                    lowScorers.map((player, index) => (
                        <li key={index}>
                            {player.name} - {player.score}
                        </li>
                    ))
                }
            </ul>

        </div>

    );

}

export default ListOfPlayers;