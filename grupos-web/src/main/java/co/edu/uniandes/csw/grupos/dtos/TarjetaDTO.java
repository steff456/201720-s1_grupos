/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.grupos.dtos;

import co.edu.uniandes.csw.grupos.entities.TarjetaEntity;

/**
 *
 * @author af.lopezf
 */
public class TarjetaDTO {
    
    private int numero;
    private double dineroDisponible;
    private String banco;
    private double maxCupo;
    
    
    /**
     * Constructor por defecto
     */
    public TarjetaDTO(){  
    }
    
    
        /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param tarjeta: Es la entidad que se va a convertir a DTO 
     */
    public TarjetaDTO(TarjetaEntity tarjeta) {
        this.numero = tarjeta.getNumero();
        this.dineroDisponible = tarjeta.getDineroDisponible();
        this.banco = tarjeta.getBanco();
        this.maxCupo = tarjeta.getMaxCupo();
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the dineroDisponible
     */
    public double getDineroDisponible() {
        return dineroDisponible;
    }

    /**
     * @param dineroDisponible the dineroDisponible to set
     */
    public void setDineroDisponible(double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the maxCupo
     */
    public double getMaxCupo() {
        return maxCupo;
    }

    /**
     * @param maxCupo the maxCupo to set
     */
    public void setMaxCupo(double maxCupo) {
        this.maxCupo = maxCupo;
    }
    
        /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public TarjetaEntity toEntity() {
        TarjetaEntity entity = new TarjetaEntity();
        entity.setNumero(this.numero);
        entity.setDineroDisponible(this.dineroDisponible);
        entity.setBanco(this.banco);
        entity.setMaxCupo(this.maxCupo);
        return entity;
    }
    
    
}