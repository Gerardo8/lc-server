package org.luger.lc.service;

import org.luger.lc.model.Induccion;

import java.util.List;

/**
 * Created by Gerrard on 24/04/16.
 */
public interface InduccionService {

    Induccion findById(Integer id);

    void persist(Induccion induccion,Integer academiaId);

    void update(Induccion induccion);

    void delete(Integer id);

    List<Induccion> findAll();

    List<Induccion> findByAcademiaId(Integer academiaId);

    void deleteAll();
}
