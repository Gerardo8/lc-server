package org.luger.lc.service;

import org.luger.lc.model.Academia;

import java.util.List;

public interface AcademiaService {

    Academia findById(Long id);

    void persist(Academia academia);

    void update(Academia academia);

    void delete(Academia academia);

    List<Academia> findAll();

    void deleteAll();
}
