import CohortDetails from "./CohortDetails";
import { CohortData } from "./Cohort";

function App() {

    return (

        <div>

            <h1>Cohort Dashboard</h1>

            {

                CohortData.map((cohort) => (

                    <CohortDetails

                        key={cohort.id}

                        cohort={cohort}

                    />

                ))

            }

        </div>

    );

}

export default App;