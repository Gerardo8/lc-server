package org.luger.lc.service;

import org.luger.lc.dao.DireccionCampoClinicoDAO;
import org.luger.lc.model.DireccionCampoClinico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("direccionCampoClinicoService")
@Transactional
public class DireccionCampoClinicoServiceImpl implements DireccionCampoClinicoService {

    @Autowired
    private DireccionCampoClinicoDAO direccionCampoClinicoDAO;

    @Override
    public DireccionCampoClinico findById(Integer id) {
        return direccionCampoClinicoDAO.findById(id);
    }

    @Override
    public void persist(DireccionCampoClinico direccionCampoClinico) {
        direccionCampoClinicoDAO.persist(direccionCampoClinico);
    }

    @Override
    public void update(DireccionCampoClinico direccionCampoClinico) {
        direccionCampoClinicoDAO.update(direccionCampoClinico);
    }

    @Override
    public void delete(Integer id) {
        DireccionCampoClinico direccionCampoClinico = direccionCampoClinicoDAO.findById(id);
        direccionCampoClinicoDAO.delete(direccionCampoClinico);
    }

    @Override
    public List<DireccionCampoClinico> findAll() {
        return direccionCampoClinicoDAO.findAll();
    }

    @Override
    public void deleteAll() {
        direccionCampoClinicoDAO.deleteAll();
    }
}
