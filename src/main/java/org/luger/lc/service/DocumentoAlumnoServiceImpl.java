package org.luger.lc.service;

import org.luger.lc.dao.DocumentoAlumnoDAO;
import org.luger.lc.model.DocumentoAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("documentoAlumnoService")
@Transactional
public class DocumentoAlumnoServiceImpl implements DocumentoAlumnoService {

    @Autowired
    private DocumentoAlumnoDAO documentoAlumnoDAO;

    @Override
    public DocumentoAlumno findById(Long id) {
        return documentoAlumnoDAO.findById(id);
    }

    @Override
    public DocumentoAlumno findByAlumnoId(Long id) {
        return documentoAlumnoDAO.findByAlumnoId(id);
    }

    @Override
    public void persist(DocumentoAlumno documentoAlumno) {
        documentoAlumnoDAO.persist(documentoAlumno);
    }

    @Override
    public void update(DocumentoAlumno documentoAlumno) {
        documentoAlumnoDAO.update(documentoAlumno);
    }

    @Override
    public void delete(DocumentoAlumno documentoAlumno) {
        documentoAlumnoDAO.delete(documentoAlumno);
    }

    @Override
    public List<DocumentoAlumno> findAll() {
        return documentoAlumnoDAO.findAll();
    }

    @Override
    public void deleteAll() {
        documentoAlumnoDAO.deleteAll();
    }
}
