package Aeropuerto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Juan Sebastian
 */

/* Clase para guardar los atributos de la clase persona */
public class Persona implements Serializable{
    private String identificacion;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    
/* Clase persona para hacer la referenciacion de los parametros */
    public Persona(String identificacion, String nombre, String apellido, Date fechaNacimiento) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }
/* Getters Y Setters para cada uno de los parametros */
    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
