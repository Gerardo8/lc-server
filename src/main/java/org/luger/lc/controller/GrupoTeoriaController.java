package org.luger.lc.controller;

import org.luger.lc.model.GrupoTeoria;
import org.luger.lc.model.HorarioGrupoTeoria;
import org.luger.lc.service.GrupoTeoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class GrupoTeoriaController {

    @Autowired
    private GrupoTeoriaService grupoTeoriaService;

    @RequestMapping(value = "/grupo-teoria",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody HorarioGrupoTeoria horarioGrupoTeoria) throws Exception{
        grupoTeoriaService.persist(horarioGrupoTeoria.getGrupoTeoria(),horarioGrupoTeoria);
        return ResponseEntity.ok("Grupo guardado");
    }

    @RequestMapping(value = "/grupo-teoria",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody GrupoTeoria grupoTeoria) throws Exception{
        grupoTeoriaService.update(grupoTeoria);
        return ResponseEntity.ok("Grupo actualizado");
    }

    @RequestMapping(value = "/grupo-teoria/{id}",method = RequestMethod.GET)
    public ResponseEntity<GrupoTeoria> findById(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(grupoTeoriaService.findById(id));
    }


    @RequestMapping(value = "/grupos-teoria/academia/{academiaId}",method = RequestMethod.GET)
    public ResponseEntity<List<GrupoTeoria>> findByAcademiaCampoId(@PathVariable Long academiaId) throws Exception{
        return ResponseEntity.ok(grupoTeoriaService.findByAcademiaId(academiaId));
    }

    @RequestMapping(value = "/grupo-teoria",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestBody GrupoTeoria grupoTeoria) throws Exception{
        grupoTeoriaService.delete(grupoTeoria);
        return ResponseEntity.ok("Grupo eliminado");
    }

    @RequestMapping(value = "/grupos-teoria",method = RequestMethod.GET)
    public ResponseEntity<List<GrupoTeoria>> findAll() throws Exception{
        return ResponseEntity.ok(grupoTeoriaService.findAll());
    }

    @RequestMapping(value = "/grupos-teoria",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        grupoTeoriaService.deleteAll();
        return ResponseEntity.ok("Grupos eliminados");
    }
}
