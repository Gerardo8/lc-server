package org.luger.lc.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "campo_clinico",schema = "laboratorios_computo")
public class CampoClinico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

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

    @Override
    public String toString() {
        return "CampoClinico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
