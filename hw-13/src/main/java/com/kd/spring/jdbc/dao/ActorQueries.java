package com.kd.spring.jdbc.dao;

public interface ActorQueries {
    String GET_ACTOR_BY_ID = "SELECT * from actor WHERE actor_id = ? ";
    String GET_ACTOR_BY_FIRST_NAME = "SELECT * from actor where lower(first_name) like ?";
    String GET_ACTOR_BY_LAST_NAME = "SELECT * from actor where lower(last_name) like ? ";
    String GET_FILMS_BY_ACTOR_NAME = "SELECT film.* from actor inner join film_actor on actor.actor_id = film_actor.actor_id inner join film on film_actor.film_id = film.film_id where lower(first_name) like ?";
}