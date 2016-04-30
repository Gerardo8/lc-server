package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.luger.lc.model.GrupoPractica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("grupoPracticaDAO")
public class GrupoPracticaDAOImpl  implements GrupoPracticaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public GrupoPractica findById(Integer id) {
        return (GrupoPractica) sessionFactory.getCurrentSession().get(GrupoPractica.class, id);
    }

    @Override
    public List<GrupoPractica> findByAcademiaCampoId(Integer academiaId, Integer campoClinicoId) {
        return sessionFactory.getCurrentSession().createCriteria(GrupoPractica.class)
                .add(Restrictions.eq("academia.id", academiaId))
                .add(Restrictions.eq("campoClinico.id", campoClinicoId)).list();
    }

    @Override
    public void persist(GrupoPractica grupoPractica) {
        sessionFactory.getCurrentSession().persist(grupoPractica);
    }

    @Override
    public void update(GrupoPractica grupoPractica) {
        sessionFactory.getCurrentSession().update(grupoPractica);
    }

    @Override
    public void delete(GrupoPractica grupoPractica) {
        sessionFactory.getCurrentSession().delete(grupoPractica);
    }

    @Override
    public List<GrupoPractica> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(GrupoPractica.class).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}
