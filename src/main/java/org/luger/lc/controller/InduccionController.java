package org.luger.lc.controller;

import org.luger.lc.model.Induccion;
import org.luger.lc.service.InduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gerrard on 24/04/16.
 */

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class InduccionController {

    @Autowired
    private InduccionService induccionService;

    @RequestMapping(value = "/induccion/academia/{academiaId}",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody Induccion induccion,@PathVariable Integer academiaId) throws Exception{
        induccionService.persist(induccion,academiaId);
        return ResponseEntity.ok("Induccion guardada");
    }

    @RequestMapping(value = "/induccion",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody Induccion induccion) throws Exception{
        induccionService.update(induccion);
        return ResponseEntity.ok("Induccion actualizada");
    }

    @RequestMapping(value = "/induccion/{id}",method = RequestMethod.GET)
    public ResponseEntity<Induccion> findById(@PathVariable Integer id) throws Exception{
        return ResponseEntity.ok(induccionService.findById(id));
    }

    @RequestMapping(value = "/inducciones/academia/{academiaId}",method = RequestMethod.GET)
    public ResponseEntity<List<Induccion>> findByAcademiaId(@PathVariable Integer academiaId) throws Exception{
        return ResponseEntity.ok(induccionService.findByAcademiaId(academiaId));
    }

    @RequestMapping(value = "/induccion/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Integer id) throws Exception{
        induccionService.delete(id);
        return ResponseEntity.ok("Induccion eliminada");
    }

    @RequestMapping(value = "/inducciones",method = RequestMethod.GET)
    public ResponseEntity<List<Induccion>> findAll() throws Exception{
        return ResponseEntity.ok(induccionService.findAll());
    }

    @RequestMapping(value = "/inducciones",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        induccionService.deleteAll();
        return ResponseEntity.ok("Inducciones eliminadas");
    }
}
