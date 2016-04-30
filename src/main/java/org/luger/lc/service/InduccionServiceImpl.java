package org.luger.lc.service;

import org.luger.lc.dao.AcademiaDAO;
import org.luger.lc.dao.InduccionDAO;
import org.luger.lc.model.Induccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Gerrard on 24/04/16.
 */
@Service("induccionService")
@Transactional
public class InduccionServiceImpl implements InduccionService {

    @Autowired
    private InduccionDAO induccionDAO;
    @Autowired
    private AcademiaDAO academiaDAO;

    @Override
    public Induccion findById(Integer id) {
        return induccionDAO.findById(id);
    }

    @Override
    public void persist(Induccion induccion,Integer academiaId) {
        induccion.setAcademia(academiaDAO.findById(academiaId));
        induccionDAO.persist(induccion);
    }

    @Override
    public void update(Induccion induccion) {
        induccionDAO.update(induccion);
    }

    @Override
    public void delete(Integer id) {
        Induccion induccion = induccionDAO.findById(id);
        induccionDAO.delete(induccion);
    }

    @Override
    public List<Induccion> findAll() {
        return induccionDAO.findAll();
    }

    @Override
    public List<Induccion> findByAcademiaId(Integer academiaId) {
        return induccionDAO.findByAcademiaId(academiaId);
    }

    @Override
    public void deleteAll() {
        induccionDAO.deleteAll();
    }
}
