package org.luger.lc.service;

import org.luger.lc.model.DocumentoAlumno;

import java.util.List;

public interface DocumentoAlumnoService {

    DocumentoAlumno findById(Long id);

    DocumentoAlumno findByAlumnoId(Long id);

    void persist(DocumentoAlumno documentoAlumno);

    void update(DocumentoAlumno documentoAlumno);

    void delete(DocumentoAlumno documentoAlumno);

    List<DocumentoAlumno> findAll();

    void deleteAll();
}
