package org.luger.lc.poi;

import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xwpf.usermodel.*;
import org.luger.lc.model.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTFontImpl;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@Component
public class Word {
    public byte[] createWordDocument(Alumno alumno) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        GrupoPractica grupoPractica = alumno.getGrupoPractica();
        GrupoTeoria grupoTeoria = alumno.getGrupoTeoria();
        Academia academia = grupoPractica.getAcademia();
        CampoClinico campoClinico = grupoPractica.getCampoClinico();


        DocumentoAlumno documentoAlumno = new DocumentoAlumno();

        String imgFile = "image1.jpeg";
        InputStream inputStream = this.getClass().getResourceAsStream("/assets/" + imgFile);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Locale locale = new Locale("es");

        XWPFDocument wordDocument = new XWPFDocument();

        try {
            XWPFParagraph p1 = wordDocument.createParagraph();

            p1.setAlignment(ParagraphAlignment.LEFT);
            p1.setVerticalAlignment(TextAlignment.TOP);

            XWPFRun run1P1 = p1.createRun();

            run1P1.addPicture(
                    inputStream,
                    XWPFDocument.PICTURE_TYPE_JPEG,
                    imgFile, Units.toEMU(60),
                    Units.toEMU(60)
            );

//            XWPFParagraph p2 = wordDocument.createParagraph();
//            p2.setAlignment(ParagraphAlignment.CENTER);
//            p2.setVerticalAlignment(TextAlignment.TOP);
//
//            XWPFRun run1P2 = p2.createRun();

            run1P1.setFontFamily("Arial");
            run1P1.setFontSize(8);
            run1P1.setBold(true);

            run1P1.setText("DIRECCIÓN DE CIENCIAS DE LA SALUD");
            run1P1.addBreak();
            run1P1.setText("COORDINACIÓN DE CAMPOS CLÍNICOS Y SERVICIO SOCIAL");
            run1P1.addBreak();
            run1P1.setText("CAMPUS ECATEPEC");
            run1P1.addBreak();
            run1P1.setText("LICENCIATURA EN ENFERMERÍA");
            run1P1.addBreak();
            run1P1.setText("CICLO " + academia.getCiclo());
            run1P1.addBreak();

            XWPFParagraph p2 = wordDocument.createParagraph();
            p2.setAlignment(ParagraphAlignment.LEFT);

            XWPFRun run1P2 = p2.createRun();

            run1P2.setFontFamily("Arial");
            run1P2.setFontSize(10);
            run1P2.setBold(true);

            run1P2.setText("NOMBRE: "+alumno.getNombre()+" "+alumno.getApellidos());
            run1P2.addBreak();
            run1P2.setText("PROMEDIO GRAL: "+alumno.getPromedio()+"                      NUMERO DE CUENTA: "+alumno.getNumeroCuenta());
            run1P2.addBreak();
            run1P2.setText("UNIDAD ASIGNADA: "+grupoPractica.getCampoClinico().getNombre());
            run1P2.addBreak();
            run1P2.addBreak();
            run1P2.setFontSize(8);
            run1P2.setText("ESTOY INFORMADO Y ACEPTO.");
            run1P2.addBreak();
            run1P2.addBreak();
            run1P2.setBold(false);
            run1P2.setText("La duración de la práctica clínica será de forma obligatoria, 3 días de inducción en campus y 6 semanas en campo clínico asignado, presentándose de la siguiente manera:");
            run1P2.addBreak();

            XWPFTable table1 = wordDocument.createTable(3,2);

            XWPFParagraph tableTittle = wordDocument.createParagraph();
            tableTittle.setAlignment(ParagraphAlignment.CENTER);

            XWPFRun r = tableTittle.createRun();

            r.setBold(true);
//            r.setText("");


            table1.getRow(0).getCell(0).setText("INDUCCIÓN EN CAMPUS");
            table1.getRow(1).getCell(0).setText("INICIO DE PRÁCTICA EN LA INSTITUCIÓN DE SALUD");
            table1.getRow(2).getCell(0).setText("INICIO DE PERIÓDO TEÓRICO");
            table1.getRow(0).getCell(1).setText("");
            table1.getRow(1).getCell(1).setText("Del " + grupoPractica.getFechaInicio().format(formatter) + " al " + grupoPractica.getFechaFin().format(formatter));
            table1.getRow(2).getCell(1).setText("Del " + grupoTeoria.getFechaInicio().format(formatter) + " al " + grupoTeoria.getFechaFin().format(formatter));

            XWPFParagraph p3 = wordDocument.createParagraph();
            p3.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run1P3 = p3.createRun();

            run1P3.setFontFamily("Arial");
            run1P3.setFontSize(8);

            run1P3.addBreak();
            run1P3.setText("1.    Es obligación del alumno tener acceso puntual a las unidades de salud, no existe tolerancia de ingreso.");
            run1P3.addBreak();
            run1P3.setText("2.    Es obligación del alumno acudir debidamente uniformado a los campos clínicos de lo contrario no se le");
            run1P3.addBreak();
            run1P3.setText("       permitirá el acceso.");
            run1P3.addBreak();
            run1P3.setText("3.    Durante la estancia en las unidades de salud deberá cumplir con las políticas internas de la institución");
            run1P3.addBreak();
            run1P3.setText("       donde realice la práctica clínica.");
            run1P3.addBreak();
            run1P3.setText("4.    Durante el horario de práctica deberá permanecer en el servicio asignado e integrado en el trabajo");
            run1P3.addBreak();
            run1P3.setText("       colaborativo propio de la institución.");
            run1P3.addBreak();
            run1P3.setText("5.    Está prohibido permanecer fuera del horario estipulado en la unidad de salud de lo contrario");
            run1P3.addBreak();
            run1P3.setText("       será causa de sanción.");
            run1P3.addBreak();
            run1P3.setText("6.    Está prohibido salir del hospital asignado dentro del horario estipulado en la unidad de salud de lo");
            run1P3.addBreak();
            run1P3.setText("       contrario será causa de sanción.");
            run1P3.addBreak();
            run1P3.setText("7.    El estudiante no podrá hacerse acompañar de ningún familiar y/o amigo en el tiempo que realice su práctica.");
            run1P3.addBreak();
            run1P3.setText("8.    El  alumno    no podrá   realizar   gestiones  con el campo clínico  para modificaciones  en las");
            run1P3.addBreak();
            run1P3.setText("       condiciones  de práctica  clínica(Unidad  Asignada, horarios, justificación de  falta, etc. ) de lo");
            run1P3.addBreak();
            run1P3.setText("       contrario  será  acreedor  a  sanción por la Universidad.");
            run1P3.addBreak();
            run1P3.setText("9.    Es obligación de los alumnos acudir al 100% de la práctica clínica, de lo contrario se causará baja");
            run1P3.addBreak();
            run1P3.setText("       definitiva del campo clínico teniendo como consecuencia la no acreditación de la materia práctica.");
            run1P3.addBreak();
            run1P3.setText("10.  Es obligación de los alumnos contar con esquema de vacunación completo: Toxoide Tetánico., Hepatitis B,");
            run1P3.addBreak();
            run1P3.setText("       Sarampión y Rubeola e Influenza.");
            run1P3.addBreak();
            run1P3.setText("11.  Es obligación del alumno mantener actualizada la información proporcionada a la coordinación de campos");
            run1P3.addBreak();
            run1P3.setText("       clínico y notificar a la misma sí existiera cambio de vigencia en seguridad social, esquema");
            run1P3.addBreak();
            run1P3.setText("       de vacunación, teléfonos, etc.");
            run1P3.addBreak();
            run1P3.setText("12.  Es obligación del alumno notificar de forma inmediata incidentes que pongan en riesgo la estancia");
            run1P3.addBreak();
            run1P3.setText("       en la unidad o institución donde se realice la práctica, así como incidentes que pongan en");
            run1P3.addBreak();
            run1P3.setText("       riesgo la salud del practicante.");
            run1P3.addBreak();
            run1P3.setText("13.  Si el alumno abandona el campo clínico por su propia voluntad o es dado de baja por la institución");
            run1P3.addBreak();
            run1P3.setText("       receptora, perderá su derecho a la acreditación de práctica clínica.");
            run1P3.addBreak();
            run1P3.setText("14.  La institución de salud podrá dar de baja al alumno que no cumpla con los acuerdos establecidos");
            run1P3.addBreak();
            run1P3.setText("       en esta carta compromiso y reglamento institucional, notificándolo por escrito al área de");
            run1P3.addBreak();
            run1P3.setText("       Dirección Académica de Fisioterapia de UNITEC, campus Ecatepec.");
            run1P3.addBreak();

            XWPFParagraph p4 = wordDocument.createParagraph();
            p4.setAlignment(ParagraphAlignment.CENTER);

            XWPFRun run1P4 = p4.createRun();
            run1P4.setBold(true);

            run1P4.setText("DATOS  DE INSCRIPCIÓN");
            run1P4.addBreak();

            XWPFTable table2 = wordDocument.createTable(2,2);


            table2.getRow(0).getCell(0).setText("GRUPO TEORÍA");
            table2.getRow(0).getCell(1).setText("IGRUPO PRÁCTICA");
            table2.getRow(1).getCell(0).setText("GRUPO TEORÍA");
            table2.getRow(1).getCell(1).setText("IGRUPO PRÁCTICA");


            wordDocument.write(baos);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }
}
