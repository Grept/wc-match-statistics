package nl.grept.fifawc2022statistics.controller;

import nl.grept.fifawc2022statistics.exception.RecordNotFoundException;
import nl.grept.fifawc2022statistics.model.Match;
import nl.grept.fifawc2022statistics.repository.MatchRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchRepository matchRepository;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping()
    public List<Match> getAllMatchesForTeams(@RequestParam("team1") String team1, @RequestParam("team2") String team2) {

        return matchRepository.getAllMatchesForTeams(team1, team2);
    }

    @GetMapping("/{team}")
    public List<Match> getAllMatchesForTeam(@PathVariable("team") String team) {

        return matchRepository.findAllByHomeTeamOrAwayTeam(team, team);
    }

}
