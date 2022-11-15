package nl.grept.fifawc2022statistics.utility;

import nl.grept.fifawc2022statistics.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final String SQL_QUERY =
            "SELECT " +
            "date, home_team, away_team, home_team_fifa_rank, away_team_fifa_rank, home_team_score, tournament, city, country, home_team_result " +
            "FROM matches";

    private final JdbcTemplate jdbcTemplate;

    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

//            jdbcTemplate.query(SQL_QUERY, (rs, row) -> new Match(
//                    rs.getString(1),
//                    rs.getString(2)
//            )).forEach(match -> log.info("Found <" + match + "> in the database."));
        }
    }
}
