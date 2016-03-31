package org.luger.lc.controller;

import org.luger.lc.model.Alumno;
import org.luger.lc.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @RequestMapping(value = "/alumno",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody Alumno alumno) throws Exception{
        alumnoService.persist(alumno);
        return ResponseEntity.ok("Alumno guardado");
    }

    @RequestMapping(value = "/alumno",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody Alumno alumno) throws Exception{
        alumnoService.update(alumno);
        return ResponseEntity.ok("Alumno actualizado");
    }

    @RequestMapping(value = "/alumno/{id}",method = RequestMethod.GET)
    public Alumno findById(@PathVariable Long id) throws Exception{
        return alumnoService.findById(id);
    }

    @RequestMapping(value = "/alumno-{numeroCuenta}",method = RequestMethod.GET)
    public ResponseEntity<Alumno> findByNumeroCuenta(@PathVariable String numeroCuenta) throws Exception{
        return ResponseEntity.ok(alumnoService.findByNumeroCuenta(numeroCuenta));
    }

    @RequestMapping(value = "/alumno",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestBody Alumno alumno) throws Exception{
        alumnoService.delete(alumno);
        return ResponseEntity.ok("Alumno eliminado");
    }

    @RequestMapping(value = "/alumnos",method = RequestMethod.GET)
    public ResponseEntity<List<Alumno>> findAll() throws Exception{
        return ResponseEntity.ok(alumnoService.findAll());
    }

    @RequestMapping(value = "/alumnos",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        alumnoService.deleteAll();
        return ResponseEntity.ok("Alumnos eliminados");
    }

    @RequestMapping(value = "/alumnos",method = RequestMethod.POST)
    public ResponseEntity<String> persistAlumnosFromExcel(@RequestParam("file") MultipartFile file) throws Exception{
        alumnoService.persistAlumnosFromExcel(file);
        return ResponseEntity.ok("Alumnos guardados");
    }
}
