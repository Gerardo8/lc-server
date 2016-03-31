package org.luger.lc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "telefono_alumno",schema = "laboratorios_computo")
public class TelefonoAlumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String tipo;
    @JoinColumn(name = "alumno_id", referencedColumnName = "id")
    @ManyToOne
    private Alumno alumno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "TelefonoAlumno{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", tipo='" + tipo + '\'' +
                ", alumno=" + alumno +
                '}';
    }
}
