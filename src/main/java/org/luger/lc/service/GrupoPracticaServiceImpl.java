package org.luger.lc.service;

import org.luger.lc.dao.GrupoPracticaDAO;
import org.luger.lc.dao.HorarioGrupoPracticaDAO;
import org.luger.lc.model.GrupoPractica;
import org.luger.lc.model.HorarioGrupoPractica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("grupoPracticaService")
@Transactional
public class GrupoPracticaServiceImpl implements GrupoPracticaService {

    @Autowired
    private GrupoPracticaDAO grupoPracticaDAO;
    @Autowired
    private HorarioGrupoPracticaDAO horarioGrupoPracticaDAO;

    @Override
    public GrupoPractica findById(Long id) {
        return grupoPracticaDAO.findById(id);
    }

    @Override
    public List<GrupoPractica> findByAcademiaCampoId(Long academiaId, Long campoClinicoId) {
        return grupoPracticaDAO.findByAcademiaCampoId(academiaId,campoClinicoId);
    }

    @Override
    public void persist(GrupoPractica grupoPractica,HorarioGrupoPractica horarioGrupoPractica) {
        grupoPracticaDAO.persist(grupoPractica);
        horarioGrupoPracticaDAO.persist(horarioGrupoPractica);
    }

    @Override
    public void update(GrupoPractica grupoPractica) {
        grupoPracticaDAO.update(grupoPractica);
    }

    @Override
    public void delete(GrupoPractica grupoPractica) {
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
