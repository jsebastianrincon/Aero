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
            if(avion.get(av.getKey()).isEstado()==true){
                System.out.println("El avión "+av.getKey()+" está en vuelo.");
            }else{
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
                    mostrarAvion("A->"+concatenadoA, "B->"+concatenadoB, "           ", "           ", "           ");
                    System.out.println("Id del avion: "+avion.get(av.getKey()).getId());
                    concatenadoA="";concatenadoB="";
                }
            }
        }
        return costoVip;
    }
    /* Clase donde se va a realizar el diseño del avion especificamnete la clase Clasica*/
    public Double pintarClasico(){
        avion = sistema.leerArchivo();
        Double costoGeneral=0.0;
        for (Map.Entry<String,Avion> av :avion.entrySet()) {
            if(avion.get(av.getKey()).isEstado()==true){
                System.out.println("El avión "+av.getKey()+" está en vuelo.");
            }else{
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
                    mostrarAvion("         ", "         ", "C->"+concatenadoC, "D->"+concatenadoD, "E->"+concatenadoE);
                    concatenadoC="";concatenadoD="";concatenadoE="";
                    System.out.println("Id del avion: "+avion.get(av.getKey()).getId());
                }
            }
        }
        return costoGeneral;
    }
    /* Clase donde se va a realizar el diseño del avion especificamnete la clase Mixta*/
    public Double[] pintarMixto(){
        avion = sistema.leerArchivo();
        Double costoVip=0.0, costoGeneral=0.0;
        for (Map.Entry<String,Avion> av :avion.entrySet()) {
            if(avion.get(av.getKey()).isEstado()==true){
                System.out.println("El avión "+av.getKey()+" está en vuelo.");
            }else{
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
                    mostrarAvion("A->"+concatenadoA, "B->"+concatenadoB, "C->"+concatenadoC, "D->"+concatenadoD, "E->"+concatenadoE);
                    concatenadoA="";concatenadoB="";concatenadoC="";concatenadoD="";concatenadoE="";
                    System.out.println("Id del avion: "+avion.get(av.getKey()).getId());
                }
            }
            
        }
        Double[] costo={costoVip, costoGeneral};
        return costo;
    }
    /* Clase donde se va a realizar el diseño del avion para mostrar al momento de mostrar y asignar los puestos*/
    public void mostrarAvion(String a,String b,String c,String d,String e){
        System.out.println("\n\n\n\n                                                llc\n" +
"                                               lcccln\n" +
"                                              lccccccln\n" +
"                                             ccdcccccclln\n" +
"                                             lcccccccccln\n" +
"                                            ccccccccclccc\n" +
"                                            cccccccccccccc\n" +
"                                            lccccccccccccl\n" +
"                                            lcccc     ccccl\n" +
"                                            ldlcc     ccldl\n" +
"                                            lccc       cccl\n" +
"                                            lccc       cccl\n" +
"                                            cccc       cccl\n" +
"                                           ccccc       ccccc\n" +
"                                           ccdccc     cccdcc\n" +
"                                           ccccccc   lcccccc\n" +
"                                           lccccccdccccccccl\n" +
"                                          ccccccccccccccccccl\n" +
"                                          ccccccccccccccccccc\n" +
"                                          ccccccccccccccccccc\n" +
"                                          ccccccccccccccccccc\n" +
"                                          ccccccccccccccccccc\n" +
"                                          lcccccccccccccccccl\n" +
"                                          lcccccccccccccccccl\n" +
"                                         clccccccccccccccccclc\n" +
"                                        cllcccccccccccccccccllc\n" +
"                                      cllllcccccccccccccccccllllc\n" +
"                                    cllllllcccccccccccccccccllllllc\n" +
"                                  ccllll     |"+a+"|      llllcc\n" +
"                                ccllllcl     |"+b+"|      lcllllcc\n" +
"                               cllllcccl________|  |________llcclllllc\n" +
"                             cllllccllll                    llllccllllc\n" +
"                           ccllllcllllll  |"+c+"|     llllllcllllcc\n" +
"                         ccllllcllllllll  |"+d+"|     llllllllcllllc\n" +
"                        cllllcllllllllll  |"+e+"|     lllllllllllllllc\n" +
"                      clllllllllllllllll                    lllllllllllllllllc\n" +
"                    ccllllllllllllllllll                    lllllllllllllllll1cc\n" +
"                  ccllllllllllllllllllll                    llllllllllllllllllllcc\n" +
"                 clllllllllllllllllllllccdddcccccccccccddcccllllllllllllllllllll1lc\n" +
"               clllllllllllllllllllcccdddddccccccccccccddddddcccllllllllllllllllll11c\n" +
"             cclllllllllllllllllccddddddddddcccccccccccddddddddddcclllllllllllllllll1cc\n" +
"            clllllllllllllllccddddddddddddddcccccccccccddddddddddddddccllllllllllllll1lc\n" +
"          clllllllllllllcccddddddddddddddddcccccccccccccddddddddddddddddccclllllllllllll1c\n" +
"        cclllllllllllccdddddddddddddddccllclccccccccccclcllccdddddddddddddddcclllllllllll1cc\n" +
"       clllllllllccdddddddddddddddcclcc    ccccccccccccc    cclccdddddddddddddddcclllllllll1c\n" +
"      cllllllcccdddddddddddddccllc         ccccccccccccc         cllccdddddddddddddcclllllll1c\n" +
"      clllccdddddddddddddcllcc             cccccccccccc              ccllcddddddddddddccclll1c\n" +
"      lccdddddddddddcclcc                  cccccccccccl                   cllccddddddddddddccl\n" +
"     ccdddddddddcllc                        ccccccccccl                       ccllcddddddddddcc\n" +
"      cddddcclcc                            lcccccccccl                            cclccddddcl\n" +
"      lcllc                                 lcccllccccl                                  cllcl\n" +
"                                            lccclllcccl\n" +
"                                            lccclllcccc\n" +
"                                          cclccllllccclcc\n" +
"                                        clllllcllllcclllllc\n" +
"                                     cclllllllcllllcclllllllc\n" +
"                                   cclllllllllcllllcclllllllllcc\n" +
"                                 cclllllllcccdcllllcccccclllllllcc\n" +
"                               ccllllcccddddddcllllccddddddcccllllcc\n" +
"                             cllcccdddcccllllccllllcccllllccddddcccllc\n" +
"                           cccccclllcc       lcllllccl      ccclllcccccc\n" +
"                           ccc               ccllllccc              ccc\n" +
"                                               clllc\n" +
"                                               ldccc\n" +
"                                               cdccc\n" +
"                                               cdclc\n" +
"                                                llc");
    }
    
}
