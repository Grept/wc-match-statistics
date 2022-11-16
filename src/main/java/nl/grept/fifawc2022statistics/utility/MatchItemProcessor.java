package nl.grept.fifawc2022statistics.utility;

import nl.grept.fifawc2022statistics.model.Match;
import nl.grept.fifawc2022statistics.model.MatchInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchItemProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchItemProcessor.class);

    @Override
    public Match process(MatchInput matchInput) throws Exception {
        Match match = new Match();

        match.setDate(LocalDate.parse(matchInput.getDate()));

        match.setHomeTeam(matchInput.getHomeTeam());
        match.setAwayTeam(matchInput.getAwayTeam());

        match.setHomeTeamFifaRank(Integer.parseInt(matchInput.getHomeTeamFifaRank()));
        match.setAwayTeamFifaRank(Integer.parseInt(matchInput.getAwayTeamFifaRank()));

        match.setHomeTeamScore(Integer.parseInt(matchInput.getHomeTeamScore()));
        match.setAwayTeamScore(Integer.parseInt(matchInput.getAwayTeamScore()));

        match.setTournament(matchInput.getTournament());
        match.setCity(matchInput.getCity());
        match.setCountry(matchInput.getCountry());
        match.setHomeTeamResult(matchInput.getHomeTeamResult());

        log.info("Converting <" + matchInput.toString() + "> into Match object.");

        return match;
    }
}
