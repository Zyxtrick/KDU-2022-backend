package com.kd.spring.jdbc.dao;

import com.kd.spring.jdbc.model.Film;

import java.util.List;
import java.util.Set;

public interface FilmDao {
    List<Film> getFilmsByYear(Long year);

    Film getFilmById(Long id);

    Set<Film> getFilmByTitle(String title);
}
