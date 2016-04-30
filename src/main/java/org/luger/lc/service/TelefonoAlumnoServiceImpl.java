package org.luger.lc.service;

import org.luger.lc.dao.TelefonoAlumnoDAO;
import org.luger.lc.model.TelefonoAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("telefonoAlumnoService")
@Transactional
public class TelefonoAlumnoServiceImpl implements TelefonoAlumnoService {

    @Autowired
    private TelefonoAlumnoDAO telefonoAlumnoDAO;

    @Override
    public TelefonoAlumno findById(Integer id) {
        return telefonoAlumnoDAO.findById(id);
    }

    @Override
    public void persist(TelefonoAlumno telefonoAlumno) {
        telefonoAlumnoDAO.persist(telefonoAlumno);
    }

    @Override
    public void update(TelefonoAlumno telefonoAlumno) {
        telefonoAlumnoDAO.update(telefonoAlumno);
    }

    @Override
    public void delete(Integer id) {
        TelefonoAlumno telefonoAlumno = telefonoAlumnoDAO.findById(id);
        telefonoAlumnoDAO.delete(telefonoAlumno);
    }

    @Override
    public List<TelefonoAlumno> findAll() {
        return telefonoAlumnoDAO.findAll();
    }

    @Override
    public void deleteAll() {
        telefonoAlumnoDAO.deleteAll();
    }
}
