/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.grupos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Entidad de evento.<br>
 * @author js.ramos14
 */
@Entity
public class EventoEntity implements Serializable{
    /**
     * Id del usuario.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre del usuario
     */
    private String nombre;
    /**
     * Fecha dada.
     */
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    /**
     * Fecha de fin del evento
     */
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    /**
     * Relación con grupo.
     */
    @PodamExclude
    @ManyToOne
    private GrupoEntity grupo;
    /*
    Relación con lugar
    */
    @PodamExclude
    @OneToOne
    private LugarEntity lugar;
    /**
     * Relación con usuarios
     */
    @PodamExclude
    @ManyToMany(mappedBy = "eventos")
    private List<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();
    
    /**
     * Relación con patrocinios
     */
    @PodamExclude
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PatrocinioEntity> patrocinios = new ArrayList<PatrocinioEntity>();
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    /**
     * @return the grupo
     */
    public GrupoEntity getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(GrupoEntity grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the lugar
     */
    public LugarEntity getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(LugarEntity lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the usuarios
     */
    public List<UsuarioEntity> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * @return the patrocinios
     */
    public List<PatrocinioEntity> getPatrocinios() {
        return patrocinios;
    }

    /**
     * @param patrocinios the patrocinios to set
     */
    public void setPatrocinios(List<PatrocinioEntity> patrocinios) {
        this.patrocinios = patrocinios;
    }
    /**
     * Override del equals.<br>
     * @param o Objeto a comparar.<br>
     * @return Si son iguales
     */
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof EventoEntity))
            return false;
        EventoEntity u=(EventoEntity) o;
        return id.equals(u.getId());
    }
/**
 * Override del hash.<br>
 * @return hashcode
 */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }
}
