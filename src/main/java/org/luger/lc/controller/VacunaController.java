package org.luger.lc.controller;

import org.luger.lc.model.Vacuna;
import org.luger.lc.service.VacunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class VacunaController {

    @Autowired
    private VacunaService vacunaService;

    @RequestMapping(value = "/vacuna",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody Vacuna vacuna) throws Exception{
        vacunaService.persist(vacuna);
        return ResponseEntity.ok("Vacuna guardada");
    }

    @RequestMapping(value = "/vacuna",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody Vacuna vacuna) throws Exception{
        vacunaService.update(vacuna);
        return ResponseEntity.ok("Vacuna actualizada");
    }

    @RequestMapping(value = "/vacuna/{id}",method = RequestMethod.GET)
    public ResponseEntity<Vacuna> findById(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(vacunaService.findById(id));
    }

    @RequestMapping(value = "/vacuna",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestBody Vacuna vacuna) throws Exception{
        vacunaService.delete(vacuna);
        return ResponseEntity.ok("Vacuna eliminada");
    }

    @RequestMapping(value = "/vacunas",method = RequestMethod.GET)
    public ResponseEntity<List<Vacuna>> findAll() throws Exception{
        return ResponseEntity.ok(vacunaService.findAll());
    }

    @RequestMapping(value = "/vacunas",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        vacunaService.deleteAll();
        return ResponseEntity.ok("Vacunas eliminadas");
    }
}
