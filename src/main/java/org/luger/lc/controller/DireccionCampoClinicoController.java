package org.luger.lc.controller;

import org.luger.lc.model.DireccionCampoClinico;
import org.luger.lc.service.DireccionCampoClinicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class DireccionCampoClinicoController {

    @Autowired
    private DireccionCampoClinicoService direccionCampoClinicoService;

    @RequestMapping(value = "/direccion-campo-clinico",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody DireccionCampoClinico direccionCampoClinico) throws Exception{
        direccionCampoClinicoService.persist(direccionCampoClinico);
        return ResponseEntity.ok("Direccion guardada");
    }

    @RequestMapping(value = "/direccion-campo-clinico",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody DireccionCampoClinico direccionCampoClinico) throws Exception{
        direccionCampoClinicoService.update(direccionCampoClinico);
        return ResponseEntity.ok("Direccion actualizada");
    }

    @RequestMapping(value = "/direccion-campo-clinico/{id}",method = RequestMethod.GET)
    public ResponseEntity<DireccionCampoClinico> findById(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(direccionCampoClinicoService.findById(id));
    }

    @RequestMapping(value = "/direccion-campo-clinico",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestBody DireccionCampoClinico direccionCampoClinico) throws Exception{
        direccionCampoClinicoService.delete(direccionCampoClinico);
        return ResponseEntity.ok("Direccion eliminada");
    }

    @RequestMapping(value = "/direcciones-campos-clinicos",method = RequestMethod.GET)
    public ResponseEntity<List<DireccionCampoClinico>> findAll() throws Exception{
        return ResponseEntity.ok(direccionCampoClinicoService.findAll());
    }

    @RequestMapping(value = "/direcciones-campos-clinicos",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        direccionCampoClinicoService.deleteAll();
        return ResponseEntity.ok("Direcciones eliminadas");
    }
}
