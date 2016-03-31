package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.luger.lc.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("alumnoDAO")
public class AlumnoDAOImpl  implements AlumnoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Alumno findById(Long id) {
        return (Alumno) sessionFactory.getCurrentSession().get(Alumno.class,id);
    }

    @Override
    public Alumno findByNumeroCuenta(String numeroCuenta) {
        return (Alumno) sessionFactory.getCurrentSession().createCriteria(Alumno.class)
                .add(Restrictions.eq("numeroCuenta", numeroCuenta)).uniqueResult();
    }

    @Override
    public void persist(Alumno alumno) {
        sessionFactory.getCurrentSession().persist(alumno);
    }

    @Override
    public void update(Alumno alumno) {
        sessionFactory.getCurrentSession().update(alumno);
    }

    @Override
    public void delete(Alumno alumno) {
        sessionFactory.getCurrentSession().delete(alumno);
    }

    @Override
    public List<Alumno> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Alumno.class).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}
