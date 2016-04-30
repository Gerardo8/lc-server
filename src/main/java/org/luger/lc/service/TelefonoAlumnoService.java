package org.luger.lc.service;

import org.luger.lc.model.TelefonoAlumno;

import java.util.List;

public interface TelefonoAlumnoService {

    TelefonoAlumno findById(Integer id);

    void persist(TelefonoAlumno telefonoAlumno);

    void update(TelefonoAlumno telefonoAlumno);

    void delete(Integer id);

    List<TelefonoAlumno> findAll();

    void deleteAll();
}
