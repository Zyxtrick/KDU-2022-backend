package com.kd.backend.springboot.repository;

import com.kd.backend.springboot.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    Optional<Actor> findById(Long id);

    List<Actor> findByFirstName(String firstName);

    List<Actor> findByLastName(String lastName);

}
