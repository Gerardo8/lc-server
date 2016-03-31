package org.luger.lc.controller;

import org.luger.lc.model.HorarioGrupoPractica;
import org.luger.lc.service.HorarioGrupoPracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class HorarioGrupoPracticaController {

    @Autowired
    private HorarioGrupoPracticaService horarioGrupoPracticaService;

    @RequestMapping(value = "/horario-grupo-practica",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody HorarioGrupoPractica horarioGrupoPractica) throws Exception{
        horarioGrupoPracticaService.persist(horarioGrupoPractica);
        return ResponseEntity.ok("Horario guardado");
    }

    @RequestMapping(value = "/horario-grupo-practica",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody HorarioGrupoPractica horarioGrupoPractica) throws Exception{
        horarioGrupoPracticaService.update(horarioGrupoPractica);
        return ResponseEntity.ok("Horario actualizado");
    }

    @RequestMapping(value = "/horario-grupo-practica/{id}",method = RequestMethod.GET)
    public ResponseEntity<HorarioGrupoPractica> findById(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(horarioGrupoPracticaService.findById(id));
    }

    @RequestMapping(value = "/horario-grupo-practica",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestBody HorarioGrupoPractica horarioGrupoPractica) throws Exception{
        horarioGrupoPracticaService.delete(horarioGrupoPractica);
        return ResponseEntity.ok("Horario eliminado");
    }

    @RequestMapping(value = "/horarios-grupos-practica",method = RequestMethod.GET)
    public ResponseEntity<List<HorarioGrupoPractica>> findAll() throws Exception{
        return ResponseEntity.ok(horarioGrupoPracticaService.findAll());
    }

    @RequestMapping(value = "/horarios-grupos-practica",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        horarioGrupoPracticaService.deleteAll();
        return ResponseEntity.ok("Horarios eliminados");
    }
}
