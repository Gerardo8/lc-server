package org.luger.lc.dao;

import org.luger.lc.model.DocumentoAlumno;

import java.util.List;

public interface DocumentoAlumnoDAO {

    DocumentoAlumno findById(Long id);

    DocumentoAlumno findByAlumnoId(Long id);

    void persist(DocumentoAlumno documentoAlumno);

    void update(DocumentoAlumno documentoAlumno);

    void delete(DocumentoAlumno documentoAlumno);

    List<DocumentoAlumno> findAll();

    void deleteAll();
}
