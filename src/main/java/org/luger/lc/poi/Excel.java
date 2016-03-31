package org.luger.lc.poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.luger.lc.model.Alumno;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Excel {

    public List<Alumno> getAlumnosFromExcel(MultipartFile file) throws IOException,InvalidFormatException {

        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        List<Alumno> alumnos = new ArrayList<Alumno>();
        for (int i=1;i<sheet.getLastRowNum();i++){
            Row currentRow = sheet.getRow(i);
            Cell numeroCuenta = currentRow.getCell(0);
            Cell nombre = currentRow.getCell(1);
            Cell apellidos = currentRow.getCell(2);
            Cell promedio = currentRow.getCell(3);
            numeroCuenta.setCellType(1);

            Alumno alumno = new Alumno();
            alumno.setNumeroCuenta(numeroCuenta.getStringCellValue());
            alumno.setNombre(nombre.getStringCellValue());
            alumno.setApellidos(apellidos.getStringCellValue());
            alumno.setPromedio((float) promedio.getNumericCellValue());

            alumnos.add(alumno);

        }
        return alumnos;
    }
}
