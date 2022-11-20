import React from "react";
import "./Match.scss";

const Match = ({matchData}) => {

    // console.log(matchData)

    return(
        <div className="matchCard">
            <p>{matchData.tournament}</p>
            <p className="matchCard__date">{matchData.date} | {matchData.city}</p>
            <h3
                className="homeTeam"
                id={matchData.homeTeamResult === "Win" ? "win" : (matchData.homeTeamResult === "Lose" ? "lose" : "draw")}>
                {matchData.homeTeam}

                <span
                    className="score">
                    : {matchData.homeTeamScore}
                </span>
            </h3>

            <h3
                className="awayTeam"
                id={matchData.homeTeamResult === "Win" ? "lose" : (matchData.homeTeamResult === "Lose" ? "win" : "draw")}>
                {matchData.awayTeam}

                <span
                    className="score">
                    : {matchData.awayTeamScore}
                </span>
            </h3>

        </div>
    );
}

export default Match;