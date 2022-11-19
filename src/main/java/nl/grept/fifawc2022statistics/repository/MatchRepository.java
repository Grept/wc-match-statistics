package nl.grept.fifawc2022statistics.repository;

import nl.grept.fifawc2022statistics.model.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match, String> {

    @Query("select m from Match m where (" +
            "(m.homeTeam = :homeTeam) and (m.awayTeam = :awayTeam)) or " +
            "(m.homeTeam = :awayTeam) and (m.awayTeam = :homeTeam)")
    List<Match> getAllMatchesForTeams(String homeTeam, String awayTeam);

    List<Match> findAllByHomeTeamOrAwayTeam(String homeTeam, String awayTeam);

//    Match findById(String id);
}
