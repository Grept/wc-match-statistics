package nl.grept.fifawc2022statistics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "matches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {

    @Id
    String id;
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
