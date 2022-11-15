package nl.grept.fifawc2022statistics.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Match {

    LocalDate date;
    String homeTeam;
    String awayTeam;
    Integer homeTeamFifaRank;
    Integer awayTeamFifaRank;
    Integer homeTeamScore;
    Integer awayTeamScore;
    String tournament;
    String city;
    String country;
    String homeTeamResult;

    @Override
    public String toString() {
        return "Match{ " +
                homeTeam + "\t" + homeTeamScore +
                " - " +
                awayTeamScore + "\t" + awayTeam +
                " }";
    }
}
