package org.luger.lc.dao;

import org.luger.lc.model.GrupoPractica;

import java.util.List;

public interface GrupoPracticaDAO {

    GrupoPractica findById(Long id);

    List<GrupoPractica> findByAcademiaCampoId(Long academiaId,Long campoClinicoId);

    void persist(GrupoPractica grupoPractica);

    void update(GrupoPractica grupoPractica);

    void delete(GrupoPractica grupoPractica);

    List<GrupoPractica> findAll();

    void deleteAll();
}
