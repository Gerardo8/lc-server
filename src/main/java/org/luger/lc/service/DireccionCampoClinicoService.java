package org.luger.lc.service;

import org.luger.lc.model.DireccionCampoClinico;

import java.util.List;

public interface DireccionCampoClinicoService {

    DireccionCampoClinico findById(Integer id);

    void persist(DireccionCampoClinico direccionCampoClinico);

    void update(DireccionCampoClinico direccionCampoClinico);

    void delete(Integer id);

    List<DireccionCampoClinico> findAll();

    void deleteAll();
}
