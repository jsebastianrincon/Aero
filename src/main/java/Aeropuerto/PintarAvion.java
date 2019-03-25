package Aeropuerto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yonathan Bohorquez
 * @author Manuel Bohorquez
 */
public class PintarAvion {
    HashMap<String, Avion> avion;
    Sistema sistema = new Sistema();
    String concatenadoA = "", concatenadoB = "", concatenadoC = "", concatenadoD = "", concatenadoE = "";
    public PintarAvion(){
        avion = new HashMap();
    }
    
    public Double pintarVip(){
        avion = sistema.leerArchivo();
        Double costoVip=0.0;
        for (Map.Entry<String,Avion> av :avion.entrySet()) {
            if(avion.get(av.getKey()).getCategoria().equals("VIP")){
                for (Vip vi : avion.get(av.getKey()).getVip().values()) {
                    if(vi.getUbicacion().contains("A")){
                        concatenadoA = concatenadoA + vi.getEstado();
                    }
                    if(vi.getUbicacion().contains("B")){
                        concatenadoB = concatenadoB + vi.getEstado();
                    }
                    costoVip=vi.getPrecio();
                }
                System.out.println("Id del avion: "+avion.get(av.getKey()).getId());
                mostrarAvion("A->"+concatenadoA, "B->"+concatenadoB, "           ", "           ", "           ");
                concatenadoA="";concatenadoB="";
            }
        }
        return costoVip;
    }
    
    public Double pintarClasico(){
        avion = sistema.leerArchivo();
        Double costoGeneral=0.0;
        for (Map.Entry<String,Avion> av :avion.entrySet()) {
            if(avion.get(av.getKey()).getCategoria().equals("Genereal")){
                for (General general : avion.get(av.getKey()).getGeneral().values()) {
                    if(general.getUbicacion().contains("C")){
                        concatenadoC = concatenadoC + general.getEstado();
                    }
                    if(general.getUbicacion().contains("D")){
                        concatenadoD = concatenadoD + general.getEstado();
                    }
                    if(general.getUbicacion().contains("E")){
                        concatenadoE = concatenadoE + general.getEstado();
                    }
                    costoGeneral=general.getPrecio();
                }
                System.out.println("Id del avion: "+avion.get(av.getKey()).getId());
                mostrarAvion("         ", "         ", "C->"+concatenadoC, "D->"+concatenadoD, "E->"+concatenadoE);
                concatenadoC="";concatenadoD="";concatenadoE="";
            }
        }
        return costoGeneral;
    }
    
    public Double[] pintarMixto(){
        avion = sistema.leerArchivo();
        Double costoVip=0.0, costoGeneral=0.0;
        for (Map.Entry<String,Avion> av :avion.entrySet()) {
            if(avion.get(av.getKey()).getCategoria().equals("Mixto")){
                for (Vip vi : avion.get(av.getKey()).getVip().values()) {
                    if(vi.getUbicacion().contains("A")){
                        concatenadoA = concatenadoA + vi.getEstado();
                    }
                    if(vi.getUbicacion().contains("B")){
                        concatenadoB = concatenadoB + vi.getEstado();
                    }
                    costoVip=vi.getPrecio();
                }
                for (General general : avion.get(av.getKey()).getGeneral().values()) {
                    if(general.getUbicacion().contains("C")){
                        concatenadoC = concatenadoC + general.getEstado();
                    }
                    if(general.getUbicacion().contains("D")){
                        concatenadoD = concatenadoD + general.getEstado();
                    }
                    if(general.getUbicacion().contains("E")){
                        concatenadoE = concatenadoE + general.getEstado();
                    }
                    costoGeneral=general.getPrecio();
                }
                System.out.println("Id del avion: "+avion.get(av.getKey()).getId());
                mostrarAvion("A->"+concatenadoA, "B->"+concatenadoB, "C->"+concatenadoC, "D->"+concatenadoD, "E->"+concatenadoE);
                concatenadoA="";concatenadoB="";concatenadoC="";concatenadoD="";concatenadoE="";
            }
        }
        Double[] costo={costoVip, costoGeneral};
        return costo;
    }
    
    public void mostrarAvion(String a,String b,String c,String d,String e){
        System.out.println("                                       NXXN\n" +
                "                                      Ko  dK\n" +
                "                                     K     oK\n" +
                "                                    Nd      dN\n" +
                "                                    0        0\n" +
                "                                    k        k\n" +
                "                                   Nd        xN\n" +
                "                                   Xo        dX\n" +
                "                                   Ko        oK\n" +
                "                                   Ko        oK\n" +
                "                                   Ko        oK\n" +
                "                                   K         oK\n" +
                "                                   K         K\n" +
                "                                  Kx         xK\n" +
                "                               NOd              d0N\n" +
                "                         XOOOOko                  okOOO0X\n" +
                "                         k          \033[31m 123456             k\n" +
                "                        Xd        "+a+"             dK\n" +
                "                         k        "+b+"             k\n" +
                "                        Xd                              dK\n" +
                "                         k------------|  |-------------k\n" +
                "                        Xd                              dK\n" +
                "                 Xxlooxd           \033[31m 12345678             ddoolxX\n" +
                "                 K               "+c+"                   K\n" +
                "                NO               "+d+"                   ON\n" +
                "              Xk                 "+e+"                    okX\n" +
                "           N0x                    xd          dxo                   x0N\n" +
                "         XOo                 oO0k0 0          0 0kOOd                 oOX\n" +
                "      N0x              o d0KOK     0          0     KOK0d o              d0N\n" +
                "    Xko           oddxXNXX         0          0         XKNKxodo           okX\n" +
                "   Xo         dkxON NN             K         oK             NN NOxkd         oK\n" +
                "  Nx    odk0O0                     Xd        dX                     KO0kdo    dN\n" +
                "  Xddk0KN                          Nx        xN                          NK0kdxX\n" +
                "   N                                O        O                                N\n" +
                "                                    0        0\n" +
                "                                    Xo      oX\n" +
                "                                    Nx      xN\n" +
                "                                     O      O\n" +
                "                                     Ko    oK\n" +
                "                                     Xd    dX\n" +
                "                                   X0x      dOX\n" +
                "                                NKxo    00    ox0N\n" +
                "                               Xx      0000      dX\n" +
                "                               KdoxkOKX0kk0XKOkxodK\n" +
                "                                ||     ||||     ||\n\n\n\n");
    }
    
}
