import './App.css';
import SearchBar from "./components/SearchBar";
import MatchPage from "./pages/MatchPage";

const App = () => {
    return (
        <div className="App">
            <SearchBar/>
            <MatchPage/>
        </div>
    );
}

export default App;
