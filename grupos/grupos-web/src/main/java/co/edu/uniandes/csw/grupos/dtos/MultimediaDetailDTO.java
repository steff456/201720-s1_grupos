/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.grupos.dtos;

import co.edu.uniandes.csw.grupos.entities.MultimediaEntity;

/**
 * DTO detallado de la multimedia
 * @author jc161
 */
public class MultimediaDetailDTO extends MultimediaDTO {
    /**
     * Constructor vacío.
     */
    public MultimediaDetailDTO()
    {
        
    }
    /**
     * Crea un nuevo DTo a partir de la entidad pasada por parámetro.<br>
     * @param e Entidad pasada por parámetro.
     */
    public MultimediaDetailDTO(MultimediaEntity e)
    {
        super(e);
    }

    /**
     * Retorna una entidad a partir del DTO detallado.<br>
     * @return entidad formada.
     */
    @Override
    public MultimediaEntity toEntity()
    {
        MultimediaEntity m = super.toEntity();
        return m;
    }
    
}
