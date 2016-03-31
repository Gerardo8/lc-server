package org.luger.lc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "laboratorios_computo")
public class Alumno extends Usuario implements Serializable{

    @Column(name = "numero_cuenta")
    private String numeroCuenta;
    private float promedio;
    @JoinColumn(name = "grupo_practica_id", referencedColumnName = "id")
    @ManyToOne
    private GrupoPractica grupoPractica;
    @JoinColumn(name = "grupo_teoria_id", referencedColumnName = "id")
    @ManyToOne
    private GrupoTeoria grupoTeoria;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public GrupoPractica getGrupoPractica() {
        return grupoPractica;
    }

    public void setGrupoPractica(GrupoPractica grupoPractica) {
        this.grupoPractica = grupoPractica;
    }

    public GrupoTeoria getGrupoTeoria() {
        return grupoTeoria;
    }

    public void setGrupoTeoria(GrupoTeoria grupoTeoria) {
        this.grupoTeoria = grupoTeoria;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", promedio=" + promedio +
                ", grupoPractica=" + grupoPractica +
                ", grupoTeoria=" + grupoTeoria +
                '}';
    }
}

