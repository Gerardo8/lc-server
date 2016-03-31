package org.luger.lc.dao;

import org.luger.lc.model.Vacuna;

import java.util.List;

public interface VacunaDAO {

    Vacuna findById(Long id);

    void persist(Vacuna vacuna);

    void update(Vacuna vacuna);

    void delete(Vacuna vacuna);

    List<Vacuna> findAll();

    void deleteAll();
}
