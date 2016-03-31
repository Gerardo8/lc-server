package org.luger.lc.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "horario_grupo_teoria",schema = "laboratorios_computo")
public class HorarioGrupoTeoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String turno;
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    @Column(name = "hora_fin")
    private LocalTime horaFin;
    @JoinColumn(name = "grupo_teoria_id", referencedColumnName = "id")
    @ManyToOne
    private GrupoTeoria grupoTeoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public GrupoTeoria getGrupoTeoria() {
        return grupoTeoria;
    }

    public void setGrupoTeoria(GrupoTeoria grupoTeoria) {
        this.grupoTeoria = grupoTeoria;
    }

    @Override
    public String toString() {
        return "HorarioGrupoTeoria{" +
                "id=" + id +
                ", turno='" + turno + '\'' +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", grupoTeoria=" + grupoTeoria +
                '}';
    }
}
