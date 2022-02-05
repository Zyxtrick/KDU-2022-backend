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
import java.util.List;
import java.util.Set;

@Repository("jdbcTemplateDao")
public class ActorDaoImpl implements ActorDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ActorDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Film> getFilmByActorName(String first_name) {
        return jdbcTemplate.query(ActorQueries.GET_FILMS_BY_ACTOR_NAME,
                new Object[]{first_name},
                new int[]{Types.VARCHAR},
                new FilmMapper());
    }

    @Override
    public Actor getActorsById(Long id) {
        return jdbcTemplate.queryForObject(ActorQueries.GET_ACTOR_BY_ID,
                new Object[]{id},
                new int[]{Types.INTEGER},
                new ActorMapper());
    }

    @Override
    public Set<Actor> getActorsByActorName(String first_name) {
        return new HashSet<>(jdbcTemplate.query(ActorQueries.GET_ACTOR_BY_ACTOR_NAME ,
                new Object[]{first_name},
                new int[]{Types.VARCHAR},
                new ActorMapper()));
    }
}
