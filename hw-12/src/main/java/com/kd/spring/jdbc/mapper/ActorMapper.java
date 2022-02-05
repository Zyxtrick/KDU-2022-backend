package com.kd.spring.jdbc.mapper;

import com.kd.spring.jdbc.model.Actor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper implements RowMapper<Actor> {
    @Override
    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Actor actor = new Actor();
        actor.setActorId(rs.getLong("actor_id"));
        actor.setName(rs.getString("first_name"));
        actor.setLastUpdate(rs.getString("last_update"));
        return actor;
    }
}
