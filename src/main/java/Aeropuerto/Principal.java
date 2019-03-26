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
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 */
public class Principal implements Serializable{
    public BufferedReader entradaDatos=new BufferedReader(new InputStreamReader (System.in));
    private HashMap<String,Avion> aviones;
    private HashMap<String,Persona> personas;
    Double acumulado=0.0;
    Sistema sistema = new Sistema();
    public Principal(){
        aviones=new HashMap();
        personas=new HashMap();
    }
    
    //Metodo del menú principal.
    public void Menu(){
        try{
            String opcion = "";
            do{
                //Carga los datos del Archivo Aerolinea
                aviones = sistema.leerArchivo();
                //Menú principal
                System.out.println("+ - - - - - - - - - - - - - - - - - - +");
                System.out.println("|   Bienvenido a Aeropuerto UdeC.     |");
                System.out.println("+ - - - - - - - - - - - - - - - - - - +");
                System.out.println("|                                     |");
                System.out.println("|   1. Agregar Avion.                 |");
                System.out.println("|   2. Vender Tiquete.                |");
                System.out.println("|   3. Despegar Avión.                |");
                System.out.println("|   4. Ver Datos Aviones.             |");
                System.out.println("|                                     |");
                System.out.println("|   0. Salir.                         |");
                System.out.println("+ - - - - - - - - - - - - - - - - - - +");
                opcion = entradaDatos.readLine();
                
                switch(opcion){
                    case"1":
                        //Solicita un codigo para el avión para verificar que no exista.
                        System.out.println("Datos del Avión");
                        System.out.println("Codigo:");
                        String idAvion=entradaDatos.readLine();
                        crearAvion(idAvion);
                        sistema.guardarArchivo(aviones);
                        break;
                    case"2":
                        //Dolicita la cedula del cliente para verificar que no exista.
                        System.out.println("Cedula Cliente:");
                        String idCliente=entradaDatos.readLine();
                        venderTiquete(idCliente);
                        break;
                    case"3":
                        //Metodo para despegar
                        despegarAvion();
                        break;
                    case"4":
                        //Ver datos de los avión
                        verDatos();
                        break;
                    case"0":
                        //Finaliza el programa
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida...");
                        break;
                }
            }while(!opcion.equals("0"));
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    //Metodo para crear aviones.
    public void crearAvion(String id){
        //Recibimos como parametro el id del avion para verificar que no exista
        //y si no existe, crea el avión.
        try{
            if(aviones.containsKey(id)){
                System.out.println("El avión ya está registrado.");
            }else{
                System.out.println("Aerolinea:");
                String aerolinea=entradaDatos.readLine();
                agregarSillas(id, aerolinea);
                System.out.println("Avión Registrado en el sistema");
            }
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    //Metodo para agregar Sillas al avión.
    public void agregarSillas(String idAvion, String aerolinea){
        //Recibimos como parametros el id del avion, y la aerolinea
        try{
            Avion avion;
            String categoria="";
            Double precioVip, precioEco;
            do{
                //Mostramos un submenú para seleccionar el tipo de avión
                System.out.println("+ - - - - - - - - - - - - +");
                System.out.println("|  Categoría del Avión.   |");
                System.out.println("+ - - - - - - - - - - - - +");
                System.out.println("|                         |");
                System.out.println("|   1. VIP.               |");
                System.out.println("|   2. General.           |");
                System.out.println("|   3. Mixto.             |");
                System.out.println("+ - - - - - - - - - - - - +");
                categoria=entradaDatos.readLine();
                int cantidadUno=1, cantidadDos=1;
                boolean esDouble;
                switch(categoria){
                    case"1":
                        avion=new Avion(idAvion, aerolinea, "VIP", 0.0);
                        aviones.put(idAvion, avion);
                        String idSilla="";
                        esDouble=false;
                        do{
                            try{
                                System.out.println("Precio Vuelo VIP en la aerolinea "+aerolinea+":");
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
                        avion=new Avion(idAvion, aerolinea, "Genereal", 0.0);
                        aviones.put(idAvion, avion);
                        esDouble=false;
                        do{
                            try{
                                System.out.println("Precio Vuelo General en la aerolinea "+aerolinea+":");
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
                        avion=new Avion(idAvion, aerolinea, "Mixto", 0.0);
                        aviones.put(idAvion, avion);
                        esDouble=false;
                        do{
                            try{
                                System.out.println("Precio Vuelo VIP en la aerolinea "+aerolinea+":");
                                precioVip=Double.parseDouble(entradaDatos.readLine());
                                System.out.println("Precio Vuelo Clasico en la aerolinea "+aerolinea+":");
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
                        System.out.println("Opcion no valida...");
                        break;
                }
            }while(!(categoria.equals("1") || categoria.equals("2") || categoria.equals("3")));
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    //Metodo para agregar la silla general al hashmap del avion.
    public void crearSillaGeneral(String id, String idAvion, Double precio){
        General sillaGeneral=new General(id, "o", precio);
        if(aviones.get(idAvion).getGeneral().containsKey(id)){
            System.out.println("La Silla ya está Registrada");
        }else{
            aviones.get(idAvion).getGeneral().put(id, sillaGeneral);
        }
    }
    
    //Metodo para agregar la Silla VIP al hashmap del avion.
    public void crearSillaVip(String id, String idAvion, Double precio){
        Vip sillaVip=new Vip(id, "O", precio);
        if(aviones.get(idAvion).getVip().containsKey(id)){
            System.out.println("La Silla ya está Registrada");
        }else{
            aviones.get(idAvion).getVip().put(id, sillaVip);
        }
    }
    
    //Metodo para realizar la venta del tiquete.
    public void venderTiquete(String id){
        PintarAvion pintar = new PintarAvion();
        try{
            String categoria="";
            personas = sistema.leerArchivoCliente();
            if(personas.containsKey(id)){
                do{
                    System.out.println("+ - - - - - - - - - - - - +");
                    System.out.println("|  Categoría del Avión.   |");
                    System.out.println("+ - - - - - - - - - - - - +");
                    System.out.println("|                         |");
                    System.out.println("|   1. VIP.               |");
                    System.out.println("|   2. General.           |");
                    System.out.println("|   3. Mixto.             |");
                    System.out.println("+ - - - - - - - - - - - - +");
                    categoria=entradaDatos.readLine();
                    Double costoVip=0.0, costoGeneral=0.0;
                    switch(categoria){
                        case"1":
                            costoVip=pintar.pintarVip();
                            System.out.println("Silla VIP tiene un costo de $"+costoVip+" Pesos");
                            compraCliente(id, costoVip, 0.0);
                            break;
                        case"2":
                            costoGeneral=pintar.pintarClasico();
                            System.out.println("Silla General tiene un costo de $"+costoGeneral+" Pesos");
                            compraCliente(id, 0.0, costoGeneral);
                            break;
                        case"3":
                            Double[] costo = pintar.pintarMixto();
                            costoVip=costo[0];
                            costoGeneral=costo[1];
                            System.out.println("Silla VIP tiene un costo de $"+costoVip+" Pesos");
                            System.out.println("Silla General tiene un costo de $"+costoGeneral+" Pesos");
                            compraCliente(id, costoVip, costoGeneral);
                            break;
                        default:
                            System.out.println("Digite una opcion correcta...");
                            break;
                    }
                }while(!(categoria.equals("1") || categoria.equals("2") || categoria.equals("3")));
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
                    Date testDate = null, fechaA = new Date();
                    System.out.println("Fecha de nacimiento:");
                    do{
                        System.out.println("Introduzca la fecha con formato dd/mm/yyyy");
                        String fecha = entradaDatos.readLine();
                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        String date = fecha;
                        try{
                            testDate = df.parse(date);
                            if (!df.format(testDate).equals(date) || (testDate.compareTo(fechaA) >= 0)){
                                System.out.println("Fecha no válida!!");
                                testDate=null;
                            } else {
                                crearCliente(id, nombre, apellido, testDate);
                                sistema.guardarArchivoCliente(personas);
                                venderTiquete(id);
                            }
                        } catch (ParseException e){ System.out.println("Fecha no válida!!");}
                    }while(testDate==null);
                }else if(eleccion.equals("n") || eleccion.equals("N")){
                    System.out.println("Volviendo al menu principal.");
                }else{
                    System.out.println("Opcion no valida, regresando al menú principal.");
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
            System.out.println("Avion: "+m.getKey()+" : "+m.getValue().getAerolinea());
            for (Vip s : aviones.get(m.getKey()).getVip().values()) {
                if(s.getEstado().equals("O")){
                    vip++;
                    estado="Vacío";
                }else if(s.getEstado().equals("X")){
                    ocupadoVip++;
                    estado = "Ocupado";
                }
            }
            vip+=ocupadoVip;
            System.out.println("\t"+ocupadoVip+" Sillas VIP ocupadas de "+vip);
            for (General s : aviones.get(m.getKey()).getGeneral().values()) {
                if(s.getEstado().equals("o")){
                    eco++;
                    estado="Vacío";
                }else if(s.getEstado().equals("x")){
                    ocupadoEco++;
                    estado = "Ocupado";
                }
            }
            eco+=ocupadoEco;
            System.out.println("\t"+ocupadoEco+" Sillas General ocupadas de "+eco);
        }
    }
    
    //Metodo donde se efectúa la venta.
    public void compraCliente(String idCliente, Double costoVip, Double costoGeneral) {
        try{
            boolean existe=false, ocupado=false;
            do{
                System.out.println("Digite el Id del Avión en el que desea Viajar");
                String idAvion=entradaDatos.readLine();
                Persona cliente;
                String nombre=personas.get(idCliente).getNombre();
                String apellido = personas.get(idCliente).getApellido();
                Date fechaN = personas.get(idCliente).getFechaNacimiento();
                if(aviones.containsKey(idAvion)){
                    existe=true;
                    String silla="";
                    do{
                        System.out.println("Digite la posicion de la silla que desea ocupar.");
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
                                System.out.println("Venta Tiquete VIP realizada.");
                            }else{
                                ocupado=false;
                                System.out.println("Silla ocupada! Por favor Seleccione otra.");
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
                                System.out.println("Venta Tiquete General realizada.");
                            }
                            else{
                                ocupado=false;
                                System.out.println("Silla ocupada! Por favor Seleccione otra.");
                            }
                        }else{
                            System.out.println("La ubicacion no es correcta o la digitó mal.");
                        }
                    }while(!(aviones.get(idAvion).getGeneral().containsKey(silla) || 
                            aviones.get(idAvion).getVip().containsKey(silla)) || ocupado == false);
                }else{
                    existe=false;
                    System.out.println("Id erroneo o no está registrado en el Sistema.");
                }
            }while(existe==false);
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public void despegarAvion(){
        try{
            boolean despego=false;
            verDatos();
            aviones = sistema.leerArchivo();
            do{
                System.out.println("Digite el codigo del avion que va a Despegar:");
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
                    System.out.println("Total Ingresos del avion es $"+aviones.get(idAvion).getIngreso()+" pesos");
                    aviones.remove(idAvion);
                    sistema.guardarArchivo(aviones);
                    despego=true;
                    System.out.println("Avión despegó.");
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
                    System.out.println("Total Ingresos del avion es $"+aviones.get(idAvion).getIngreso()+" pesos");
                    aviones.remove(idAvion);
                    sistema.guardarArchivo(aviones);
                    despego=true;
                    System.out.println("Avión despegó.");
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
                    System.out.println("Total Ingresos del avion es $"+aviones.get(idAvion).getIngreso()+" pesos");
                    aviones.remove(idAvion);
                    sistema.guardarArchivo(aviones);
                    despego=true;
                    System.out.println("Avión despegó.");
                }
                else{
                    despego=false;
                    System.out.println("El id del avión es erroneo o no está registrado en el Sistema.");
                }
            }while(despego==false);
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}