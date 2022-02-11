package com.kd.spring.jdbc.dao;

import com.kd.spring.jdbc.model.Actor;
import com.kd.spring.jdbc.model.Film;

import java.util.Set;

public interface ActorDao {
    Actor getActorById(int id);
    Set<Actor> getActorByFirstName(String firstName);
    Set<Actor> getActorByLastName(String lastName);
    Set<Film> getFilmByActorName(String actorName);
}