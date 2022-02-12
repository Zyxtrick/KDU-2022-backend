package com.kd.spring.jdbc.jpa;

import com.kd.spring.jdbc.hibernate.entity.onToOne.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ActorDaoJPA extends JpaRepository<ActorEntity, Long> {
    ActorEntity findByActorId(int id);

    List<ActorEntity> findByFirstName(String firstName);

    Set<ActorEntity> findByLastName(String lastName);
}
