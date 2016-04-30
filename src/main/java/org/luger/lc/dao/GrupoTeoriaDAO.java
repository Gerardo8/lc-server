package org.luger.lc.dao;

import org.luger.lc.model.GrupoTeoria;

import java.util.List;

public interface GrupoTeoriaDAO {

    GrupoTeoria findById(Integer id);

    List<GrupoTeoria> findByAcademiaId(Integer academiaId);

    void persist(GrupoTeoria grupoTeoria);

    void update(GrupoTeoria grupoTeoria);

    void delete(GrupoTeoria grupoTeoria);

    List<GrupoTeoria> findAll();

    void deleteAll();
}
