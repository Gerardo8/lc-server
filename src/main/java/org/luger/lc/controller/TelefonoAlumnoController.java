package org.luger.lc.controller;

import org.luger.lc.model.TelefonoAlumno;
import org.luger.lc.service.TelefonoAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class TelefonoAlumnoController {

    @Autowired
    private TelefonoAlumnoService telefonoAlumnoService;

    @RequestMapping(value = "/telefono",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody TelefonoAlumno telefono) throws Exception{
        telefonoAlumnoService.persist(telefono);
        return ResponseEntity.ok("Telefono guardado");
    }

    @RequestMapping(value = "/telefono",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody TelefonoAlumno telefono) throws Exception{
        telefonoAlumnoService.update(telefono);
        return ResponseEntity.ok("Telefono actualizado");
    }

    @RequestMapping(value = "/telefono/{id}",method = RequestMethod.GET)
    public ResponseEntity<TelefonoAlumno> findById(@PathVariable Integer id) throws Exception{
        return ResponseEntity.ok(telefonoAlumnoService.findById(id));
    }

    @RequestMapping(value = "/telefono/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Integer id) throws Exception{
        telefonoAlumnoService.delete(id);
        return ResponseEntity.ok("Telefono eliminado");
    }

    @RequestMapping(value = "/telefonos",method = RequestMethod.GET)
    public ResponseEntity<List<TelefonoAlumno>> findAll() throws Exception{
        return ResponseEntity.ok(telefonoAlumnoService.findAll());
    }

    @RequestMapping(value = "/telefonos",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        telefonoAlumnoService.deleteAll();
        return ResponseEntity.ok("Telefonos eliminados");
    }
}
