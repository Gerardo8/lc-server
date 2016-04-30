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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "laboratorios_computo",name = "alumno")
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero_cuenta")
    private String numeroCuenta;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "promedio")
    private float promedio;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<Vacuna> vacunas;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<TelefonoAlumno> telefonosAlumno;
    @JoinColumn(name = "grupo_practica_id", referencedColumnName = "id")
    @ManyToOne
    private GrupoPractica grupoPractica;
    @JoinColumn(name = "grupo_teoria_id", referencedColumnName = "id")
    @ManyToOne
    private GrupoTeoria grupoTeoria;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<DocumentoAlumno> documentosAlumno;

    public Alumno() {
    }

    public Alumno(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public List<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(List<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }

    public List<TelefonoAlumno> getTelefonosAlumno() {
        return telefonosAlumno;
    }

    public void setTelefonosAlumno(List<TelefonoAlumno> telefonosAlumno) {
        this.telefonosAlumno = telefonosAlumno;
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

    public List<DocumentoAlumno> getDocumentosAlumno() {
        return documentosAlumno;
    }

    public void setDocumentosAlumno(List<DocumentoAlumno> documentosAlumno) {
        this.documentosAlumno = documentosAlumno;
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
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.luger.lc.model.Alumno[ id=" + id + " ]";
    }
    
}
