package org.luger.lc.service;

import org.luger.lc.dao.AlumnoDAO;
import org.luger.lc.dao.DocumentoAlumnoDAO;
import org.luger.lc.model.Alumno;
import org.luger.lc.model.DocumentoAlumno;
import org.luger.lc.poi.Excel;
import org.luger.lc.poi.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service("alumnoService")
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoDAO alumnoDAO;
    @Autowired
    private Excel excel;

    @Override
    public Alumno findById(Integer id) {
        return alumnoDAO.findById(id);
    }

    @Override
    public Alumno findByNumeroCuenta(String numeroCuenta) {
        return alumnoDAO.findByNumeroCuenta(numeroCuenta);
    }

    @Override
    public void persist(Alumno alumno) {
        alumnoDAO.persist(alumno);
    }

    @Override
    public void update(Alumno alumno) {
        alumnoDAO.update(alumno);
    }

    @Override
    public void delete(Integer id) {
        Alumno alumno = alumnoDAO.findById(id);
        alumnoDAO.delete(alumno);
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoDAO.findAll();
    }

    @Override
    public void deleteAll() {
        alumnoDAO.deleteAll();
    }

    @Override
    public void persistAlumnosFromExcel(MultipartFile file) {
        try {
            excel.getAlumnosFromExcel(file).forEach(this::persist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
