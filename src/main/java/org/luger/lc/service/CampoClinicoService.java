package org.luger.lc.service;

import org.luger.lc.model.CampoClinico;
import org.luger.lc.model.DireccionCampoClinico;

import java.util.List;

public interface CampoClinicoService {

    CampoClinico findById(Integer id);

    void persist(CampoClinico campoClinico,DireccionCampoClinico direccionCampoClinico);

    void update(CampoClinico campoClinico);

    void delete(Integer id);

    List<CampoClinico> findAll();

    void deleteAll();
}
