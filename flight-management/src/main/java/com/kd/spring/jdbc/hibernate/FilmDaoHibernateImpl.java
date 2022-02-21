package com.kd.spring.jdbc.hibernate;

import com.kd.spring.jdbc.dao.FilmDao;
import com.kd.spring.jdbc.hibernate.entity.oneToOne.FilmEntity;
import com.kd.spring.jdbc.mapper.FilmMapper;
import com.kd.spring.jdbc.model.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository("usingHibernate")
@Transactional("hibernateTransactionManager")
public class FilmDaoHibernateImpl implements FilmDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Film> getFilmsByYear(Long year) {
        String hql = "FROM FilmEntity f WHERE f.year = :year";
        Session session = sessionFactory.getCurrentSession();
        Query<FilmEntity> query = session.createQuery(hql);
        query.setParameter("year", year);
        return query.list().stream().map(FilmMapper::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Film getFilmById(Long id) {
        String hql = "FROM FilmEntity f WHERE f.id = :id";
        Session session = sessionFactory.getCurrentSession();
        Query<FilmEntity> query = session.createQuery(hql);
        query.setParameter("id", id);
        return FilmMapper.fromEntity(query.uniqueResult());
    }

    @Override
    public Set<Film> getFilmByTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<FilmEntity> query = builder.createQuery(FilmEntity.class);
        Root<FilmEntity> root = query.from(FilmEntity.class);
        query.select(root).where(builder.like(root.get("title"), title));
        List<FilmEntity> result = session.createQuery(query).getResultList();
        return result
                .stream()
                .map(FilmMapper::fromEntity)
                .collect(Collectors.toSet());
    }
}
