package Utils;

import SacADos.SacADos;

import java.io.FileNotFoundException;

public class AppManager {
    public AppManager() {
    }

    public void checkInput(String[] args) {
        if(args.length != 3)
            throw new IllegalArgumentException("nombre d'argument(s) illégal");
        try{
            Integer.parseInt(args[1]);
        }catch (NumberFormatException ne){
            throw new IllegalArgumentException("le poids doit etre un nombre");
        }
    }

    public void start(String[] args){
        SacADos sac = new SacADos(Integer.parseInt(args[1]));
        try {
            sac.resoudre(args[2],args[0]);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("le fichier spécifié est introuvable");
        }
        System.out.println(sac);
        System.out.println("le poids du sac : " + sac.getPoids());
        System.out.println("la valeur du sac : " + sac.getPrix());
    }
}
