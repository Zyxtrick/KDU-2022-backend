package com.kd.spring.jdbc.jpa;

import com.kd.spring.jdbc.hibernate.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FilmDaoJPA extends JpaRepository<FilmEntity, Long> {
    List<FilmEntity> findByYear(Long year);

    List<FilmEntity> findByTitleLike(String title);

    Set<FilmEntity> findByYearOrderByTitle(Long year);

    @Query(value = "SELECT * FROM film f WHERE f.release_year = :year AND f.rating like :rating", nativeQuery = true)
    Set<FilmEntity> findByYearAndRatingLike(Long year, String rating);
}
