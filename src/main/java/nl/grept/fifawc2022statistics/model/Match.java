package nl.grept.fifawc2022statistics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
