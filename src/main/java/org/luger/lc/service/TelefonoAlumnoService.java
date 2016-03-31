package org.luger.lc.service;

import org.luger.lc.model.TelefonoAlumno;

import java.util.List;

public interface TelefonoAlumnoService {

    TelefonoAlumno findById(Long id);

    void persist(TelefonoAlumno telefonoAlumno);

    void update(TelefonoAlumno telefonoAlumno);

    void delete(TelefonoAlumno telefonoAlumno);

    List<TelefonoAlumno> findAll();

    void deleteAll();
}
