package com.kd.spring.jdbc.service;

import com.kd.spring.jdbc.dao.ActorDao;
import com.kd.spring.jdbc.model.Actor;
import com.kd.spring.jdbc.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService{
    @Autowired
    @Qualifier("namedActorJdbcDao")
    private ActorDao actorDao;

    @Override
    public Actor getActorById(int id) {
        return actorDao.getActorById(id);
    }

    @Override
    public List<Actor> getActorByFirstName(String firstName) {
        return actorDao.getActorByFirstName(firstName).stream().collect(Collectors.toList());
    }

    @Override
    public List<Actor> getActorByLastName(String lastName) {
        return actorDao.getActorByLastName(lastName).stream().collect(Collectors.toList());
    }


}