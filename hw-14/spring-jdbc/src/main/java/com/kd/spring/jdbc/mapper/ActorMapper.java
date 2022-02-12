package com.kd.spring.jdbc.mapper;

import com.kd.spring.jdbc.hibernate.entity.onToOne.ActorEntity;
import com.kd.spring.jdbc.model.Actor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper implements RowMapper<Actor> {
    @Override
    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Actor actor = new Actor();
        actor.setActorId(rs.getInt("actor_id"));
        actor.setFirstName(rs.getString("first_name"));
        actor.setLastName(rs.getString("last_name"));
        actor.setLastUpdate(rs.getString("last_update"));
        return actor;
    }

    public static Actor fromEntity(ActorEntity entity) {
        Actor actor= new Actor();
        actor.setActorId(entity.getActorId());
        actor.setFirstName(entity.getFirstName());
        actor.setLastName(entity.getLastName());
        actor.setLastUpdate(entity.getLastUpdate());
        return actor;
    }
}