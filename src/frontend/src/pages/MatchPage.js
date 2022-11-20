import React, {useContext} from "react";
import "./MatchPage.scss";
import {MatchesContext} from "../context/MatchesContext";
import Match from "../components/Match";

const MatchPage = () => {

    const {matchList} = useContext(MatchesContext);

    return(
        <div className="matchPageContainer">
            <h1>Match Page</h1>
            <ul className="matchList">
                {matchList &&
                matchList.map((m) => {
                    return (
                        <li
                            key={m.id}
                        >
                            <Match matchData={m}/>
                        </li>
                    )
                })}
            </ul>
        </div>

    );
}

export default MatchPage;