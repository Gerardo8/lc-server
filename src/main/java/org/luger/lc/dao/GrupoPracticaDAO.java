package org.luger.lc.dao;

import org.luger.lc.model.GrupoPractica;

import java.util.List;

public interface GrupoPracticaDAO {

    GrupoPractica findById(Integer id);

    List<GrupoPractica> findByAcademiaCampoId(Integer academiaId,Integer campoClinicoId);

    void persist(GrupoPractica grupoPractica);

    void update(GrupoPractica grupoPractica);

    void delete(GrupoPractica grupoPractica);

    List<GrupoPractica> findAll();

    void deleteAll();
}
