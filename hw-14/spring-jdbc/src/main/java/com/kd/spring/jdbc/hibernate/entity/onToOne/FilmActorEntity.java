package com.kd.spring.jdbc.hibernate.entity.onToOne;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name ="film_actor")
@Data
public class FilmActorEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name ="actor_id")
    private int actorId;

    @Column(name = "film_id")
    @NotEmpty
    private int filmId;

    @Column(name =" last_update")
    private int lastUpdate;
}
