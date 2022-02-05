package com.kd.spring.jdbc.dao;

public interface FilmQueries {
    String GET_FILM_BY_ID = "SELECT * FROM film WHERE film_id = ?";

    String GET_FILM_BY_title = "SELECT * FROM film WHERE lower(title) like ?";

    String GET_FILM_BY_YEAR = "SELECT * FROM film WHERE release_year = ?";

    String GET_FILM_BY_ID_NAMED = "SELECT * FROM film WHERE film_id = :filmId";

    String GET_FILM_BY_title_NAMED = "SELECT * FROM film WHERE lower(title) like :title";

    String GET_FILM_BY_YEAR_NAMED = "SELECT * FROM film WHERE release_year = :year";

}
