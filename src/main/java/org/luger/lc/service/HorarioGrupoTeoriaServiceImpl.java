package org.luger.lc.service;

import org.luger.lc.dao.HorarioGrupoTeoriaDAO;
import org.luger.lc.model.HorarioGrupoTeoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("horarioGrupoTeoriaService")
@Transactional
public class HorarioGrupoTeoriaServiceImpl implements HorarioGrupoTeoriaService {

    @Autowired
    private HorarioGrupoTeoriaDAO horarioGrupoTeoriaDAO;

    @Override
    public HorarioGrupoTeoria findById(Long id) {
        return horarioGrupoTeoriaDAO.findById(id);
    }

    @Override
    public void persist(HorarioGrupoTeoria horarioGrupoTeoria) {
        horarioGrupoTeoriaDAO.persist(horarioGrupoTeoria);
    }

    @Override
    public void update(HorarioGrupoTeoria horarioGrupoTeoria) {
        horarioGrupoTeoriaDAO.update(horarioGrupoTeoria);
    }

    @Override
    public void delete(HorarioGrupoTeoria horarioGrupoTeoria) {
        horarioGrupoTeoriaDAO.delete(horarioGrupoTeoria);
    }

    @Override
    public List<HorarioGrupoTeoria> findAll() {
        return horarioGrupoTeoriaDAO.findAll();
    }

    @Override
    public void deleteAll() {
        horarioGrupoTeoriaDAO.deleteAll();
    }
}
