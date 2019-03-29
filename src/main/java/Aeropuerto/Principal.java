package Aeropuerto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Juan Sebastian
 */

/*Clase principal donde se realizara toda la logica del proyecto*/

public class Principal implements Serializable{
    public BufferedReader entradaDatos=new BufferedReader(new InputStreamReader (System.in));
    private HashMap<String,Avion> aviones;
    private HashMap<String,Persona> personas;
    Sistema sistema = new Sistema();
    PintarAvion pintar = new PintarAvion();
    public Principal(){
        aviones=new HashMap();
        personas=new HashMap();
    }
    
    /*Menú principal */
    public void Menu(){
        try{
            String opcion = "";
            do{
                //Carga Datos
                aviones = sistema.leerArchivo();
                //Menú 
                System.out.println("1. Agregar Avion ");
                System.out.println("2. Vender Tiquete ");
                System.out.println("3. Despegar Avión ");
                System.out.println("4. Datos Aviones ");
                System.out.println("5. Salir ");
                opcion = entradaDatos.readLine();
                
                switch(opcion){
                    case"1":
                        //Ingresa id para el avión para verificar que no exista.
                        System.out.println("Datos");
                        System.out.println("Id:");
                        String idAvion=entradaDatos.readLine();
                        crearAvion(idAvion);
                        sistema.guardarArchivo(aviones);
                        break;
                    case"2":
                        //Ingresa cedula del cliente
                        System.out.println("Cedula Cliente:");
                        String idCliente=entradaDatos.readLine();
                        venderTiquete(idCliente);
                        break;
                    case"3":
                        //Metodo despegar
                        despegarAvion();
                        break;
                    case"4":
                        //Ver Informacion avion
                        verDatos();
                        break;
                    case"5":
                        //Fin
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción Incorrecta");
                        break;
                }
            }while(!opcion.equals("5"));
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    //Metodo para crear aviones.
    public void crearAvion(String id){
        //Se asigna el parametro id para verificar que no exista el avion
        try{
            if(aviones.containsKey(id)){
                System.out.println("Avion existente");
            }else{
                System.out.println("Aerolinea:");
                String aerolinea=entradaDatos.readLine();
                agregarSillas(id, aerolinea);
                System.out.println("Avión Registrado exitosamente");
            }
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    //Metodo para agregar puestos al avión.
    public void agregarSillas(String idAvion, String aerolinea){
        try{
            Avion avion;
            String categoria="";
            Double precioVip, precioEco;
            do{
                //Menu para seleccionar la categoria
                
                System.out.println("Categoría");
                System.out.println("1.VIP");
                System.out.println("2.General");
                System.out.println("3.Mixto");
                categoria=entradaDatos.readLine();
                int cantidadUno=1, cantidadDos=1;
                boolean esDouble;
                switch(categoria){
                    case"1":
                        avion=new Avion(idAvion, aerolinea, "VIP", 0.0, false);
                        aviones.put(idAvion, avion);
                        String idSilla="";
                        esDouble=false;
                        do{
                            try{
                                System.out.println("Costo silla VIP en la aerolinea "+aerolinea+":");
                                precioVip=Double.parseDouble(entradaDatos.readLine());
                                esDouble=true;
                                for(int i=1;i<=12;i++){
                                    if(i<=6){
                                        idSilla="A"+i;
                                        crearSillaVip(idSilla, idAvion, precioVip);
                                    }else{
                                        idSilla="B"+cantidadUno;
                                        cantidadUno++;
                                        crearSillaVip(idSilla, idAvion, precioVip);
                                    }
                                }
                            }catch(NumberFormatException nfe){
                                System.out.println("Escriba un numero");
                            }
                        }while(!esDouble);
                        break;
                    case"2":
                        avion=new Avion(idAvion, aerolinea, "General", 0.0, false);
                        aviones.put(idAvion, avion);
                        esDouble=false;
                        do{
                            try{
                                System.out.println("Costo silla General en la aerolinea  "+aerolinea+":");
                                precioEco=Double.parseDouble(entradaDatos.readLine());
                                esDouble=true;
                                for(int i=1;i<=24;i++){
                                    if(i<=8){
                                        idSilla="C"+i;
                                        crearSillaGeneral(idSilla, idAvion, precioEco);
                                    }else if(i>8&&i<=16){
                                        idSilla="D"+cantidadUno;
                                        cantidadUno ++;
                                        crearSillaGeneral(idSilla, idAvion, precioEco);
                                    }else if(i>15&&i<=24){
                                        idSilla="E"+cantidadDos;
                                        cantidadDos ++;
                                        crearSillaGeneral(idSilla, idAvion, precioEco);
                                    }
                                }
                            }catch(NumberFormatException nfe){
                                System.out.println("Escriba un numero");
                            }
                        }while(!esDouble);
                        break;
                    case"3":
                        avion=new Avion(idAvion, aerolinea, "Mixto", 0.0, false);
                        aviones.put(idAvion, avion);
                        esDouble=false;
                        do{
                            try{
                                System.out.println("Costo silla VIP en la aerolinea  "+aerolinea+":");
                                precioVip=Double.parseDouble(entradaDatos.readLine());
                                System.out.println("Costo silla General en la aerolinea  "+aerolinea+":");
                                precioEco=Double.parseDouble(entradaDatos.readLine());
                                esDouble=true;
                                for(int i=1;i<=12;i++){
                                    if(i<=6){
                                        idSilla="A"+i;
                                        crearSillaVip(idSilla, idAvion, precioVip);
                                    }else{
                                        idSilla="B"+cantidadUno;
                                        cantidadUno++;
                                        crearSillaVip(idSilla, idAvion, precioVip);
                                    }
                                }
                                cantidadUno=1;
                                for(int i=1;i<=24;i++){
                                    if(i<=8){
                                        idSilla="C"+i;
                                        crearSillaGeneral(idSilla, idAvion, precioEco);
                                    }else if(i>8&&i<=16){
                                        idSilla="D"+cantidadUno;
                                        cantidadUno ++;
                                        crearSillaGeneral(idSilla, idAvion, precioEco);
                                    }else if(i>15&&i<=24){
                                        idSilla="E"+cantidadDos;
                                        cantidadDos ++;
                                        crearSillaGeneral(idSilla, idAvion, precioEco);
                                    }
                                }
                            }catch(NumberFormatException nfe){
                                System.out.println("Escriba un numero");
                            }
                        }while(!esDouble);
                        break;
                    default:
                        System.out.println("Opcion Incorrecta");
                        break;
                }
            }while(!(categoria.equals("1") || categoria.equals("2") || categoria.equals("3")));
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    //Metodo para agregar la silla general al avion.
    public void crearSillaGeneral(String id, String idAvion, Double precio){
        General sillaGeneral=new General(id, "o", precio);
        if(aviones.get(idAvion).getGeneral().containsKey(id)){
            System.out.println("Puesto Registrado");
        }else{
            aviones.get(idAvion).getGeneral().put(id, sillaGeneral);
        }
    }
    
    //Metodo para agregar la silla VIP al avion.
    public void crearSillaVip(String id, String idAvion, Double precio){
        Vip sillaVip=new Vip(id, "O", precio);
        if(aviones.get(idAvion).getVip().containsKey(id)){
            System.out.println("Puesto Registrado");
        }else{
            aviones.get(idAvion).getVip().put(id, sillaVip);
        }
    }
    
    //Metodo para realizar la venta del tiquete.
    public void venderTiquete(String id){
        try{
            String categoria="";
            personas = sistema.leerArchivoCliente();
            if(personas.containsKey(id)){
                boolean vendido=false;
                Double costoVip=0.0, costoGeneral=0.0;
                do{
                    System.out.println("Categoría");
                    System.out.println("1.VIP");
                    System.out.println("2.General");
                    System.out.println("3.Mixto");
                    categoria=entradaDatos.readLine();
                    
                    switch(categoria){
                        case"1":
                            costoVip=pintar.pintarVip();
                            if(costoVip==0.0){
                                vendido=false;
                                System.out.println("No hay Aviones VIP en el sistema.");
                            }else{
                                System.out.println("Precio puesto VIP $"+costoVip);
                                compraCliente(id, costoVip, 0.0);
                                vendido=true;
                            }
                            break;
                        case"2":
                            costoGeneral=pintar.pintarClasico();
                            if(costoGeneral==0.0){
                                vendido=false;
                                System.out.println("No hay Aviones General en el sistema.");
                            }else{
                                System.out.println("Precio puesto General"+costoGeneral);
                                compraCliente(id, 0.0, costoGeneral);
                                vendido=true;
                            }
                            break;
                        case"3":
                            Double[] costo = pintar.pintarMixto();
                            costoVip=costo[0];
                            costoGeneral=costo[1];
                            if(costoVip==0.0 || costoGeneral==0.0){
                                vendido=false;
                                System.out.println("No hay Aviones Mixtos en el sistema.");
                            }else{
                                System.out.println("Precio puesto VIP "+costoVip);
                                System.out.println("Precio puesto General "+costoGeneral);
                                compraCliente(id, costoVip, costoGeneral);
                                vendido=true;
                            }
                            break;
                        default:
                            System.out.println("Opcion invalida");
                            break;
                    }
                }while((!(categoria.equals("1") || categoria.equals("2") || categoria.equals("3"))) || vendido==false);
            }else{
                System.out.println("Cliente inexistente");
                System.out.println("Desea registrar el cliente nuevo "+id+"? (s/n)");
                String eleccion = entradaDatos.readLine();
                if(eleccion.equals("s") || eleccion.equals("S")){
                    System.out.println("Cliente");
                    System.out.println("Nombre:");
                    String nombre = entradaDatos.readLine();
                    System.out.println("Apellido:");
                    String apellido = entradaDatos.readLine();
                    Date testDate = null, fechaA = new Date();
                    System.out.println("Fecha de nacimiento:");
                    do{
                        System.out.println("Introduzca fecha dd/mm/aaaa");
                        String fecha = entradaDatos.readLine();
                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        String date = fecha;
                        try{
                            testDate = df.parse(date);
                            if (!df.format(testDate).equals(date) || (testDate.compareTo(fechaA) >= 0)){
                                System.out.println("Fecha Incorrecta");
                                testDate=null;
                            } else {
                                crearCliente(id, nombre, apellido, testDate);
                                sistema.guardarArchivoCliente(personas);
                                venderTiquete(id);
                            }
                        } catch (ParseException e){ System.out.println("Fecha Incorrecta");}
                    }while(testDate==null);
                }else if(eleccion.equals("n") || eleccion.equals("N")){
                    System.out.println("Opcion Incorrecta");
                }else{
                    System.out.println("Opcion Incorrecta");
                }
            }
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    //Metodo para crear clientes nuevos.
    public void crearCliente(String id, String nombre, String apellido, Date fechaN){
        Persona cliente=new Persona(id, nombre, apellido, fechaN);
        if(personas.containsKey(id)){
            System.out.println("El cliente ya está registrado.");
        }else{
            personas.put(id, cliente);
        }
    }
    
    //Metodo para ver los datos de los aviones.
    public void verDatos(){
        String estado="";
        aviones = sistema.leerArchivo();
        for(Map.Entry<String,Avion> m :aviones.entrySet()){
            int vip=0, ocupadoVip=0, eco=0, ocupadoEco=0;
            System.out.println("Codigo Avion: "+m.getKey()+" : Aerolinea: "+m.getValue().getAerolinea());
            if(aviones.get(m.getKey()).isEstado()==true){
                System.out.println("Ya está en vuelo.");
            }else{
                for (Vip s : aviones.get(m.getKey()).getVip().values()) {
                    if(s.getEstado().equals("O")){
                        vip++;
                        estado="Vacío";
                    }else if(s.getEstado().equals("X")){
                        ocupadoVip++;
                        estado = "Ocupado";
                    }
                }
                int cantidadVip = vip+=ocupadoVip;
                if(cantidadVip>0){
                    System.out.println("Sillas VIP");
                    System.out.println("\tOcupado: "+ocupadoVip);
                    System.out.println("\tLibre: "+vip);
                }
                for (General s : aviones.get(m.getKey()).getGeneral().values()) {
                    if(s.getEstado().equals("o")){
                        eco++;
                        estado="Vacío";
                    }else if(s.getEstado().equals("x")){
                        ocupadoEco++;
                        estado = "Ocupado";
                    }
                }
                int cantidadEco=eco+=ocupadoEco;
                if(cantidadEco>0){
                    System.out.println("Sillas General");
                    System.out.println("\tOcupado: "+ocupadoEco);
                    System.out.println("\tLibre: "+eco);
                }
            }
        }
    }
    
    //Metodo donde se efectúa la venta.
    public void compraCliente(String idCliente, Double costoVip, Double costoGeneral) {
        try{
            if(aviones.isEmpty() ){
                System.out.println("No hay aviones registrados");
            }else{
                boolean existe=false, ocupado=false;
                do{
                    System.out.println("Ingrese el Id del Avión");
                    String idAvion=entradaDatos.readLine();
                    Persona cliente;
                    String nombre=personas.get(idCliente).getNombre();
                    String apellido = personas.get(idCliente).getApellido();
                    Date fechaN = personas.get(idCliente).getFechaNacimiento();
                    if(aviones.containsKey(idAvion)){
                        Double acumulado=0.0;
                        existe=true;
                        String silla="";
                        do{
                            System.out.println("Ingrese Posicion");
                            silla=entradaDatos.readLine();
                            if ((silla.contains("A") || silla.contains("B")) && aviones.get(idAvion).getVip().containsKey(silla)){
                                if(aviones.get(idAvion).getVip().get(silla).getEstado().contains("O")){
                                    ocupado=true;
                                    Vip temp = aviones.get(idAvion).getVip().get(silla);
                                    cliente = new Persona(idCliente, nombre, apellido, fechaN);
                                    temp.getPersona().put(idCliente, cliente);
                                    temp.setEstado("X");
                                    acumulado=acumulado+costoVip;
                                    aviones.get(idAvion).setIngreso(acumulado);
                                    sistema.guardarArchivo(aviones);
                                    pintar.pintarMixto();
                                    System.out.println("Venta VIP correcta");
                                }else{
                                    ocupado=false;
                                    System.out.println("Puesto en uso! Por favor Seleccione otro");
                                }
                            }else if ((silla.contains("C") || silla.contains("D") || silla.contains("E")) && aviones.get(idAvion).getGeneral().containsKey(silla)) {
                                if(aviones.get(idAvion).getGeneral().get(silla).getEstado().contains("o")){
                                    ocupado=true;
                                    General temp = aviones.get(idAvion).getGeneral().get(silla);
                                    cliente = new Persona(idCliente, nombre, apellido, fechaN);
                                    temp.getPersona().put(idCliente, cliente);
                                    temp.setEstado("x");
                                    acumulado=acumulado+costoGeneral;
                                    aviones.get(idAvion).setIngreso(acumulado);
                                    sistema.guardarArchivo(aviones);
                                    pintar.pintarMixto();
                                    System.out.println("Venta General correcta");
                                }
                                else{
                                    ocupado=false;
                                    System.out.println("Puesto en uso! Por favor Seleccione otro");
                                }
                            }else{
                                System.out.println("La ubicacion incorrecta");
                            }
                        }while(!(aviones.get(idAvion).getGeneral().containsKey(silla) ||
                                aviones.get(idAvion).getVip().containsKey(silla)) || ocupado == false);
                    }else{
                        existe=false;
                        System.out.println("Id Incorrecto");
                    }
                }while(existe==false);
            }
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public void despegarAvion(){
        try{
            boolean despego=false;
            verDatos();
            aviones = sistema.leerArchivo();
            if(aviones.isEmpty()){
                System.out.println("Aviones Inexistentes");
            }else{
                do{
                    System.out.println("Codigo del avion: ");
                    String idAvion=entradaDatos.readLine();
                    if(aviones.containsKey(idAvion) && aviones.get(idAvion).getCategoria().equals("VIP")){
                        System.out.println("CLIENTES VIP");
                        for(Vip vi : aviones.get(idAvion).getVip().values()){
                            if (vi.getEstado().contains("X")) {
                                System.out.println("\n\n"+vi.getUbicacion());
                                for (Persona pe : vi.getPersona().values()) {
                                    System.out.println(pe.getIdentificacion());
                                    System.out.println(pe.getNombre()+" "+pe.getApellido());
                                    System.out.println(pe.getFechaNacimiento());
                                }
                            }
                        }
                        System.out.println("Ingresos del avion:  $"+aviones.get(idAvion).getIngreso()+" pesos");
                        aviones.get(idAvion).setEstado(true);
                        sistema.guardarArchivo(aviones);
                        despego=true;
                        System.out.println("Despegó.");
                    }else if(aviones.containsKey(idAvion) && aviones.get(idAvion).getCategoria().equals("Genereal")){
                        System.out.println("CLIENTES GENERAL");
                        for(General ge : aviones.get(idAvion).getGeneral().values()){
                            if (ge.getEstado().contains("x")) {
                                System.out.println(ge.getUbicacion());
                                for (Persona pe : ge.getPersona().values()) {
                                    System.out.println(pe.getIdentificacion());
                                    System.out.println(pe.getNombre()+pe.getApellido());
                                    System.out.println(pe.getFechaNacimiento());
                                }
                            }
                        }
                        System.out.println("Ingresos del avion:  $"+aviones.get(idAvion).getIngreso()+" pesos");
                        aviones.get(idAvion).setEstado(true);
                        sistema.guardarArchivo(aviones);
                        despego=true;
                        System.out.println("Despegó.");
                    }else if(aviones.containsKey(idAvion) && aviones.get(idAvion).getCategoria().equals("Mixto")){
                        System.out.println("CLIENTES VIP");
                        for(Vip vi : aviones.get(idAvion).getVip().values()){
                            if (vi.getEstado().contains("X")) {
                                System.out.println("\n\n"+vi.getUbicacion());
                                for (Persona pe : vi.getPersona().values()) {
                                    System.out.println(pe.getIdentificacion());
                                    System.out.println(pe.getNombre()+" "+pe.getApellido());
                                    System.out.println(pe.getFechaNacimiento());
                                }
                            }
                        }
                        System.out.println("CLIENTES GENERAL");
                        for(General ge : aviones.get(idAvion).getGeneral().values()){
                            if (ge.getEstado().contains("x")) {
                                System.out.println(ge.getUbicacion());
                                for (Persona pe : ge.getPersona().values()) {
                                    System.out.println(pe.getIdentificacion());
                                    System.out.println(pe.getNombre()+" "+pe.getApellido());
                                    System.out.println(pe.getFechaNacimiento());
                                }
                            }
                        }
                        System.out.println("Ingresos del avion es $"+aviones.get(idAvion).getIngreso()+" pesos");
                        aviones.get(idAvion).setEstado(true);
                        sistema.guardarArchivo(aviones);
                        despego=true;
                        System.out.println("Despegó.");
                    }
                    else{
                        despego=false;
                        System.out.println("Avion Inexistente");
                    }
                }while(despego==false);
            }
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}