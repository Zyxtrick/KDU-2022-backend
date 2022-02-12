package com.kd.spring.jdbc.hibernate.entity.manyToMany;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="film")
@Data
public class FilmEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private int actorId;

    @NotEmpty(message = "title can not be empty")
    private String title;

    private String description;

    @Column(name = "last_update")
    private String lastUpdate;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    )
    private List<ActorEntity> actors;
}
