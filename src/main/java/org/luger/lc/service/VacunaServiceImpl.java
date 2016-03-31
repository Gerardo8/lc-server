package org.luger.lc.service;

import org.luger.lc.dao.VacunaDAO;
import org.luger.lc.model.Vacuna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("vacunaService")
@Transactional
public class VacunaServiceImpl implements VacunaService {

    @Autowired
    private VacunaDAO vacunaDAO;

    @Override
    public Vacuna findById(Long id) {
        return vacunaDAO.findById(id);
    }

    @Override
    public void persist(Vacuna vacuna) {
        vacunaDAO.persist(vacuna);
    }

    @Override
    public void update(Vacuna vacuna) {
        vacunaDAO.update(vacuna);
    }

    @Override
    public void delete(Vacuna vacuna) {
        vacunaDAO.delete(vacuna);
    }

    @Override
    public List<Vacuna> findAll() {
        return vacunaDAO.findAll();
    }

    @Override
    public void deleteAll() {
        vacunaDAO.deleteAll();
    }
}
