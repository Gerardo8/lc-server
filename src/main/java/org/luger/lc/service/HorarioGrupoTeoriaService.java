package org.luger.lc.service;

import org.luger.lc.model.HorarioGrupoTeoria;

import java.util.List;

public interface HorarioGrupoTeoriaService {

    HorarioGrupoTeoria findById(Long id);

    void persist(HorarioGrupoTeoria horarioGrupoTeoria);

    void update(HorarioGrupoTeoria horarioGrupoTeoria);

    void delete(HorarioGrupoTeoria horarioGrupoTeoria);

    List<HorarioGrupoTeoria> findAll();

    void deleteAll();
}
