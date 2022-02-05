package com.kd.spring.jdbc.service;

import com.kd.spring.jdbc.model.Film;

import java.util.List;
import java.util.Set;

public interface FilmService {
    List<Film> getFilmsOfYear(Long year, Integer limit);

    Film getFilmById(Long id);

    Set<Film> getFilmByTitle(String title);
}
