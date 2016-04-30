package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.luger.lc.model.Academia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("academiaDAO")
public class AcademiaDAOImpl implements AcademiaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Academia findById(Integer id) {
        return (Academia) sessionFactory.getCurrentSession().get(Academia.class, id);
    }

    @Override
    public void persist(Academia academia) {
        sessionFactory.getCurrentSession().persist(academia);
    }

    @Override
    public void update(Academia academia) {
        sessionFactory.getCurrentSession().update(academia);
    }

    @Override
    public void delete(Academia academia) {
        sessionFactory.getCurrentSession().delete(academia);
    }

    @Override
    public List<Academia> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Academia.class).addOrder(Order.asc("nombre")).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}
