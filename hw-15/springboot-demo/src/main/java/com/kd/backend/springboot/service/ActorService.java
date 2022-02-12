package com.kd.backend.springboot.service;

import com.kd.backend.springboot.dto.ActorDTO;
import com.kd.backend.springboot.dto.FilmDTO;

public interface ActorService {
    ActorDTO getActorById(Long id);
    ActorDTO createActor(ActorDTO actorDTO);
}
