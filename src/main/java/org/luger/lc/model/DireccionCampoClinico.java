package org.luger.lc.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(schema = "laboratorios_computo",name = "direccion_campo_clinico")
public class DireccionCampoClinico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "calle_avenida")
    private String calleAvenida;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Basic(optional = false)
    @Column(name = "delegacion_municipio")
    private String delegacionMunicipio;
    @Basic(optional = false)
    @Column(name = "entidad_federativa")
    private String entidadFederativa;
    @Column(name = "referencia")
    private String referencia;
    @JoinColumn(name = "campo_clinico_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CampoClinico campoClinico;

    public DireccionCampoClinico() {
    }

    public DireccionCampoClinico(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalleAvenida() {
        return calleAvenida;
    }

    public void setCalleAvenida(String calleAvenida) {
        this.calleAvenida = calleAvenida;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDelegacionMunicipio() {
        return delegacionMunicipio;
    }

    public void setDelegacionMunicipio(String delegacionMunicipio) {
        this.delegacionMunicipio = delegacionMunicipio;
    }

    public String getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionCampoClinico)) {
            return false;
        }
        DireccionCampoClinico other = (DireccionCampoClinico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.luger.lc.model.DireccionCampoClinico[ id=" + id + " ]";
    }
    
}
