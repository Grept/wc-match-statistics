import React from "react";

const Match = ({matchData}) => {

    console.log(matchData)

    return(
        <div className="matchCard">
            <p>Date: {matchData.date}</p>

        </div>
    );
}

export default Match;