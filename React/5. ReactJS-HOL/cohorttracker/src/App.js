import CohortDetails from "./Components/CohortDetails";

function App() {
  return (
    <div>
      <h1>Cohorts Details</h1>

      <CohortDetails
        cohortName="INTADMDF10 - .NET FSD"
        startedOn="22-Feb-2022"
        currentStatus="Scheduled"
        coach="Aasthma"
        trainer="Jojo Jose"
      />

      <CohortDetails
        cohortName="ADM21JF014 - Java FSD"
        startedOn="10-Sep-2021"
        currentStatus="Ongoing"
        coach="Apoorv"
        trainer="Elisa Smith"
      />

      <CohortDetails
        cohortName="CDBJF21025 - Java FSD"
        startedOn="24-Dec-2021"
        currentStatus="Ongoing"
        coach="Aasthma"
        trainer="John Doe"
      />
    </div>
  );
}

export default App;