package Aeropuerto;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 */
public class Avion implements Serializable{
    private String id;
    private String aerolinea;
    private String categoria;
    private Double ingreso;
    HashMap<String,Vip>vip;
    HashMap<String,General>general;

    public Avion(String id, String aerolinea, String categoria, Double ingreso) {
        this.id = id;
        this.aerolinea = aerolinea;
        this.categoria = categoria;
        this.ingreso = ingreso;
        vip=new HashMap();
        general=new HashMap();
    }

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
