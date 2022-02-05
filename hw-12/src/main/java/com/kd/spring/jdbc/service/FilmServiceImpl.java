package com.kd.spring.jdbc.service;

import com.kd.spring.jdbc.dao.FilmDao;
import com.kd.spring.jdbc.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    @Qualifier("namedJdbcDao")// Use "jdbcTemplateDao" as qualifier for using jdbcTemplate
    private FilmDao filmDao;

    @Override
    public List<Film> getFilmsOfYear(Long year, Integer limit) {
        return filmDao.getFilmsByYear(year).stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public Film getFilmById(Long id) {
        return filmDao.getFilmById(id);
    }

    @Override
    public Set<Film> getFilmByTitle(String title) {
        return filmDao.getFilmByTitle(title);
    }
}
