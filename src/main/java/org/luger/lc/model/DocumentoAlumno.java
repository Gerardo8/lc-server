package org.luger.lc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "documento_alumno",schema = "laboratorios_computo")
public class DocumentoAlumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @JsonIgnore
    private String tipo;
    @JsonIgnore
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] contenido;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "DocumentoAlumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", contenido=" + Arrays.toString(contenido) +
                ", alumno=" + alumno +
                '}';
    }
}
