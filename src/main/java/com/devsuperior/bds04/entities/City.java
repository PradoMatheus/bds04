package com.devsuperior.bds04.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_city")
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Event> events = new ArrayList<>();

    public City() {
    }

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }
}
