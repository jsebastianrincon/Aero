package Aeropuerto;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Yonathan
 */
public class PintarAvion {
    public PintarAvion(){
        
    }
    
    public void pintar(HashMap<String, Silla> sillas){
        ArrayList listaVip = new ArrayList();
        ArrayList listaEco = new ArrayList();
        int vip=0, eco=0;
        for (Silla s : sillas.values()) {
            String[] codigoS=s.getId().split("-");
            if(s.getDisponible()==true && codigoS[0].equals("VIP")){
                listaVip.add("O");
                vip++;
            }else if(s.getDisponible()==true && codigoS[0].equals("ECO")){
                listaEco.add("o");
                eco++;
            }else if(s.getDisponible()==false && codigoS[0].equals("VIP")){
                listaVip.add("X");
            }else if(s.getDisponible()==false && codigoS[0].equals("ECO")){
                listaEco.add("x");
            }
        }
        System.out.println("\tSillas disponibles en VIP: "+vip);
        System.out.println("\tSillas disponibles en Clasico: "+eco);
        //pintar.pintar(listaVIP, listaECO);
    }
    
    public void matriz(){
        String numeros[][] = new String[5][18];
        for (int h = 0; h < 2; h++) {
            for (int j = 0; j < 5; j++) {
                numeros[h][j] = "+";
            }
            for (int j = 5; j < 8; j++) {
                numeros[h][j] = "O";
            }
            for (int j = 8; j < 10; j++) {
                numeros[h][j] = " ";
            }
            for (int j = 10; j < 13; j++) {
                numeros[h][j] = "O";
            }
            for (int j = 13; j < 18; j++) {
                numeros[h][j] = "|";
            }
        }
        for (int h = 2; h < 5; h++){
            for (int j = 0; j < 8; j++) {
                numeros[h][j] = "o";
            }
            for (int j = 8; j < 10; j++) {
                numeros[h][j] = " ";
            }
            for (int j = 10; j < 18; j++) {
                numeros[h][j] = "o";
            }
        }
        for (String[] num : numeros) {
            for (String elem : num) {
                System.out.print(elem);
            }
            System.out.print("\n"); // Salto de Línea
        }
        System.out.println("                                           1111111\n" +
                "                                12345678  90123456\n" +
                "                                ||||||||  ||||||||\n" +
                "                                |||||||NXXN|||||||\n" +
                "                                ||||||Ko  dK||||||\n" +
                "                                |||||K||  |oK|||||\n" +
                "                                ||||Nd||  ||dN||||\n" +
                "                                ||||0|||  |||0||||\n" +
                "                                ||||k|||  |||k||||\n" +
                "                                |||Nd|||  |||xN|||\n" +
                "                                |||Xo|||  |||dX|||\n" +
                "                                |||Ko|||  |||oK|||\n" +
                "                                |||Ko|||  |||oK|||\n" +
                "                                |||Ko|||  |||oK|||\n" +
                "                                |||K||||  |||oK|||\n" +
                "                                |||K||||  ||||K|||\n" +
                "                                ||Kx||||  ||||xK||\n" +
                "                               NOd||||||  ||||||d0N\n" +
                "                         XOOOOko                  okOOO0X\n" +
                "                         k                              k\n" +
                "                        Xd                              dK\n" +
                "                         k                              k\n" +
                "                        Xd                              dK\n" +
                "                         k                              k\n" +
                "                        Xd                              dK\n" +
                "                 Xxlooxd                                  ddoolxX\n" +
                "                 K                                              K\n" +
                "                NO                                              ON\n" +
                "              Xk                                                 okX\n" +
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
                "                                NKxo          ox0N\n" +
                "                               Xx       oo       dX\n" +
                "                               KdoxkOKX0kk0XKOkxodK\n" +
                "                                ||     ||||     ||");
    }
    
}
