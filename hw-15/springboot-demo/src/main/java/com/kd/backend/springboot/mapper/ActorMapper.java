package com.kd.backend.springboot.mapper;

import com.kd.backend.springboot.dto.ActorDTO;
import com.kd.backend.springboot.dto.FilmDTO;
import com.kd.backend.springboot.entity.Actor;
import com.kd.backend.springboot.entity.Film;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {

    public ActorDTO fromEntity(Actor actor) {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setId(actor.getId());
        actorDTO.setFirstName(actor.getFirstName());
        actorDTO.setLastName(actor.getLastName());
        actorDTO.setLastUpdate(actor.getLastUpdate());
        return actorDTO;
    }

    public Actor toEntity(ActorDTO actorDTO) {
        Actor actor = new Actor();
        actor.setFirstName(actorDTO.getFirstName());
        actor.setLastName(actorDTO.getLastName());
        actor.setLastUpdate(actor.getLastUpdate());
        return actor;
    }
}
