package Aeropuerto;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Yonathan
 */
public class Avion implements Serializable{
    private String id;
    private String aerolinea;
    HashMap<String,Silla>silla;

    public Avion(String id, String aerolinea) {
        this.id = id;
        this.aerolinea = aerolinea;
        silla=new HashMap();
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

    public HashMap<String, Silla> getSilla() {
        return silla;
    }

    public void setSilla(HashMap<String, Silla> silla) {
        this.silla = silla;
    }
    
    
}
