package org.luger.lc.poi;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.luger.lc.model.Alumno;
import org.luger.lc.model.DocumentoAlumno;
import org.luger.lc.model.GrupoPractica;
import org.luger.lc.model.GrupoTeoria;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Component
public class Word {
    public DocumentoAlumno createWordDocument(Alumno alumno) {

        GrupoPractica grupoPractica = alumno.getGrupoPractica();
        GrupoTeoria grupoTeoria = alumno.getGrupoTeoria();
        DocumentoAlumno documentoAlumno = new DocumentoAlumno();
        String imgFile = "/assets/image1.jpeg";
        InputStream inputStream = this.getClass().getResourceAsStream(imgFile);
        XWPFDocument wordDocument = new XWPFDocument();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Locale locale = new Locale("es");

        try {
            XWPFParagraph p1 = wordDocument.createParagraph();

            p1.setAlignment(ParagraphAlignment.LEFT);
            p1.setVerticalAlignment(TextAlignment.TOP);

            XWPFRun run1P1 = p1.createRun();

            run1P1.addPicture(
                    inputStream,
                    XWPFDocument.PICTURE_TYPE_JPEG,
                    imgFile, Units.toEMU(150),
                    Units.toEMU(150)
            );

            run1P1.addBreak();
            run1P1.setText("NOMBRE: "+alumno.getNombre()+" "+alumno.getApellidos());
            run1P1.addBreak();
            run1P1.setText("PROMEDIO: "+alumno.getPromedio()+"                      NUMERO DE CUENTA: "+alumno.getNumeroCuenta());
            run1P1.addBreak();
            run1P1.setText("UNIDAD ASIGNADA: "+grupoPractica.getCampoClinico().getNombre());
            run1P1.addBreak();
            run1P1.setText("FECHA DE INICIO PRACTICA: "+alumno.getGrupoPractica().getFechaInicio()
                    .getDayOfWeek().getDisplayName(TextStyle.FULL,locale)+", "+alumno.getGrupoPractica()
                    .getFechaInicio().getDayOfMonth()+" de "+alumno.getGrupoPractica().getFechaInicio()
                    .getMonth().getDisplayName(TextStyle.FULL,locale)+" de "+alumno.getGrupoPractica()
                    .getFechaInicio().getYear());


            wordDocument.write(baos);

        } catch (Exception e) {
            e.printStackTrace();
        }

        documentoAlumno.setAlumno(alumno);
        documentoAlumno.setNombre(alumno.getNumeroCuenta()+"_"+alumno.getNombre()+".docx");
        documentoAlumno.setContenido(baos.toByteArray());
        documentoAlumno.setTipo("application/vnd.openxmlformats-officedocument.wordprocessingml.document");

        return documentoAlumno;
    }
}
