package org.luger.lc.service;

import org.luger.lc.model.HorarioGrupoPractica;

import java.util.List;

public interface HorarioGrupoPracticaService {

    HorarioGrupoPractica findById(Long id);

    void persist(HorarioGrupoPractica horarioGrupoPractica);

    void update(HorarioGrupoPractica horarioGrupoPractica);

    void delete(HorarioGrupoPractica horarioGrupoPractica);

    List<HorarioGrupoPractica> findAll();

    void deleteAll();
}
