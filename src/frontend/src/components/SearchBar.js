import React, {useContext} from "react";
import  {useForm} from "react-hook-form";
import axios from "axios";
import "./SearchBar.scss";
import {MatchesContext} from "../context/MatchesContext";

const SearchBar = () => {


    const {register, handleSubmit} = useForm();

    const {setMatchList, initialMatchListState} = useContext(MatchesContext);

    async function requestMatchData(data) {
        const response = await axios.get(`http://localhost:8080/matches?team1=${data.team1}&team2=${data.team2}`);
        if (response.data.size === 0) {
            setMatchList(initialMatchListState);
        } else {
            console.log("Setting matchList")
            setMatchList(response.data)
        }
        // console.log(response.data);

    }

    return(
        <div className="searchBar">
            <h4>Searchbar</h4>
            <form className="seachForm" onSubmit={handleSubmit(requestMatchData)}>
                <input type="text" name="team1" placeholder="team1" {...register("team1")}/>
                <input type="text" name="team2" placeholder="team2" {...register("team2")}/>
                <button className="submitButton" type="submit">search</button>
            </form>
        </div>
    );
}

export default SearchBar;