package br.com.velascoluan.formula1.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String team;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private Integer podiums;
    @Column(nullable = false)
    private Integer worldChampionships;
    @Column(nullable = false)
    private Integer grandsPrixEntered;
    @Column(nullable = false)
    private Double points;
}
