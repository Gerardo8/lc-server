package org.luger.lc.service;

import org.luger.lc.dao.AcademiaDAO;
import org.luger.lc.model.Academia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("academiaService")
@Transactional
public class AcademiaServiceImpl implements AcademiaService {

    @Autowired
    private AcademiaDAO academiaDAO;

    @Override
    public Academia findById(Long id) {
        return academiaDAO.findById(id);
    }

    @Override
    public void persist(Academia academia) {
        academiaDAO.persist(academia);
    }

    @Override
    public void update(Academia academia) {
        academiaDAO.update(academia);
    }

    @Override
    public void delete(Academia academia) {
        academiaDAO.delete(academia);
    }

    @Override
    public List<Academia> findAll() {
        return academiaDAO.findAll();
    }

    @Override
    public void deleteAll() {
        academiaDAO.deleteAll();
    }
}
