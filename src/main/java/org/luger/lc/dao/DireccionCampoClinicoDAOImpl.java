package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.luger.lc.model.DireccionCampoClinico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("direccionCampoClinicoDAO")
public class DireccionCampoClinicoDAOImpl implements DireccionCampoClinicoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public DireccionCampoClinico findById(Long id) {
        return (DireccionCampoClinico) sessionFactory.getCurrentSession().get(DireccionCampoClinico.class, id);
    }

    @Override
    public void persist(DireccionCampoClinico direccionCampoClinico) {
        sessionFactory.getCurrentSession().persist(direccionCampoClinico);
    }

    @Override
    public void update(DireccionCampoClinico direccionCampoClinico) {
        sessionFactory.getCurrentSession().update(direccionCampoClinico);
    }

    @Override
    public void delete(DireccionCampoClinico direccionCampoClinico) {
        sessionFactory.getCurrentSession().delete(direccionCampoClinico);
    }

    @Override
    public List<DireccionCampoClinico> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(DireccionCampoClinico.class).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}
