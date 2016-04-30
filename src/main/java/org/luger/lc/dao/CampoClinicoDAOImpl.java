package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.luger.lc.model.CampoClinico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("campoClinicoDAO")
public class CampoClinicoDAOImpl  implements CampoClinicoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CampoClinico findById(Integer id) {
        return (CampoClinico) sessionFactory.getCurrentSession().get(CampoClinico.class, id);
    }

    @Override
    public void persist(CampoClinico campoClinico) {
        sessionFactory.getCurrentSession().persist(campoClinico);
    }

    @Override
    public void update(CampoClinico campoClinico) {
        sessionFactory.getCurrentSession().update(campoClinico);
    }

    @Override
    public void delete(CampoClinico campoClinico) {
        sessionFactory.getCurrentSession().delete(campoClinico);
    }

    @Override
    public List<CampoClinico> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(CampoClinico.class).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}
