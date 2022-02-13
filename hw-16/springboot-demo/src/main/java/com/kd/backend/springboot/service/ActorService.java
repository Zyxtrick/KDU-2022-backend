package com.kd.backend.springboot.service;

import com.kd.backend.springboot.dto.ActorDTO;

import java.util.List;

public interface ActorService {
    ActorDTO getActorById(Long id);
    ActorDTO createActor(ActorDTO actorDTO);
    List<ActorDTO> getActorByFirstName(String firstName);
    List<ActorDTO> getActorByLastName(String lastName);
}
