package com.kd.spring.jdbc.mapper;
import com.kd.spring.jdbc.hibernate.entity.ActorEntity;
import com.kd.spring.jdbc.hibernate.entity.FilmEntity;
import com.kd.spring.jdbc.model.Actor;
import com.kd.spring.jdbc.model.Film;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper implements RowMapper<Actor> {

    @Override
    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Actor actor = new Actor();
        actor.setActorId(rs.getLong("actor_id"));
        actor.setFirstName(rs.getString("first_name"));
        actor.setLastName(rs.getString("last_name"));
        actor.setLastUpdate(rs.getString("last_update"));
        return actor;
    }

    public static Actor fromEntity(ActorEntity entity) {
        Actor actor = new Actor();
        actor.setActorId(entity.getId());
        actor.setFirstName(entity.getFirst_name());
        actor.setLastName(entity.getLast_name());
        actor.setLastUpdate(entity.getLast_update());
        return actor;
    }
}