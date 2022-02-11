package com.kd.spring.jdbc.dao;

import com.kd.spring.jdbc.mapper.ActorMapper;
import com.kd.spring.jdbc.mapper.FilmMapper;
import com.kd.spring.jdbc.model.Actor;
import com.kd.spring.jdbc.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashSet;
import java.util.Set;


@Repository("namedActorJdbcDao")

public class ActorDaoImpl implements ActorDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ActorDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Actor getActorById(int id) {
        return jdbcTemplate.queryForObject(ActorQueries.GET_ACTOR_BY_ID,
                new Object[] {id},
                new int[] {Types.INTEGER},
                new ActorMapper()
        );
    }


    public Set<Actor> getActorByFirstName(String firstName){
        return new HashSet<>(jdbcTemplate.query(ActorQueries.GET_ACTOR_BY_FIRST_NAME,
                new Object []{firstName},
                new int[] {Types.VARCHAR},
                new ActorMapper()));
    }

    public Set<Actor> getActorByLastName(String firstName){
        return new HashSet<>(jdbcTemplate.query(ActorQueries.GET_ACTOR_BY_LAST_NAME,
                new Object []{firstName},
                new int[] {Types.VARCHAR},
                new ActorMapper()));
    }

    public Set<Film> getFilmByActorName(String actorName){
        return new HashSet<>((jdbcTemplate.query(ActorQueries.GET_FILMS_BY_ACTOR_NAME,
                new Object []{actorName},
                new int[] {Types.VARCHAR},
                new FilmMapper())));
    }
}