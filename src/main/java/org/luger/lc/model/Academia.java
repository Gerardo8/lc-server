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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "laboratorios_computo",name = "academia")
public class Academia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ciclo")
    private String ciclo;
    @Basic(optional = false)
    @Column(name = "cuatrimestre")
    private String cuatrimestre;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "academia")
    private List<GrupoPractica> gruposPractica;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "academia")
    private List<GrupoTeoria> gruposTeoria;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "academia")
    private List<Induccion> inducciones;

    public Academia() {
    }

    public Academia(Integer id) {
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

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public List<GrupoPractica> getGruposPractica() {
        return gruposPractica;
    }

    public void setGruposPractica(List<GrupoPractica> gruposPractica) {
        this.gruposPractica = gruposPractica;
    }

    public List<GrupoTeoria> getGruposTeoria() {
        return gruposTeoria;
    }

    public void setGruposTeoria(List<GrupoTeoria> gruposTeoria) {
        this.gruposTeoria = gruposTeoria;
    }

    public List<Induccion> getInducciones() {
        return inducciones;
    }

    public void setInducciones(List<Induccion> inducciones) {
        this.inducciones = inducciones;
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
        if (!(object instanceof Academia)) {
            return false;
        }
        Academia other = (Academia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.luger.lc.model.Academia[ id=" + id + " ]";
    }
    
}
