package org.luger.lc.service;

import org.luger.lc.dao.DocumentoAlumnoDAO;
import org.luger.lc.model.Alumno;
import org.luger.lc.model.DocumentoAlumno;
import org.luger.lc.poi.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("documentoAlumnoService")
@Transactional
public class DocumentoAlumnoServiceImpl implements DocumentoAlumnoService {

    @Autowired
    private DocumentoAlumnoDAO documentoAlumnoDAO;
    @Autowired
    private Word word;

    @Override
    public DocumentoAlumno findById(Integer id) {
        return documentoAlumnoDAO.findById(id);
    }

    @Override
    public DocumentoAlumno findByAlumnoId(Integer id) {
        return documentoAlumnoDAO.findByAlumnoId(id);
    }

    @Override
    public void persist(Alumno alumno) {
        DocumentoAlumno documentoAlumno = new DocumentoAlumno();
        documentoAlumno.setContenido(word.createWordDocument(alumno));
        documentoAlumno.setAlumno(alumno);
        documentoAlumno.setNombre(alumno.getNombre() + "_" + alumno.getNumeroCuenta() + ".docx");
        documentoAlumno.setTipo("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        documentoAlumnoDAO.persist(documentoAlumno);
    }

    @Override
    public void update(Alumno alumno) {
        DocumentoAlumno documentoAlumno = documentoAlumnoDAO.findByAlumnoId(alumno.getId());
        documentoAlumno.setContenido(word.createWordDocument(alumno));
        documentoAlumnoDAO.update(documentoAlumno);
    }

    @Override
    public void delete(Integer id) {
        DocumentoAlumno documentoAlumno = documentoAlumnoDAO.findById(id);
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
