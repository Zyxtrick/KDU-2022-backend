package com.kd.spring.jdbc.model;

import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class Film {
    private Long filmId;
    private String title;
    private String description;
    private Long year;
    private String rating;

    @OneToOne
    private Actor actor;
}
