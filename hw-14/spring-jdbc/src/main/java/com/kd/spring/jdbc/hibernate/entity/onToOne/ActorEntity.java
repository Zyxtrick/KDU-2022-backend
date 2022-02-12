package com.kd.spring.jdbc.hibernate.entity.onToOne;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Entity
@Table(name="actor")
@Data
public class ActorEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private int actorId;

    @NotEmpty(message = "First name can not be empty")
    @Column(name="first_name")
    private String firstName;

    @NotEmpty(message = "Last Name can not be empty")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_update")
    private String lastUpdate;

    @OneToOne(optional = false)
    @JoinColumn(name = "fk_actor_id", referencedColumnName = "actor_id")
    private FilmActorEntity filmActorEntity;

}
