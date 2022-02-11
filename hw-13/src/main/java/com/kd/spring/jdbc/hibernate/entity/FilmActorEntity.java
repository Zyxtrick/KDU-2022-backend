package com.kd.spring.jdbc.hibernate.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "actor")
@Data
public class FilmActorEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long actor_id;

    @NotEmpty
    private Long film_id;
    @NotEmpty(message = "Title can not be empty")
    private String last_update;
}
