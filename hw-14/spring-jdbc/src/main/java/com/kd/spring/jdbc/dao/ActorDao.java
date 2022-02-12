package com.kd.spring.jdbc.dao;

import com.kd.spring.jdbc.model.Actor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Set;

public interface ActorDao {
    Actor getActorById(int id);
    List<Actor> getActorByFirstName(String firstName);
    List<Actor> getActorByLastName(String lastName);

}
