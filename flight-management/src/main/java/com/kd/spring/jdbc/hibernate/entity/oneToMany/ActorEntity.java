package com.kd.spring.jdbc.hibernate.entity.oneToMany;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "actor")
@Data
public class ActorEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private Long id;

    @NotEmpty(message = "Title can not be empty")
    private String first_name;
    private String last_name;
    private String last_update;

    @ManyToOne
    @JoinColumn(name = "fk_actor_id", referencedColumnName = "actor_id")
    private ActorEntity actor;

}
