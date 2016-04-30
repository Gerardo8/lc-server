package org.luger.lc.service;

import org.luger.lc.dao.GrupoPracticaDAO;
import org.luger.lc.model.GrupoPractica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("grupoPracticaService")
@Transactional
public class GrupoPracticaServiceImpl implements GrupoPracticaService {

    @Autowired
    private GrupoPracticaDAO grupoPracticaDAO;

    @Override
    public GrupoPractica findById(Integer id) {
        return grupoPracticaDAO.findById(id);
    }

    @Override
    public List<GrupoPractica> findByAcademiaCampoId(Integer academiaId, Integer campoClinicoId) {
        return grupoPracticaDAO.findByAcademiaCampoId(academiaId,campoClinicoId);
    }

    @Override
    public void persist(GrupoPractica grupoPractica) {
        grupoPracticaDAO.persist(grupoPractica);
    }

    @Override
    public void update(GrupoPractica grupoPractica) {
        grupoPracticaDAO.update(grupoPractica);
    }

    @Override
    public void delete(Integer id) {
        GrupoPractica grupoPractica = grupoPracticaDAO.findById(id);
        grupoPracticaDAO.delete(grupoPractica);
    }

    @Override
    public List<GrupoPractica> findAll() {
        return grupoPracticaDAO.findAll();
    }

    @Override
    public void deleteAll() {
        grupoPracticaDAO.deleteAll();
    }
}
