package nl.grept.fifawc2022statistics.config;

import nl.grept.fifawc2022statistics.model.Match;
import nl.grept.fifawc2022statistics.model.MatchInput;
import nl.grept.fifawc2022statistics.utility.JobCompletionNotificationListener;
import nl.grept.fifawc2022statistics.utility.MatchItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private final String[] FIELD_NAMES = new String[] {
            "date",
            "home_team",
            "away_team",
            "home_team_fifa_rank",
            "away_team_fifa_rank",
            "home_team_score",
            "away_team_score",
            "tournament",
            "city",
            "country",
            "home_team_result"
    };

    private final String SQL_INSERT_STATEMENT =
            "INSERT INTO matches " +
            "(id, date, home_team, away_team, home_team_fifa_rank, away_team_fifa_rank, home_team_score, away_team_score, tournament, city, country, home_team_result) " +
            "VALUES " +
            "(:id, :date, :homeTeam, :awayTeam, :homeTeamFifaRank, :awayTeamFifaRank, :homeTeamScore, :awayTeamScore, :tournament, :city, :country, :homeTeamResult)";

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<MatchInput> reader() {
        return new FlatFileItemReaderBuilder<MatchInput>()
                .name("matchItemReader")
                .resource(new ClassPathResource("fifa_match-data_2010-2022.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MatchInput>(){{
                    setTargetType(MatchInput.class);
                }})
                .build();
    }

    @Bean
    public MatchItemProcessor processor() {
        return new MatchItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Match>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(SQL_INSERT_STATEMENT)
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importMatchJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importMatchJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Match> writer) {
        return stepBuilderFactory.get("step1")
                .<MatchInput, Match>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }
}
