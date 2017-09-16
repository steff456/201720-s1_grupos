/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.grupos.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.guzmanm
 */
@Entity
public class CalificacionEntity implements Serializable {
    private Double calificacion;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @PodamExclude
    @OneToOne (cascade=CascadeType.PERSIST)
    private UsuarioEntity calificador;
    @PodamExclude
    @ManyToOne (cascade=CascadeType.PERSIST)
    private BlogEntity blog;

    public UsuarioEntity getCalificador() {
        return calificador;
    }

    public void setCalificador(UsuarioEntity calificador) {
        this.calificador = calificador;
    }

    public BlogEntity getBlog() {
        return blog;
    }

    public void setBlog(BlogEntity blog) {
        this.blog = blog;
    }
    
    public Double getCalificacion() {
        return calificacion;
    }
    

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
