package org.luger.lc.dao;

import org.luger.lc.model.TelefonoAlumno;

import java.util.List;

public interface TelefonoAlumnoDAO {

    TelefonoAlumno findById(Integer id);

    void persist(TelefonoAlumno telefonoAlumno);

    void update(TelefonoAlumno telefonoAlumno);

    void delete(TelefonoAlumno telefonoAlumno);

    List<TelefonoAlumno> findAll();

    void deleteAll();
}
