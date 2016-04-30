package org.luger.lc.controller;

import org.luger.lc.model.CampoClinico;
import org.luger.lc.model.DireccionCampoClinico;
import org.luger.lc.service.CampoClinicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class CampoClinicoController {

    @Autowired
    private CampoClinicoService campoClinicoService;

    @RequestMapping(value = "/campo-clinico",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody DireccionCampoClinico direccionCampoClinico) throws Exception{
        campoClinicoService.persist(direccionCampoClinico.getCampoClinico(),direccionCampoClinico);
        return ResponseEntity.ok("Campo clinico guardado");
    }

    @RequestMapping(value = "/campo-clinico",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody CampoClinico campoClinico) throws Exception{
        campoClinicoService.update(campoClinico);
        return ResponseEntity.ok("Campo clinico actualizado");
    }

    @RequestMapping(value = "/campo-clinico/{id}",method = RequestMethod.GET)
    public ResponseEntity<CampoClinico> findById(@PathVariable Integer id) throws Exception{
        return ResponseEntity.ok(campoClinicoService.findById(id));
    }

    @RequestMapping(value = "/campo-clinico/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Integer id) throws Exception{
        campoClinicoService.delete(id);
        return ResponseEntity.ok("Campo clinico eliminado");
    }

    @RequestMapping(value = "/campos-clinicos",method = RequestMethod.GET)
    public ResponseEntity<List<CampoClinico>> findAll() throws Exception{
        return ResponseEntity.ok(campoClinicoService.findAll());
    }

    @RequestMapping(value = "/campos-clinicos",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        campoClinicoService.deleteAll();
        return ResponseEntity.ok("Campos clinicos eliminados");
    }
}
