package Aeropuerto;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 */
public class Vip implements Serializable{
    private String ubicacion;
    private String estado;
    private Double precio;
    HashMap<String,Persona>persona;

    public Vip(String ubicacion, String estado, Double precio) {
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.precio = precio;
        persona=new HashMap();
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public HashMap<String, Persona> getPersona() {
        return persona;
    }

    public void setPersona(HashMap<String, Persona> persona) {
        this.persona = persona;
    }
    
    
}
