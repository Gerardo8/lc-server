package org.luger.lc.dao;

import org.luger.lc.model.Alumno;

import java.util.List;

public interface AlumnoDAO {

    Alumno findById(Long id);

    Alumno findByNumeroCuenta(String numeroCuenta);

    void persist(Alumno alumno);

    void update(Alumno alumno);

    void delete(Alumno alumno);

    List<Alumno> findAll();

    void deleteAll();
}
