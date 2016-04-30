package org.luger.lc.service;

import org.luger.lc.dao.GrupoTeoriaDAO;
import org.luger.lc.model.GrupoTeoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("grupoTeoriaService")
@Transactional
public class GrupoTeoriaServiceImpl implements GrupoTeoriaService {

    @Autowired
    private GrupoTeoriaDAO grupoTeoriaDAO;

    @Override
    public GrupoTeoria findById(Integer id) {
        return grupoTeoriaDAO.findById(id);
    }

    @Override
    public List<GrupoTeoria> findByAcademiaId(Integer academiaId) {
        return grupoTeoriaDAO.findByAcademiaId(academiaId);
    }

    @Override
    public void persist(GrupoTeoria grupoTeoria) {
        grupoTeoriaDAO.persist(grupoTeoria);
    }

    @Override
    public void update(GrupoTeoria grupoTeoria) {
        grupoTeoriaDAO.update(grupoTeoria);
    }

    @Override
    public void delete(Integer id) {
        GrupoTeoria grupoTeoria = grupoTeoriaDAO.findById(id);
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
