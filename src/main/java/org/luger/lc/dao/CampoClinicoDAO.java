package org.luger.lc.dao;

import org.luger.lc.model.CampoClinico;

import java.util.List;

public interface CampoClinicoDAO {

    CampoClinico findById(Long id);

    void persist(CampoClinico campoClinico);

    void update(CampoClinico campoClinico);

    void delete(CampoClinico campoClinico);

    List<CampoClinico> findAll();

    void deleteAll();
}
