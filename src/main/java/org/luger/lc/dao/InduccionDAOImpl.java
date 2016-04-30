package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.luger.lc.model.Induccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Gerrard on 24/04/16.
 */
@SuppressWarnings("unchecked")
@Repository("induccionDAO")
public class InduccionDAOImpl implements InduccionDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Induccion findById(Integer id) {
        return (Induccion) sessionFactory.getCurrentSession().get(Induccion.class, id);
    }

    @Override
    public void persist(Induccion induccion) {
        sessionFactory.getCurrentSession().persist(induccion);
    }

    @Override
    public void update(Induccion induccion) {
        sessionFactory.getCurrentSession().update(induccion);
    }

    @Override
    public void delete(Induccion induccion) {
        sessionFactory.getCurrentSession().delete(induccion);
    }

    @Override
    public List<Induccion> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Induccion.class).list();
    }

    @Override
    public List<Induccion> findByAcademiaId(Integer academiaId) {
        return sessionFactory.getCurrentSession().createCriteria(Induccion.class).add(Restrictions.eq("academia.id", academiaId)).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}
