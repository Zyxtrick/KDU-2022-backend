package com.kd.spring.jdbc.jpa;

import com.kd.spring.jdbc.hibernate.entity.oneToOne.ActorEntity;
import com.kd.spring.jdbc.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorDaoJPA extends JpaRepository<ActorEntity, Long> {
    Actor getActorById(Long id);
    List<Actor> getActorByFirstName(String firstName);
    List<Actor> getActorByLastName(String lastName);
}
