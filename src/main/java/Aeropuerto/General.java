package Aeropuerto;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Juan Sebastian
 */

/*Clase para manejar la categoria general del vuelo con la respectiva ubicacion,estado y precio*/
public class General implements Serializable{
    private String ubicacion;
    private String estado;
    private Double precio;
    HashMap<String,Persona>persona;

    
/* Clase general para hacer la referenciacion de los parametros con la ubicacion en el avion,el estado y precio*/
    public General(String ubicacion, String estado, Double precio) {
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.precio = precio;
        persona = new HashMap();
    }
/* Getters Y Setters para cada uno de los parametros (Estado y ubicacion) y el mapa de las personaas y el avion*/
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
