package org.luger.lc.service;

import org.luger.lc.model.GrupoTeoria;
import org.luger.lc.model.HorarioGrupoTeoria;

import java.util.List;

public interface GrupoTeoriaService {

    GrupoTeoria findById(Long id);

    List<GrupoTeoria> findByAcademiaId(Long academiaId);

    void persist(GrupoTeoria grupoTeoria,HorarioGrupoTeoria horarioGrupoTeoria);

    void update(GrupoTeoria grupoTeoria);

    void delete(GrupoTeoria grupoTeoria);

    List<GrupoTeoria> findAll();

    void deleteAll();
}
