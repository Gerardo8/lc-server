package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.luger.lc.model.HorarioGrupoPractica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("horarioGrupoPracticaDAO")
public class HorarioGrupoPracticaDAOImpl implements HorarioGrupoPracticaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public HorarioGrupoPractica findById(Long id) {
        return (HorarioGrupoPractica) sessionFactory.getCurrentSession().get(HorarioGrupoPractica.class, id);
    }

    @Override
    public void persist(HorarioGrupoPractica horarioGrupoPractica) {
        sessionFactory.getCurrentSession().persist(horarioGrupoPractica);
    }

    @Override
    public void update(HorarioGrupoPractica horarioGrupoPractica) {
        sessionFactory.getCurrentSession().update(horarioGrupoPractica);
    }

    @Override
    public void delete(HorarioGrupoPractica horarioGrupoPractica) {
        sessionFactory.getCurrentSession().delete(horarioGrupoPractica);
    }

    @Override
    public List<HorarioGrupoPractica> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(HorarioGrupoPractica.class).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}
