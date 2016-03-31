package org.luger.lc.service;

import org.luger.lc.dao.GrupoTeoriaDAO;
import org.luger.lc.dao.HorarioGrupoTeoriaDAO;
import org.luger.lc.model.GrupoTeoria;
import org.luger.lc.model.HorarioGrupoTeoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("grupoTeoriaService")
@Transactional
public class GrupoTeoriaServiceImpl implements GrupoTeoriaService {

    @Autowired
    private GrupoTeoriaDAO grupoTeoriaDAO;
    @Autowired
    private HorarioGrupoTeoriaDAO horarioGrupoTeoriaDAO;

    @Override
    public GrupoTeoria findById(Long id) {
        return grupoTeoriaDAO.findById(id);
    }

    @Override
    public List<GrupoTeoria> findByAcademiaId(Long academiaId) {
        return grupoTeoriaDAO.findByAcademiaId(academiaId);
    }

    @Override
    public void persist(GrupoTeoria grupoTeoria,HorarioGrupoTeoria horarioGrupoTeoria) {
        grupoTeoriaDAO.persist(grupoTeoria);
        horarioGrupoTeoriaDAO.persist(horarioGrupoTeoria);
    }

    @Override
    public void update(GrupoTeoria grupoTeoria) {
        grupoTeoriaDAO.update(grupoTeoria);
    }

    @Override
    public void delete(GrupoTeoria grupoTeoria) {
        grupoTeoriaDAO.delete(grupoTeoria);
    }

    @Override
    public List<GrupoTeoria> findAll() {
        return grupoTeoriaDAO.findAll();
    }

    @Override
    public void deleteAll() {
        grupoTeoriaDAO.deleteAll();
    }
}
