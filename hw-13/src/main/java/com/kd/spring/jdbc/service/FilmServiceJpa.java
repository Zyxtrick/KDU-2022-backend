package com.kd.spring.jdbc.service;

import com.kd.spring.jdbc.dao.FilmDao;
import com.kd.spring.jdbc.jpa.FilmDaoJPA;
import com.kd.spring.jdbc.mapper.FilmMapper;
import com.kd.spring.jdbc.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("usingJpa")
@Transactional("transactionManager")
public class FilmServiceJpa implements FilmService {

    @Autowired
    private FilmDaoJPA filmDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "transactionManager")
    public List<Film> getFilmsOfYear(Long year, Integer limit) {
        return filmDao.findByYear(year)
                .stream()
                .map(FilmMapper::fromEntity)
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public Film getFilmById(Long id) {
        return filmDao.findById(id)
                .map(FilmMapper::fromEntity)
                .orElse(null);
    }

    @Override
    public Set<Film> getFilmByTitle(String title) {
        return filmDao.findByTitleLike(title)
                .stream()
                .map(FilmMapper::fromEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Film> getFilmByYearAndRating(Long year, String rating) {
        return filmDao.findByYearAndRatingLike(year, rating)
                .stream()
                .map(FilmMapper::fromEntity)
                .collect(Collectors.toSet());
    }
}
