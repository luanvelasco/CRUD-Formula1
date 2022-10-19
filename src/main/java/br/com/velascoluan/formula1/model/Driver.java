package br.com.velascoluan.formula1.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String team;
    private String country;
    private Integer podiums;
    private Integer worldChampionships;
    private Integer grandsPrixEntered;
    private Double points;

    public Driver(String name, String team, String country, Integer podiums, Integer worldChampionships, Integer grandsPrixEntered, Double points) {
        this.name = name;
        this.team = team;
        this.country = country;
        this.podiums = podiums;
        this.worldChampionships = worldChampionships;
        this.grandsPrixEntered = grandsPrixEntered;
        this.points = points;
    }
}
