package com.kd.spring.jdbc.service;

import com.kd.spring.jdbc.dao.ActorDao;
import com.kd.spring.jdbc.model.Actor;
import com.kd.spring.jdbc.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    @Qualifier("namedJdbcDao")// Use "jdbcTemplateDao" as qualifier for using jdbcTemplate
    private ActorDao actorDao;

    @Override
    public Actor getActorById(long id) {
        return actorDao.getActorsById(id);
    }

    @Override
    public List<Film> getFilmByActorName(String first_name) {
        return actorDao.getFilmByActorName(first_name).stream().collect(Collectors.toList());
    }

    @Override
    public List<Actor> getActorByActorName(String first_name) {
        return actorDao.getActorsByActorName(first_name).stream().collect(Collectors.toList());
    }

}
