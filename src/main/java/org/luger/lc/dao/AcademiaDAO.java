package org.luger.lc.dao;

import org.luger.lc.model.Academia;

import java.util.List;

public interface AcademiaDAO {

    Academia findById(Integer id);

    void persist(Academia academia);

    void update(Academia academia);

    void delete(Academia academia);

    List<Academia> findAll();

    void deleteAll();
}
