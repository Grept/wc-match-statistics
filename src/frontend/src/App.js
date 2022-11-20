import './App.css';
import SearchBar from "./components/SearchBar";
import MatchPage from "./pages/MatchPage";
import MatchesContextProvider from "./context/MatchesContext";

const App = () => {
    return (
        <div className="App">
            <MatchesContextProvider>
                <SearchBar/>
                <MatchPage/>
            </MatchesContextProvider>
        </div>
    );
}

export default App;
