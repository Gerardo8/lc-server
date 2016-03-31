package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.luger.lc.model.HorarioGrupoTeoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("horarioGrupoTeoriaDAO")
public class HorarioGrupoTeoriaDAOImpl implements HorarioGrupoTeoriaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public HorarioGrupoTeoria findById(Long id) {
        return (HorarioGrupoTeoria) sessionFactory.getCurrentSession().get(HorarioGrupoTeoria.class, id);
    }

    @Override
    public void persist(HorarioGrupoTeoria horarioGrupoTeoria) {
        sessionFactory.getCurrentSession().persist(horarioGrupoTeoria);
    }

    @Override
    public void update(HorarioGrupoTeoria horarioGrupoTeoria) {
        sessionFactory.getCurrentSession().update(horarioGrupoTeoria);
    }

    @Override
    public void delete(HorarioGrupoTeoria horarioGrupoTeoria) {
        sessionFactory.getCurrentSession().delete(horarioGrupoTeoria);
    }

    @Override
    public List<HorarioGrupoTeoria> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(HorarioGrupoTeoria.class).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}
