package org.luger.lc.controller;

import org.luger.lc.model.GrupoPractica;
import org.luger.lc.service.GrupoPracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class GrupoPracticaController {

    @Autowired
    private GrupoPracticaService grupoPracticaService;

    @RequestMapping(value = "/grupo-practica",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody GrupoPractica grupoPractica) throws Exception{
        grupoPracticaService.persist(grupoPractica);
        return ResponseEntity.ok("Grupo guardado");
    }

    @RequestMapping(value = "/grupo-practica",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody GrupoPractica grupoPractica) throws Exception{
        grupoPracticaService.update(grupoPractica);
        return ResponseEntity.ok("Grupo actualizado");
    }

    @RequestMapping(value = "/grupo-practica/{id}",method = RequestMethod.GET)
    public ResponseEntity<GrupoPractica> findById(@PathVariable Integer id) throws Exception{
        return ResponseEntity.ok(grupoPracticaService.findById(id));
    }

    @RequestMapping(value = "/grupos-practica/academia/{academiaId}/campo/{campoClinicoId}",method = RequestMethod.GET)
    public ResponseEntity<List<GrupoPractica>> findByAcademiaCampoId(@PathVariable Integer academiaId,@PathVariable Integer campoClinicoId) throws Exception{
        return ResponseEntity.ok(grupoPracticaService.findByAcademiaCampoId(academiaId,campoClinicoId));
    }

    @RequestMapping(value = "/grupo-practica/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Integer id) throws Exception{
        grupoPracticaService.delete(id);
        return ResponseEntity.ok("Grupo eliminado");
    }

    @RequestMapping(value = "/grupos-practica",method = RequestMethod.GET)
    public ResponseEntity<List<GrupoPractica>> findAll() throws Exception{
        return ResponseEntity.ok(grupoPracticaService.findAll());
    }

    @RequestMapping(value = "/grupos-practica",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        grupoPracticaService.deleteAll();
        return ResponseEntity.ok("Grupos eliminados");
    }
}
