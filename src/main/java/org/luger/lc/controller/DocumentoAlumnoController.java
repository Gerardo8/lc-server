package org.luger.lc.controller;

import org.luger.lc.model.DocumentoAlumno;
import org.luger.lc.service.AlumnoService;
import org.luger.lc.service.DocumentoAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class DocumentoAlumnoController {

    @Autowired
    private DocumentoAlumnoService documentoAlumnoService;

    @RequestMapping(value = "/documento-alumno",method = RequestMethod.POST)
    public ResponseEntity<String> persist(@RequestBody DocumentoAlumno documentoAlumno) throws Exception{
        documentoAlumnoService.persist(documentoAlumno);
        return ResponseEntity.ok("Documento guardado");
    }

    @RequestMapping(value = "/documento-alumno",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody DocumentoAlumno documentoAlumno) throws Exception{
        documentoAlumnoService.update(documentoAlumno);
        return ResponseEntity.ok("Documento actualizado");
    }

    @RequestMapping(value = "/documento-alumno/alumno/{id}",method = RequestMethod.GET)
    public ResponseEntity<DocumentoAlumno> findByAlumnoId(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(documentoAlumnoService.findByAlumnoId(id));
    }

    @RequestMapping(value = "/documento-alumno/{id}",method = RequestMethod.GET)
    public ResponseEntity<DocumentoAlumno> findById(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(documentoAlumnoService.findById(id));
    }

    @RequestMapping(value = "/download-documento-alumno/{id}",method = RequestMethod.GET)
    public ResponseEntity<String> downloadDocument(@PathVariable Long id, HttpServletResponse response) throws Exception{

        DocumentoAlumno documentoAlumno = documentoAlumnoService.findById(id);

        response.setContentLength(documentoAlumno.getContenido().length);
        response.setContentType(documentoAlumno.getTipo());
        response.setHeader("Content-Disposition","attachment; filename=\"" + documentoAlumno.getNombre() +"\"");
        FileCopyUtils.copy(documentoAlumno.getContenido(),response.getOutputStream());

        return ResponseEntity.ok("Ok");
    }

    @RequestMapping(value = "/documento-alumno",method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@RequestBody DocumentoAlumno documentoAlumno) throws Exception{
        documentoAlumnoService.delete(documentoAlumno);
        return ResponseEntity.ok("Documento eliminado");
    }

    @RequestMapping(value = "/documento-alumnos",method = RequestMethod.GET)
    public ResponseEntity<List<DocumentoAlumno>> findAll() throws Exception{
        return ResponseEntity.ok(documentoAlumnoService.findAll());
    }

    @RequestMapping(value = "/documento-alumnos",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() throws Exception{
        documentoAlumnoService.deleteAll();
        return ResponseEntity.ok("Documentos eliminados");
    }
}
