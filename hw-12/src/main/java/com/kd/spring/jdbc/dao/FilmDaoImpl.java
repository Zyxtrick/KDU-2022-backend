package com.kd.spring.jdbc.dao;

import com.kd.spring.jdbc.mapper.FilmMapper;
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
public class FilmDaoImpl implements FilmDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FilmDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Film> getFilmsByYear(Long year) {
        return jdbcTemplate.query(FilmQueries.GET_FILM_BY_YEAR,
                new Object[]{year},
                new int[]{Types.INTEGER},
                new FilmMapper());
    }

    @Override
    public Film getFilmById(Long id) {
        return jdbcTemplate.queryForObject(FilmQueries.GET_FILM_BY_ID,
                new Object[]{id},
                new int[]{Types.INTEGER},
                new FilmMapper());
    }

    @Override
    public Set<Film> getFilmByTitle(String title) {
        return new HashSet<>(jdbcTemplate.query(FilmQueries.GET_FILM_BY_title,
                new Object[]{title},
                new int[]{Types.VARCHAR},
                new FilmMapper()));
    }
}
