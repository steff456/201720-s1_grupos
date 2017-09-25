/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.grupos.ejb;
import co.edu.uniandes.csw.grupos.ejb.UsuarioLogic;
import co.edu.uniandes.csw.grupos.entities.*;
import co.edu.uniandes.csw.grupos.exceptions.BusinessException;
import co.edu.uniandes.csw.grupos.persistence.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author tefa
 */
@Stateless
public class PatrocinioLogic {
    
    /**
     * Inyecta la persistencia de patrocinio
     */
    @Inject
    PatrocinioPersistence per;
    
    /**
     * Devuelve todos los patrocinios registrados en la aplicación.
     * @return lista con todos los patrocinios
     * @throws BusinessException 
     */
    public List<PatrocinioEntity> allPatrocinios() throws BusinessException
    {
        return per.findAll();
    }
    
    /**
     * Crea un patrocinio
     * @param ppat nuevo patrocinio
     * @return patrocinio agregado
     * @throws BusinessException si ya existe el patrocinio
     */
    public PatrocinioEntity createPatrocinio(PatrocinioEntity ppat) throws BusinessException
    {
        //Verifica si ya existe un usuario
        PatrocinioEntity found = per.find(ppat.getId()); 
        if(found != null && found == ppat)
        {
            throw new BusinessException("Ya existe un usuario con las especificaciones dadas.");
        }
        else 
        {
            PatrocinioEntity add = per.createEntity(ppat);
            return add;
        }
    }
    
    /**
     * Actualiza el patrocinio con id ingresado por parametro
     * @param idPat identificador del patrocinio
     * @param pPat patrocinio que se quiere actualizar
     * @return patrocinio actualizado
     * @throws BusinessException 
     */
    public PatrocinioEntity updatePatrocinio(Long idPat, PatrocinioEntity pPat) throws BusinessException
    {
        PatrocinioEntity found = per.find(idPat);
        if(found == null)
        {
            throw new BusinessException("No existe el usuario que se quiere actualizar");
        }
        else
        {
            return per.updateEntity(pPat);
        }
    }
}