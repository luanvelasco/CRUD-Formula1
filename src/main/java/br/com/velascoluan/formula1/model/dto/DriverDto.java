package br.com.velascoluan.formula1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class DriverDto extends RepresentationModel<DriverDto> {

    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String name;
    private String team;
    private String country;
    private Integer podiums;
    private Integer worldChampionships;
    private Integer grandsPrixEntered;
    private Double points;
}
