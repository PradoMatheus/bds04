package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.City;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
public class CityDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String name;

    public CityDto() {
    }

    public CityDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDto(City entity) {
        id = entity.getId();
        name = entity.getName();
    }
}
