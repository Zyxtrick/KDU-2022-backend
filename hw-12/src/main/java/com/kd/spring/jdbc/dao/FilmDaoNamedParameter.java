package com.kd.spring.jdbc.dao;

import com.kd.spring.jdbc.mapper.FilmMapper;
import com.kd.spring.jdbc.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository("namedJdbcDao")
public class FilmDaoNamedParameter implements FilmDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public FilmDaoNamedParameter(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Film> getFilmsByYear(Long year) {
        Map<String, Object> bindParameters = new HashMap<>();
        bindParameters.put("year", year);
        return jdbcTemplate.query(FilmQueries.GET_FILM_BY_YEAR_NAMED, bindParameters, new FilmMapper());

    }

    @Override
    public Film getFilmById(Long id) {
        Map<String, Object> bindParameters = new HashMap<>();
        bindParameters.put("filmId", id);
        return jdbcTemplate.queryForObject(FilmQueries.GET_FILM_BY_ID_NAMED, bindParameters, new FilmMapper());
    }

    @Override
    public Set<Film> getFilmByTitle(String title) {
        return null;
    }
}
