package com.kd.spring.jdbc.service;

import com.kd.spring.jdbc.jpa.ActorDaoJPA;
import com.kd.spring.jdbc.mapper.ActorMapper;
import com.kd.spring.jdbc.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("usingActorJpa")
@Transactional("transactionManager")
public class ActorServiceJpa implements ActorService{

    @Autowired
    // Use "jdbcTemplateDao" as qualifier for using jdbcTemplate
    private ActorDaoJPA actorDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
    public Actor getActorById(int id) {
//        return actorDao.findByActorId(id).map(ActorMapper::fromEntity)
//                .orElse(null);
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
    public List<Actor> getActorByFirstName(String firstName) {
        return actorDao.findByFirstName(firstName)
                .stream()
                .map(ActorMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
    public List<Actor> getActorByLastName(String lastName) {
        return actorDao.findByLastName(lastName)
                .stream()
                .map(ActorMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
