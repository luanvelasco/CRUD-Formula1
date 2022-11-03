package br.com.velascoluan.formula1.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverDto {
    private Long id;
    private String name;
    private String team;
    private String country;
    private Integer podiums;
    private Integer worldChampionships;
    private Integer grandsPrixEntered;
    private Double points;
}
