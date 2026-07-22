import React, { useEffect, useState } from "react";
import GitClient from "./GitClient";

function App() {

    const [repos, setRepos] = useState([]);

    useEffect(() => {

        GitClient.getRepositories("techiesyed")

            .then((response) => {

                setRepos(response.data);

            })

            .catch((error) => {

                console.log(error);

            });

    }, []);

    return (

        <div>

            <h1>GitHub Repository List</h1>

            <ul>

                {

                    repos.map((repo) => (

                        <li key={repo.id}>

                            {repo.name}

                        </li>

                    ))

                }

            </ul>

        </div>

    );

}

export default App;