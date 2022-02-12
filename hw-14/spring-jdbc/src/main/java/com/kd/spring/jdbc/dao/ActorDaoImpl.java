package com.kd.spring.jdbc.dao;

import com.kd.spring.jdbc.mapper.ActorMapper;
import com.kd.spring.jdbc.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("jdbcActorTemplateDao")
public class ActorDaoImpl implements ActorDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ActorDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Actor getActorById(int id) {
        return jdbcTemplate.queryForObject(ActorQueries.GET_ACTOR_BY_ID,
                new Object[]{id},
                new int[]{Types.INTEGER},
                new ActorMapper()
        );
    }
    public List<Actor> getActorByFirstName(String firstName){
        return jdbcTemplate.query(ActorQueries.GET_ACTOR_BY_FIRST_NAME,
                new Object []{firstName},
                new int[] {Types.VARCHAR},
                new ActorMapper());
    }

    public List<Actor> getActorByLastName(String firstName){
        return jdbcTemplate.query(ActorQueries.GET_ACTOR_BY_LAST_NAME,
                new Object []{firstName},
                new int[] {Types.VARCHAR},
                new ActorMapper());
    }
}
