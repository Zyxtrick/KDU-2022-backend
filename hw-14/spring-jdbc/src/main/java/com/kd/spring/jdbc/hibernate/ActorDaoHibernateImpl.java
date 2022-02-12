package com.kd.spring.jdbc.hibernate;

import com.kd.spring.jdbc.dao.ActorDao;
import com.kd.spring.jdbc.hibernate.entity.onToOne.ActorEntity;
import com.kd.spring.jdbc.mapper.ActorMapper;
import com.kd.spring.jdbc.model.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository("usingActorHibernate")
@Transactional("hibernateTransactionManager")
public class ActorDaoHibernateImpl implements ActorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Actor getActorById(int id) {
        String hql = "FROM ActorEntity a WHERE a.id = :id";
        Session session = sessionFactory.getCurrentSession();
        Query<ActorEntity> query = session.createQuery(hql);
        query.setParameter("id", id);
        return ActorMapper.fromEntity(query.uniqueResult());
    }

    @Override
    public List<Actor> getActorByFirstName(String firstName) {
        String hql = "FROM ActorEntity a WHERE a.first_name = :firstName";
        Session session = sessionFactory.getCurrentSession();
        Query<ActorEntity> query = session.createQuery(hql);
        query.setParameter("firstName", firstName);
        return query.list().stream().map(ActorMapper::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<Actor> getActorByLastName(String lastName) {
        String hql = "FROM ActorEntity a WHERE a.last_name = :lastName";
        Session session = sessionFactory.getCurrentSession();
        Query<ActorEntity> query = session.createQuery(hql);
        query.setParameter("lastName", lastName);
        return query.list().stream().map(ActorMapper::fromEntity).collect(Collectors.toList());
    }
}
