function App() {

  const officeSpaces = [

    {
      id: 1,
      name: "Cyber Hub",
      rent: 75000,
      address: "Hyderabad",
      image: "/office.jpg"
    },

    {
      id: 2,
      name: "Corporate Plaza",
      rent: 45000,
      address: "Chennai",
      image: "/plaza.jpg"
    }

  ];

  return (

    <div style={{ margin: "20px" }}>

      <h1>Office Space Rental App</h1>

      {

        officeSpaces.map((office) => (

          <div
            key={office.id}
            style={{
              border: "1px solid gray",
              padding: "15px",
              marginBottom: "20px",
              width: "350px"
            }}
          >

            <img
              src={office.image}
              alt={office.name}
              width="300"
              height="180"
            />

            <h2>{office.name}</h2>

            <h3
              style={{
                color: office.rent < 60000 ? "red" : "green"
              }}
            >
              Rent: ₹{office.rent}
            </h3>

            <h3>Address: {office.address}</h3>

          </div>

        ))

      }

    </div>

  );

}

export default App;