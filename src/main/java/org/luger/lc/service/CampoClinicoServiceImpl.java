package org.luger.lc.service;

import org.luger.lc.dao.CampoClinicoDAO;
import org.luger.lc.dao.DireccionCampoClinicoDAO;
import org.luger.lc.model.CampoClinico;
import org.luger.lc.model.DireccionCampoClinico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("campoClinicoService")
@Transactional
public class CampoClinicoServiceImpl implements CampoClinicoService {

    @Autowired
    private CampoClinicoDAO campoClinicoDAO;
    @Autowired
    private DireccionCampoClinicoDAO direccionCampoClinicoDAO;

    @Override
    public CampoClinico findById(Long id) {
        return campoClinicoDAO.findById(id);
    }

    @Override
    public void persist(CampoClinico campoClinico,DireccionCampoClinico direccionCampoClinico) {
        campoClinicoDAO.persist(campoClinico);
        direccionCampoClinicoDAO.persist(direccionCampoClinico);
    }

    @Override
    public void update(CampoClinico campoClinico) {
        campoClinicoDAO.update(campoClinico);
    }

    @Override
    public void delete(CampoClinico campoClinico) {
        campoClinicoDAO.delete(campoClinico);
    }

    @Override
    public List<CampoClinico> findAll() {
        return campoClinicoDAO.findAll();
    }

    @Override
    public void deleteAll() {
        campoClinicoDAO.deleteAll();
    }
}
