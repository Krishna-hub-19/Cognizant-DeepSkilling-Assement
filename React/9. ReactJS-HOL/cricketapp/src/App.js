import ListOfPlayers from "./Components/ListOfPlayers";
import IndianPlayers from "./Components/IndianPlayers";

function App() {

    const flag = false;

    if (flag) {
        return <ListOfPlayers />;
    } else {
        return <IndianPlayers />;
    }

}

export default App;