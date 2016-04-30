package org.luger.lc.service;

import org.luger.lc.model.Alumno;
import org.luger.lc.model.DocumentoAlumno;

import java.util.List;

public interface DocumentoAlumnoService {

    DocumentoAlumno findById(Integer id);

    DocumentoAlumno findByAlumnoId(Integer id);

    void persist(Alumno alumno);

    void update(Alumno alumno);

    void delete(Integer id);

    List<DocumentoAlumno> findAll();

    void deleteAll();
}
