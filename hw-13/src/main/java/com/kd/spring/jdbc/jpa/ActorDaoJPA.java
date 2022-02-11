package com.kd.spring.jdbc.jpa;

import com.kd.spring.jdbc.hibernate.entity.ActorEntity;
import com.kd.spring.jdbc.hibernate.entity.FilmEntity;
import com.kd.spring.jdbc.model.Actor;
import com.kd.spring.jdbc.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ActorDaoJPA extends JpaRepository<ActorEntity, Long> {
    Actor getActorById(Long id);
    List<Actor> getActorByFirstName(String firstName);
    List<Actor> getActorByLastName(String lastName);
    List<Film> getFilmByActorName(String actorName);
}
