package org.luger.lc.dao;

import org.luger.lc.model.DireccionCampoClinico;

import java.util.List;

public interface DireccionCampoClinicoDAO {

    DireccionCampoClinico findById(Integer id);

    void persist(DireccionCampoClinico direccionCampoClinico);

    void update(DireccionCampoClinico direccionCampoClinico);

    void delete(DireccionCampoClinico direccionCampoClinico);

    List<DireccionCampoClinico> findAll();

    void deleteAll();
}
