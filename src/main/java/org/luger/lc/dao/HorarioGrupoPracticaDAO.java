package org.luger.lc.dao;

import org.luger.lc.model.HorarioGrupoPractica;

import java.util.List;

public interface HorarioGrupoPracticaDAO {

    HorarioGrupoPractica findById(Long id);

    void persist(HorarioGrupoPractica horarioGrupoPractica);

    void update(HorarioGrupoPractica horarioGrupoPractica);

    void delete(HorarioGrupoPractica horarioGrupoPractica);

    List<HorarioGrupoPractica> findAll();

    void deleteAll();
}
