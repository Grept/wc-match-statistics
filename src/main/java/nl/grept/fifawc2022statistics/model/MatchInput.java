package nl.grept.fifawc2022statistics.model;

import lombok.Data;

@Data
public class MatchInput {

    String date;
    String homeTeam;
    String awayTeam;
    String homeTeamFifaRank;
    String awayTeamFifaRank;
    String homeTeamScore;
    String awayTeamScore;
    String tournament;
    String city;
    String country;
    String homeTeamResult;

    @Override
    public String toString() {
        return "MatchInput{" +
                homeTeam + "\t\t\t" + homeTeamScore +
                " - " +
                awayTeamScore + "\t\t" + awayTeam +
                "}";
    }
}
