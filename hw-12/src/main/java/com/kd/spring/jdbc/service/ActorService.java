package com.kd.spring.jdbc.service;

import com.kd.spring.jdbc.model.Actor;
import com.kd.spring.jdbc.model.Film;

import java.util.List;
import java.util.Set;

public interface ActorService {

    Actor getActorById(long id);
    List<Film> getFilmByActorName(String first_name);
    List<Actor> getActorByActorName(String first_name);
}
