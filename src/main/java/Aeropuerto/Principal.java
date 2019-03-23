package Aeropuerto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yonathan
 */
public class Principal implements Serializable{
    public BufferedReader entradaDatos=new BufferedReader(new InputStreamReader (System.in));
    private HashMap<String,Avion> aviones;
    private HashMap<String,Persona> personas;
    Sistema sistema = new Sistema();
    public Principal(){
        aviones=new HashMap();
        personas=new HashMap();
    }
    public void Menu(){
        try{
            String opcion = "";
            do{
                aviones = sistema.leerArchivo();
                
                System.out.println("+ - - - - - - - - - - - - - - - - - - +");
                System.out.println("|   Bienvenido a Aeropuerto UdeC.     |");
                System.out.println("+ - - - - - - - - - - - - - - - - - - +");
                System.out.println("|                                     |");
                System.out.println("|   1. Agregar Avion.                 |");
                System.out.println("|   2. Vender Tiquete.                |");
                System.out.println("|   3. Ver Datos.                     |");
                System.out.println("|   4.                                |");
                System.out.println("|   0. Salir.                         |");
                System.out.println("+ - - - - - - - - - - - - - - - - - - +");
                opcion = entradaDatos.readLine();
                
                switch(opcion){
                    case"1":
                        System.out.println("Datos del Avión");
                        System.out.println("Codigo:");
                        String idAvion=entradaDatos.readLine();
                        crearAvion(idAvion);
                        sistema.guardarArchivo(aviones);
                        break;
                    case"2":
                        System.out.println("Cedula Cliente:");
                        String idCliente=entradaDatos.readLine();
                        venderTiquete(idCliente);
                        break;
                    case"3":
                        verDatos();
                        break;
                    case"0":
                        System.exit(0);
                        break;
                }
            }while(!opcion.equals("0"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void crearAvion(String id){
        try{
            if(aviones.containsKey(id)){
                System.out.println("El avión ya está registrado.");
            }else{
                System.out.println("Aerolinea:");
                String aerolinea=entradaDatos.readLine();
                Avion avion=new Avion(id, aerolinea);
                aviones.put(id, avion);
                agregarSillas(id, aerolinea);
                System.out.println("Avión Registrado en el sistema");
            }
        }catch(IOException e){
            
        }
    }
    public void agregarSillas(String idAvion, String aerolinea){
        try{
            String categoria="";
            Double precioVip, precioEco;
        do{
            System.out.println("+ - - - - - - - - - - - - +");
            System.out.println("|  Categoría del Avión.   |");
            System.out.println("+ - - - - - - - - - - - - +");
            System.out.println("|                         |");
            System.out.println("|   1. VIP.               |");
            System.out.println("|   2. Clasico.           |");
            System.out.println("|   3. Mixto.             |");
            System.out.println("+ - - - - - - - - - - - - +");
            categoria=entradaDatos.readLine();
            switch(categoria){
                case"1":
                    System.out.println("Precio Vuelo VIP en la aerolinea "+aerolinea+":");
                    precioVip=Double.parseDouble(entradaDatos.readLine());
                    for(int i=1;i<=4;i++){
                        String idSilla="VIP-"+i;
                        crearSilla(idSilla, idAvion, precioVip);
                    }
                    break;
                case"2":
                    System.out.println("Precio Vuelo Clasico en la aerolinea "+aerolinea+":");
                    precioEco=Double.parseDouble(entradaDatos.readLine());
                    for(int i=1;i<=12;i++){
                        String idSilla="ECO-"+i;
                        crearSilla(idSilla, idAvion, precioEco);
                    }
                    break;
                case"3":
                    System.out.println("Precio Vuelo VIP en la aerolinea "+aerolinea+":");
                    precioVip=Double.parseDouble(entradaDatos.readLine());
                    System.out.println("Precio Vuelo Clasico en la aerolinea "+aerolinea+":");
                    precioEco=Double.parseDouble(entradaDatos.readLine());
                    for(int i=1;i<=4;i++){
                        String idSilla="VIP-"+i;
                        crearSilla(idSilla, idAvion, precioVip);
                    }
                    for(int i=1;i<=12;i++){
                        String idSilla="ECO-"+i;
                        crearSilla(idSilla, idAvion, precioEco);
                    }
                    break;
                default:
                    System.out.println("Opcion no valida...");
                    break;
            }
        }while(!(categoria.equals("1") || categoria.equals("2") || categoria.equals("3")));
        }catch(Exception e){
            
        }
    }
    public void crearSilla(String id, String idAvion, Double precio){
        Silla sillaAvion=new Silla(id, true, precio);
        if(aviones.get(idAvion).getSilla().containsKey(id)){
            System.out.println("La Silla ya está Registrada");
        }else{
            aviones.get(idAvion).getSilla().put(id, sillaAvion);
        }
    }
    
    public void venderTiquete(String id){
        try{
            personas = sistema.leerArchivoCliente();
            if(personas.containsKey(id)){
                System.out.println("Datos para el Tiquete.");
                for(Avion a : aviones.values()){
                    System.out.println("Avion "+a.getId()+" de la empresa "+a.getAerolinea());
                }
            }else{
                System.out.println("El cliente no está registrado en el sistema.");
                System.out.println("Desea registrar el cliente con el id "+id+"? (s/n)");
                String eleccion = entradaDatos.readLine();
                if(eleccion.equals("s") || eleccion.equals("S")){
                    System.out.println("Datos del Cliente.");
                    System.out.println("Nombre:");
                    String nombre = entradaDatos.readLine();
                    System.out.println("Apellido:");
                    String apellido = entradaDatos.readLine();
                    System.out.println("Fecha de nacimiento:");
                    System.out.println("Introduzca la fecha con formato dd/mm/yyyy");
                    String fecha = entradaDatos.readLine();
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    Date testDate = null, fechaA = new Date();
                    String date = fecha;
                    try{
                        testDate = df.parse(date);
                        if (!(df.format(testDate).equals(date)) || (testDate.compareTo(fechaA) >= 0)){
                            System.out.println("Fecha no válida!!");
                        } else {
                            System.out.println("Fecha Válida");
                            crearCliente(id, nombre, apellido, testDate);
                            sistema.guardarArchivoCliente(personas);
                            venderTiquete(id);
                        }
                    } catch (Exception e){ System.out.println(e.getCause());}
                }else if(eleccion.equals("n") || eleccion.equals("N")){
                    System.out.println("Volviendo al menu principal.");
                }else{
                    System.out.println("Opcion no valida, regresando al menú principal.");
                }
            }
        }catch(IOException e){
            
        }
    }
    
    public void crearCliente(String id, String nombre, String apellido, Date fechaN){
        Persona cliente=new Persona(id, nombre, apellido, fechaN);
        if(personas.containsKey(id)){
            System.out.println("El cliente ya está registrado.");
        }else{
            personas.put(id, cliente);
        }
    }
    
    public void verDatos(){
        aviones = sistema.leerArchivo();
        for(Map.Entry<String,Avion> m :aviones.entrySet()){
            System.out.println("Avion: "+m.getKey()+" : "+m.getValue().getAerolinea());
            for (Silla s : aviones.get(m.getKey()).getSilla().values()) {
                System.out.println("\tSilla: "+s.getId());
            }
        }
    }
}