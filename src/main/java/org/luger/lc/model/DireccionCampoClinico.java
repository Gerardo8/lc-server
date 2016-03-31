package org.luger.lc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "direccion_campo_clinico",schema = "laboratorios_computo")
public class DireccionCampoClinico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "entidad_federativa")
    private String entidadFederativa;
    @Column(name = "delegacion_municipio")
    private String delegacionMunicipio;
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Column(name = "calle_avenida")
    private String calleAvenida;
    private String colonia;
    private String numero;
    private String referencia;
    @ManyToOne
    @JoinColumn(name = "campo_clinico_id", referencedColumnName = "id")
    private CampoClinico campoClinico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    public String getDelegacionMunicipio() {
        return delegacionMunicipio;
    }

    public void setDelegacionMunicipio(String delegacionMunicipio) {
        this.delegacionMunicipio = delegacionMunicipio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalleAvenida() {
        return calleAvenida;
    }

    public void setCalleAvenida(String calleAvenida) {
        this.calleAvenida = calleAvenida;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public CampoClinico getCampoClinico() {
        return campoClinico;
    }

    public void setCampoClinico(CampoClinico campoClinico) {
        this.campoClinico = campoClinico;
    }

    @Override
    public String toString() {
        return "DireccionCampoClinico{" +
                "id=" + id +
                ", entidadFederativa='" + entidadFederativa + '\'' +
                ", delegacionMunicipio='" + delegacionMunicipio + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", calleAvenida='" + calleAvenida + '\'' +
                ", colonia='" + colonia + '\'' +
                ", numero='" + numero + '\'' +
                ", referencia='" + referencia + '\'' +
                ", campoClinico=" + campoClinico +
                '}';
    }
}
