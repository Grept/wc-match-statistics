package nl.grept.fifawc2022statistics.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String countryName;

    @Transient
    private List<Match> matches;
}
