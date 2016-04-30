package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.luger.lc.model.GrupoTeoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("grupoTeoriaDAO")
public class GrupoTeoriaDAOImpl implements GrupoTeoriaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public GrupoTeoria findById(Integer id) {
        return (GrupoTeoria) sessionFactory.getCurrentSession().get(GrupoTeoria.class, id);
    }

    @Override
    public List<GrupoTeoria> findByAcademiaId(Integer academiaId) {
        return sessionFactory.getCurrentSession().createCriteria(GrupoTeoria.class)
                .add(Restrictions.eq("academia.id", academiaId)).list();
    }

    @Override
    public void persist(GrupoTeoria grupoTeoria) {
        sessionFactory.getCurrentSession().persist(grupoTeoria);
    }

    @Override
    public void update(GrupoTeoria grupoTeoria) {
        sessionFactory.getCurrentSession().update(grupoTeoria);
    }

    @Override
    public void delete(GrupoTeoria grupoTeoria) {
        sessionFactory.getCurrentSession().delete(grupoTeoria);
    }

    @Override
    public List<GrupoTeoria> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(GrupoTeoria.class).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}
