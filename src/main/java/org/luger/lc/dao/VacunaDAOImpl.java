package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.luger.lc.model.Vacuna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("vacunaDAO")
public class VacunaDAOImpl implements VacunaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Vacuna findById(Integer id) {
        return (Vacuna) sessionFactory.getCurrentSession().get(Vacuna.class, id);
    }

    @Override
    public void persist(Vacuna vacuna) {
        sessionFactory.getCurrentSession().persist(vacuna);
    }

    @Override
    public void update(Vacuna vacuna) {
        sessionFactory.getCurrentSession().update(vacuna);
    }

    @Override
    public void delete(Vacuna vacuna) {
        sessionFactory.getCurrentSession().delete(vacuna);
    }

    @Override
    public List<Vacuna> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Vacuna.class).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}
