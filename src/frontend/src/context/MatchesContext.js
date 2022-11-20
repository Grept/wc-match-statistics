import React, {createContext, useEffect, useState} from "react";

export const MatchesContext = createContext({});

const MatchesContextProvider = ({children}) => {

    const initialMatchListState = [{
        homeTeam: "team1",
        awayTeam: "team2",
        date: "Date",
        homeTeamResult: "Draw",
        city: "City",
        tournament: "Tournament"
    }]

    const [matchList, setMatchList] = useState(initialMatchListState);

    useEffect(() => {
        console.log("Logging 'matchList'>")
        console.log(matchList)
    }, [matchList])

    const data = {
        matchList: matchList,
        setMatchList: setMatchList,
        initialMatchListState: initialMatchListState
    };

    return(
        <MatchesContext.Provider value={data}>
            {children}
        </MatchesContext.Provider>
    );
}

export default MatchesContextProvider;