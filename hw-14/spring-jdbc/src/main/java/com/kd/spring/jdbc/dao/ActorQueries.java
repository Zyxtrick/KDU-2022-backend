package com.kd.spring.jdbc.dao;

public interface ActorQueries {
    String GET_ACTOR_BY_ID = "SELECT * from actor WHERE actor_id = ? ";
    String GET_ACTOR_BY_FIRST_NAME = "SELECT * from actor where lower(first_name) like ?";
    String GET_ACTOR_BY_LAST_NAME = "SELECT * from actor where lower(last_name) like ? ";
}
