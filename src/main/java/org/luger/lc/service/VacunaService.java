package org.luger.lc.service;

import org.luger.lc.model.Vacuna;

import java.util.List;

public interface VacunaService {

    Vacuna findById(Long id);

    void persist(Vacuna vacuna);

    void update(Vacuna vacuna);

    void delete(Vacuna vacuna);

    List<Vacuna> findAll();

    void deleteAll();
}
