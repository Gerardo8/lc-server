package org.luger.lc.service;

import org.luger.lc.dao.HorarioGrupoPracticaDAO;
import org.luger.lc.model.HorarioGrupoPractica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("horarioGrupoPracticaService")
@Transactional
public class HorarioGrupoPracticaServiceImpl implements HorarioGrupoPracticaService {

    @Autowired
    private HorarioGrupoPracticaDAO horarioGrupoPracticaDAO;

    @Override
    public HorarioGrupoPractica findById(Long id) {
        return horarioGrupoPracticaDAO.findById(id);
    }

    @Override
    public void persist(HorarioGrupoPractica horarioGrupoPractica) {
        horarioGrupoPracticaDAO.persist(horarioGrupoPractica);
    }

    @Override
    public void update(HorarioGrupoPractica horarioGrupoPractica) {
        horarioGrupoPracticaDAO.update(horarioGrupoPractica);
    }

    @Override
    public void delete(HorarioGrupoPractica horarioGrupoPractica) {
        horarioGrupoPracticaDAO.delete(horarioGrupoPractica);
    }

    @Override
    public List<HorarioGrupoPractica> findAll() {
        return horarioGrupoPracticaDAO.findAll();
    }

    @Override
    public void deleteAll() {
        horarioGrupoPracticaDAO.deleteAll();
    }
}
