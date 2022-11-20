import React, {createContext, useState} from "react";

export const MatchesContext = createContext({});

const MatchesContextProvider = ({children}) => {

    const [matchList, setMatchList] = useState([]);

    const data = {
        matchList: matchList,
        setMatchList: setMatchList
    };

    return(
        <MatchesContext.Provider value={data}>
            {children}
        </MatchesContext.Provider>
    );
}

export default MatchesContextProvider;