function CohortDetails({ cohort }) {

    return (

        <div className="card">

            <h3>{cohort.code}</h3>

            <p>

                Technology :
                {cohort.technology}

            </p>

            <p>

                Trainer :
                {cohort.trainer}

            </p>

            <p>

                Status :
                {cohort.currentStatus}

            </p>

        </div>

    );

}

export default CohortDetails;