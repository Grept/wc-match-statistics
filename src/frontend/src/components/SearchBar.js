import React from "react";
import  {useForm} from "react-hook-form";
import axios from "axios";

const SearchBar = () => {


    const {register, handleSubmit} = useForm();

    async function requestMatchData(data) {
        const response = await axios.get(`http://localhost:8080/matches?team1=${data.team1}&team2=${data.team2}`);
        console.log(response);
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