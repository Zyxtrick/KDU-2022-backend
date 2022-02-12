package com.kd.spring.jdbc.dao;

import com.kd.spring.jdbc.mapper.ActorMapper;
import com.kd.spring.jdbc.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("namedActorJdbcDao")
public class ActorDaoNamedParameter implements ActorDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ActorDaoNamedParameter(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public Actor getActorById(int id) {
        Map<String, Object> bindParameters = new HashMap<>();
        bindParameters.put("actorId", id);
        return jdbcTemplate.queryForObject(ActorQueries.GET_ACTOR_BY_ID, bindParameters, new ActorMapper());
    }

    @Override
    public List<Actor> getActorByFirstName(String firstName) {
        Map<String, Object> bindParameters = new HashMap<>();
        bindParameters.put("firstname",firstName);
        return jdbcTemplate.query(ActorQueries.GET_ACTOR_BY_FIRST_NAME,bindParameters,new ActorMapper());
    }

    @Override
    public List<Actor> getActorByLastName(String lastName) {
        Map<String, Object> bindParameters = new HashMap<>();
        bindParameters.put("lastname",lastName);
        return jdbcTemplate.query(ActorQueries.GET_ACTOR_BY_LAST_NAME,bindParameters,new ActorMapper());
    }
}
