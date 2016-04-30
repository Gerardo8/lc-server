package org.luger.lc.service;

import org.luger.lc.model.GrupoPractica;

import java.util.List;

public interface GrupoPracticaService {

    GrupoPractica findById(Integer id);

    List<GrupoPractica> findByAcademiaCampoId(Integer academiaId,Integer campoClinicoId);

    void persist(GrupoPractica grupoPractica);

    void update(GrupoPractica grupoPractica);

    void delete(Integer id);

    List<GrupoPractica> findAll();

    void deleteAll();
}
