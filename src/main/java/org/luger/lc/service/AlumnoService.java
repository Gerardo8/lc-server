package org.luger.lc.service;

import org.luger.lc.model.Alumno;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AlumnoService {

    Alumno findById(Integer id);

    Alumno findByNumeroCuenta(String numeroCuenta);

    void persist(Alumno alumno);

    void update(Alumno alumno);

    void delete(Integer id);

    List<Alumno> findAll();

    void deleteAll();

    void persistAlumnosFromExcel(MultipartFile file);
}
