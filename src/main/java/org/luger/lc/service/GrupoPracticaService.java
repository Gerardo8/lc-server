package org.luger.lc.service;

import org.luger.lc.model.GrupoPractica;
import org.luger.lc.model.HorarioGrupoPractica;

import java.util.List;

public interface GrupoPracticaService {

    GrupoPractica findById(Long id);

    List<GrupoPractica> findByAcademiaCampoId(Long academiaId,Long campoClinicoId);

    void persist(GrupoPractica grupoPractica,HorarioGrupoPractica horarioGrupoPractica);

    void update(GrupoPractica grupoPractica);

    void delete(GrupoPractica grupoPractica);

    List<GrupoPractica> findAll();

    void deleteAll();
}
