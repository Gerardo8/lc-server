package org.luger.lc.service;

import org.luger.lc.model.GrupoTeoria;

import java.util.List;

public interface GrupoTeoriaService {

    GrupoTeoria findById(Integer id);

    List<GrupoTeoria> findByAcademiaId(Integer academiaId);

    void persist(GrupoTeoria grupoTeoria);

    void update(GrupoTeoria grupoTeoria);

    void delete(Integer id);

    List<GrupoTeoria> findAll();

    void deleteAll();
}
