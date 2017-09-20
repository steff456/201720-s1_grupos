/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.grupos.dtos;

import co.edu.uniandes.csw.grupos.entities.LugarEntity;

/**
 *
 * @author js.ramos14
 */
public class LugarDTO {
    
    private Long id;
    
    private String direccion;
    
    private String nombre;
    
    
    public LugarDTO()
    {
        
    }
    public LugarDTO(LugarEntity entity)
    {
        this.id = entity.getId();
        this.nombre = entity.getNombre();
        this.direccion = entity.getDireccion();
    }

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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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


    
    public LugarEntity toEntity()
    {
        LugarEntity entity = new LugarEntity();
        entity.setId(this.id);
        entity.setDireccion(this.direccion);
        entity.setNombre(this.nombre);
        return entity;
    }
}
