package org.luger.lc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "laboratorios_computo")
public class Vacuna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @JoinColumn(name = "alumno_id", referencedColumnName = "id")
    @ManyToOne
    private Alumno alumno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Vacuna{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alumno=" + alumno +
                '}';
    }
}
