package org.luger.lc.dao;

import org.luger.lc.model.Induccion;

import java.util.List;

/**
 * Created by Gerrard on 24/04/16.
 */
public interface InduccionDAO {

    Induccion findById(Integer id);

    void persist(Induccion induccion);

    void update(Induccion induccion);

    void delete(Induccion induccion);

    List<Induccion> findAll();

    List<Induccion> findByAcademiaId(Integer academiaId);

    void deleteAll();
}
