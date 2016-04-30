package org.luger.lc.controller;

import org.luger.lc.model.Academia;
import org.luger.lc.service.AcademiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class AcademiaController {

    @Autowired
    private AcademiaService academiaService;

    @RequestMapping(value = "/academia",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody Academia academia) throws Exception{
        academiaService.persist(academia);
        return ResponseEntity.ok("Academia guardada");
    }

    @RequestMapping(value = "/academia",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody Academia academia) throws Exception{
        academiaService.update(academia);
        return ResponseEntity.ok("Academia actualizada");
    }

    @RequestMapping(value = "/academia/{id}",method = RequestMethod.GET)
    public ResponseEntity<Academia> findById(@PathVariable Integer id) throws Exception{
        return ResponseEntity.ok(academiaService.findById(id));
    }

    @RequestMapping(value = "/academia/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Integer id) throws Exception{
        academiaService.delete(id);
        return ResponseEntity.ok("Academia eliminada");
    }

    @RequestMapping(value = "/academias",method = RequestMethod.GET)
    public ResponseEntity<List<Academia>> findAll() throws Exception{
        return ResponseEntity.ok(academiaService.findAll());
    }

    @RequestMapping(value = "/academias",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        academiaService.deleteAll();
        return ResponseEntity.ok("Academias eliminadas");
    }
}
