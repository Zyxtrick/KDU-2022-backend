package com.kd.spring.jdbc.service;

import com.kd.spring.jdbc.model.Actor;

import java.util.List;

public interface ActorService {
    Actor getActorById(int id);
    List<Actor> getActorByFirstName(String firstName);
    List<Actor> getActorByLastName(String lastName);
}
