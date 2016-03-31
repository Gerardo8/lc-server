package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.luger.lc.model.TelefonoAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("telefonoAlumnoDAO")
public class TelefonoAlumnoDAOImpl implements TelefonoAlumnoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public TelefonoAlumno findById(Long id) {
        return (TelefonoAlumno) sessionFactory.getCurrentSession().get(TelefonoAlumno.class, id);
    }

    @Override
    public void persist(TelefonoAlumno telefonoAlumno) {
        sessionFactory.getCurrentSession().persist(telefonoAlumno);
    }

    @Override
    public void update(TelefonoAlumno telefonoAlumno) {
        sessionFactory.getCurrentSession().update(telefonoAlumno);
    }

    @Override
    public void delete(TelefonoAlumno telefonoAlumno) {
        sessionFactory.getCurrentSession().delete(telefonoAlumno);
    }

    @Override
    public List<TelefonoAlumno> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(TelefonoAlumno.class).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}
