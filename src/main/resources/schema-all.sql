drop table matches IF EXISTS;

create TABLE matches (
    date DATE,
    home_team varchar(255),
    away_team varchar(255),
    home_team_fifa_rank integer,
    away_team_fifa_rank integer,
    home_team_score integer,
    away_team_score integer,
    tournament varchar(255),
    city varchar(255),
    country varchar(255),
    home_team_result varchar(255)
    );