package org.luger.lc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(schema = "laboratorios_computo",name = "campo_clinico")
public class CampoClinico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campoClinico")
    private List<DireccionCampoClinico> direccionesCamposClinicos;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campoClinico")
    private List<GrupoPractica> gruposPractica;

    public CampoClinico() {
    }

    public CampoClinico(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DireccionCampoClinico> getDireccionesCamposClinicos() {
        return direccionesCamposClinicos;
    }

    public void setDireccionesCamposClinicos(List<DireccionCampoClinico> direccionesCamposClinicos) {
        this.direccionesCamposClinicos = direccionesCamposClinicos;
    }

    public List<GrupoPractica> getGruposPractica() {
        return gruposPractica;
    }

    public void setGruposPractica(List<GrupoPractica> gruposPractica) {
        this.gruposPractica = gruposPractica;
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
        if (!(object instanceof CampoClinico)) {
            return false;
        }
        CampoClinico other = (CampoClinico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.luger.lc.model.CampoClinico[ id=" + id + " ]";
    }
    
}
