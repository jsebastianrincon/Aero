package Aeropuerto;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Juan Sebastian
 */

/* Clase para guardar los atributos del avion*/
public class Avion implements Serializable{
    private String id;
    private String aerolinea;
    private String categoria;
    private Double ingreso;
    private boolean estado;
    HashMap<String,Vip>vip;
    HashMap<String,General>general;

    /* Clase avion para hacer la referenciacion de los parametros */
    public Avion(String id, String aerolinea, String categoria, Double ingreso, boolean estado) {
        this.id = id;
        this.aerolinea = aerolinea;
        this.categoria = categoria;
        this.ingreso = ingreso;
        this.estado = estado;
        vip=new HashMap();
        general=new HashMap();
    }
    /* Getters Y Setters para cada uno de los parametros */
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getIngreso() {
        return ingreso;
    }

    public void setIngreso(Double ingreso) {
        this.ingreso = ingreso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public HashMap<String, Vip> getVip() {
        return vip;
    }

    public void setVip(HashMap<String, Vip> vip) {
        this.vip = vip;
    }
    
    public HashMap<String, General> getGeneral() {
        return general;
    }

    public void setGeneral(HashMap<String, General> general) {
        this.general = general;
    }
    
    
}
