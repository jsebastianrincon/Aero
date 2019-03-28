package Aeropuerto;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Juan Sebastian
 */


/* Clase donde se va a realizar el diseño del avion*/
public class PintarAvion {
    HashMap<String, Avion> avion;
    Sistema sistema = new Sistema();
    String concatenadoA = "", concatenadoB = "", concatenadoC = "", concatenadoD = "", concatenadoE = "";
    public PintarAvion(){
        avion = new HashMap();
    }
 /* Clase donde se va a realizar el diseño del avion especificamnete la clase VIP*/   
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
    /* Clase donde se va a realizar el diseño del avion especificamnete la clase Clasica*/
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
    /* Clase donde se va a realizar el diseño del avion especificamnete la clase Mixta*/
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
    /* Clase donde se va a realizar el diseño del avion para mostrar al momento de mostrar y asignar los puestos*/
    public void mostrarAvion(String a,String b,String c,String d,String e){
        System.out.println("                                                llc\\n\" +\n" +
"\"                                               lcccl\\n\" +\n" +
"\"                                              lcccccc\\n\" +\n" +
"\"                                             ccdcccccc\\n\" +\n" +
"\"                                             lcccccccl\\n\" +\n" +
"\"                                            cccccccccl\\n\" +\n" +
"\"                                            ccccccccccc\\n\" +\n" +
"\"                                            lcccccccccc\\n\" +\n" +
"\"                                            lcc    cccl\\n\" +\n" +
"\"                                            ldl     ldl\\n\" +\n" +
"\"                                            lc      cdl\\n\" +\n" +
"\"                                            lc       cl\\n\" +\n" +
"\"                                            cc       cl\\n\" +\n" +
"\"                                           ccc       cl\\n\" +\n" +
"\"                                           ccdc     ldc\\n\" +\n" +
"\"                                           ccccc   lcccc\\n\" +\n" +
"\"                                           lccccccdccccl\\n\" +\n" +
"\"                                          cccccccccccccl\\n\" +\n" +
"\"                                          ccccccccccccccc\\n\" +\n" +
"\"                                          ccccccccccccccc\\n\" +\n" +
"\"                                          ccccccccccccccc\\n\" +\n" +
"\"                                          ccccccccccccccc\\n\" +\n" +
"\"                                          lcccccccccccccc\\n\" +\n" +
"\"                                          lcccccccccccccc\\n\" +\n" +
"\"                                         clccccccccccccclc\\n\" +\n" +
"\"                                        cllcccccccccccccllc\\n\" +\n" +
"\"                                      cllllccccccccccccclllcc\\n\" +\n" +
"\"                                    cllllllccccccccccccclllllcc\\n\" +\n" +
"\"                                  ccllll  |"+a+"|     llllcc\\n\" +\n" +
"\"                                ccllllcl  |"+b+"|     lclllllc\\n\" +\n" +
"\"                               cllllcccl_______|  |_______llcclllllc\\n\" +\n" +
"\"                             cllllccllll                  llllcclllllc\\n\" +\n" +
"\"                           ccllllcllllll |"+c+"|    llllllccllllcc\\n\" +\n" +
"\"                         ccllllcllllllll |"+d+"|    lllllllllcllllc\\n\" +\n" +
"\"                        cllllcllllllllll |"+e+"|    llllllllllllllllc\\n\" +\n" +
"\"                      clllllllllllllllll                  llllllllllllllllllc\\n\" +\n" +
"\"                    ccllllllllllllllllll                  lllllllllllllllllllcc\\n\" +\n" +
"\"                  ccllllllllllllllllllll                  lllllllllllllllllllllc\\n\" +\n" +
"\"                 clllllllllllllllllllllccdddcccccccccccddccclllllllllllllllllllllc\\n\" +\n" +
"\"               clllllllllllllllllllcccdddddccccccccccccddddddcccllllllllllllllllllcc\\n\" +\n" +
"\"             cclllllllllllllllllccddddddddddcccccccccccddddddddddcclllllllllllllllllcc\\n\" +\n" +
"\"            clllllllllllllllccddddddddddddddcccccccccccddddddddddddddcclllllllllllllllc\\n\" +\n" +
"\"          clllllllllllllcccddddddddddddddddcccccccccccccddddddddddddddddccclllllllllllllc\\n\" +\n" +
"\"        cclllllllllllccdddddddddddddddccllclccccccccccclcllccdddddddddddddddcclllllllllllc\\n\" +\n" +
"\"       clllllllllccdddddddddddddddcclcc    ccccccccccccc    cclccdddddddddddddddcclllllllllc\\n\" +\n" +
"\"      cllllllcccdddddddddddddccllc         ccccccccccccc         cllccdddddddddddddcclllllllc\\n\" +\n" +
"\"      clllccdddddddddddddcllcc             cccccccccccc              ccllcddddddddddddccclllc\\n\" +\n" +
"\"      lccdddddddddddcclcc                  cccccccccccl                   cllccdddddddddddccl\\n\" +\n" +
"\"     ccdddddddddcllc                        ccccccccccl                       ccllcdddddddddc\\n\" +\n" +
"\"      cddddcclcc                            lcccccccccl                            cclccddddl\\n\" +\n" +
"\"      lcllc                                 lcccllccccl                                 cllcl\\n\" +\n" +
"\"                                            lccclllcccl\\n\" +\n" +
"\"                                            lccclllcccc\\n\" +\n" +
"\"                                          cclccllllccclcc\\n\" +\n" +
"\"                                        clllllcllllcclllllc\\n\" +\n" +
"\"                                     cclllllllcllllcclllllllc\\n\" +\n" +
"\"                                   cclllllllllcllllcclllllllllcc\\n\" +\n" +
"\"                                 cclllllllcccdcllllcccccclllllllcc\\n\" +\n" +
"\"                               ccllllcccddddddcllllccddddddcccllllcc\\n\" +\n" +
"\"                             cllcccdddcccllllccllllcccllllccddddcccllc\\n\" +\n" +
"\"                           cccccclllcc       lcllllccl      ccclllcccccc\\n\" +\n" +
"\"                           ccc               ccllllccc              ccc\\n\" +\n" +
"\"                                               clllc\\n\" +\n" +
"\"                                               ldccc\\n\" +\n" +
"\"                                               cdccc\\n\" +\n" +
"\"                                               cdclc\\n\" +\n" +
"\"                                                llc\n\n\n\n");
    }
    
}
