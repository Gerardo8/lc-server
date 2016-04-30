package org.luger.lc.service;

import org.luger.lc.model.Academia;

import java.util.List;

public interface AcademiaService {

    Academia findById(Integer id);

    void persist(Academia academia);

    void update(Academia academia);

    void delete(Integer id);

    List<Academia> findAll();

    void deleteAll();
}
