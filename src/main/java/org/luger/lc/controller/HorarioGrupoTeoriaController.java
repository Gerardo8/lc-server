package org.luger.lc.controller;

import org.luger.lc.model.HorarioGrupoTeoria;
import org.luger.lc.service.HorarioGrupoTeoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class HorarioGrupoTeoriaController {

    @Autowired
    private HorarioGrupoTeoriaService horarioGrupoTeoriaService;

    @RequestMapping(value = "/horario-grupo-teoria",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody HorarioGrupoTeoria horarioGrupoTeoria) throws Exception{
        horarioGrupoTeoriaService.persist(horarioGrupoTeoria);
        return ResponseEntity.ok("Horario guardado");
    }

    @RequestMapping(value = "/horario-grupo-teoria",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody HorarioGrupoTeoria horarioGrupoTeoria) throws Exception{
        horarioGrupoTeoriaService.update(horarioGrupoTeoria);
        return ResponseEntity.ok("Horario actualizado");
    }

    @RequestMapping(value = "/horario-grupo-teoria/{id}",method = RequestMethod.GET)
    public ResponseEntity<HorarioGrupoTeoria> findById(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(horarioGrupoTeoriaService.findById(id));
    }

    @RequestMapping(value = "/horario-grupo-teoria",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestBody HorarioGrupoTeoria horarioGrupoTeoria) throws Exception{
        horarioGrupoTeoriaService.delete(horarioGrupoTeoria);
        return ResponseEntity.ok("Horario eliminado");
    }

    @RequestMapping(value = "/horarios-grupos-teoria",method = RequestMethod.GET)
    public ResponseEntity<List<HorarioGrupoTeoria>> findAll() throws Exception{
        return ResponseEntity.ok(horarioGrupoTeoriaService.findAll());
    }

    @RequestMapping(value = "/horarios-grupos-teoria",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        horarioGrupoTeoriaService.deleteAll();
        return ResponseEntity.ok("Horarios eliminados");
    }
}
