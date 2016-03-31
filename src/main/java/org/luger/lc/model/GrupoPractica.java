package org.luger.lc.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupo_practica",schema = "laboratorios_computo")
public class GrupoPractica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    private short lugares;
    @JoinColumn(name = "academia_id", referencedColumnName = "id")
    @ManyToOne
    private Academia academia;
    @JoinColumn(name = "campo_clinico_id", referencedColumnName = "id")
    @ManyToOne
    private CampoClinico campoClinico;

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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public short getLugares() {
        return lugares;
    }

    public void setLugares(short lugares) {
        this.lugares = lugares;
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public CampoClinico getCampoClinico() {
        return campoClinico;
    }

    public void setCampoClinico(CampoClinico campoClinico) {
        this.campoClinico = campoClinico;
    }

    @Override
    public String toString() {
        return "GrupoPractica{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", lugares=" + lugares +
                ", academia=" + academia +
                ", campoClinico=" + campoClinico +
                '}';
    }
}
