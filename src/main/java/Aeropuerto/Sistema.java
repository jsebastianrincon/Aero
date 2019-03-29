package Aeropuerto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author Juan Sebastian
 * 
 */

/*Clase sistema para el manejo de los mapas del avion y de las personas*/
public class Sistema {
    private HashMap<String,Avion> aviones;
    private HashMap<String,Persona> personas;
    
/*Metodo sistema para crear los nuevos mapas para los atributo persona y avion*/   
    public Sistema(){
        aviones=new HashMap();
        personas=new HashMap();
    }
    /* Metodo para el manejo del guardado del archivo */
    
    public void guardarArchivo(HashMap<String, Avion> hmAviones){
        try{
            File fileOne=new File("Archivos/Aerolinea");
            FileOutputStream fos=new FileOutputStream(fileOne);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            
            oos.writeObject(hmAviones);
            oos.flush();
            oos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    /* Metodo para el manejo de la lectura del archivo */
    public HashMap leerArchivo(){
        try{
            File toRead=new File("Archivos/Aerolinea");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            aviones=(HashMap<String,Avion>)ois.readObject();
            
            ois.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        } 
        return aviones;
    }
    /* Metodo para el manejo del guardado del archivo con los datos y atributos del cliente */
    public void guardarArchivoCliente(HashMap<String, Persona> hmPersonas){
        try{
            File fileOne=new File("Archivos/Clientes");
            FileOutputStream fos=new FileOutputStream(fileOne);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            
            oos.writeObject(hmPersonas);
            oos.flush();
            oos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    /* Metodo para la lectura del archivo */
    public HashMap leerArchivoCliente(){
        try{
            File toRead=new File("Archivos/Clientes");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            personas=(HashMap<String,Persona>)ois.readObject();
            
            ois.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        } 
        return personas;
    }
}