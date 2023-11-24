/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Cl.SaveData.Consola.Conf;

import java.util.List;

/**
 *
 * @author march
 */
public interface Confi {
    //All Rutas (Revisar)
    List<String> AllRutas =List.of(
            "/PS3/EXPORT/PS2SD", "/PS3/EXPORT/PSV", "/PS3/SAVEDATA",
            "/PSP/SAVEDATA",
            "/PS4/APOLLO","/PS4/SAVEDATA",
            "/data/savegames", "/user/00", "/pspemu/PSP/SAVEDATA");
    List<String> AllPS3 =List.of("/PS3/EXPORT/PS2SD", "/PS3/EXPORT/PSV", "/PS3/SAVEDATA","/PSP/SAVEDATA");
    List<String> AllPSP = List.of("/PSP/SAVEDATA");
    List<String> AllPS4 = List.of("/PS4/APOLLO","/PS4/SAVEDATA");
    List<String> AllPSVita = List.of("/data/savegames","/user/00","/pspemu/PSP/SAVEDATA");
    //Rutas SAVEDATA PS3
    static String PS3PS2 = "/PS3/EXPORT/PS2SD";
    static String PS3PS1 = "/PS3/EXPORT/PSV";
    static String PS3PS3 = "/PS3/SAVEDATA";
    static String PS3PSP = "/PSP/SAVEDATA";  //Lo Mismo Para la PSP
    //Rutas SAVEDATA PS4
    static String PS4Apolo = "/PS4/APOLLO";
    static String PS4PS4 = "/PS4/SAVEDATA";
    //Ruta SAVEDATA PSVITA
    static String PSVApolo = "/data/savegames";
    static String PSVita = "/user/00";
    static String PSPAdrenaline = "/pspemu/PSP/SAVEDATA";
    
    
}
