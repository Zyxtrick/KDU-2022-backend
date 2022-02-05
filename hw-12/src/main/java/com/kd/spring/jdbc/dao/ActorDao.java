package com.kd.spring.jdbc.dao;

import com.kd.spring.jdbc.model.Actor;
import com.kd.spring.jdbc.model.Film;

import java.util.List;
import java.util.Set;

public interface ActorDao {
    List<Film> getFilmByActorName(String first_name);
    Actor getActorsById(Long id);
    Set<Actor> getActorsByActorName(String first_name);
}
