/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aeropuerto;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Yonathan
 */
public class Silla implements Serializable{
    private String id;
    private Boolean disponible;
    private Double precio;
    HashMap<Integer,Persona>persona;

    public Silla(String id, Boolean disponible, Double precio) {
        this.id = id;
        this.disponible = disponible;
        this.precio = precio;
        persona = new HashMap();
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<Integer, Persona> getPersona() {
        return persona;
    }

    public void setPersona(HashMap<Integer, Persona> persona) {
        this.persona = persona;
    }
    
    
}
