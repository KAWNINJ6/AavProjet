package Utils;

import SacADos.SacADos;
import SacADos.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe gerant les erreurs lors de l'apel du script
 * l'appel du Script doit se faire comme suivant : nomduscript cheminFichierObjets PoidsMaxSac Methode
 * cheminFichierObjets : le chemin absolu ou relatif du fichier
 * PoidsMaxSac : la charge maximal que le sac pourra contenir
 * Methode specifie la methode de resolution du probleme, ne peut avoir que 3 valeurs : GLOUTONNE, DYNAMIQUE et PSE
 */
public class AppManager {
    public AppManager() {
    }

    /**
     * verifie qu'il y a le bon nombre de parametres
     * @param args  le tableau des parametre donnes lors de l'appel du script
     */
    public void checkInput(String[] args) {
        if(args.length != 3)
            throw new IllegalArgumentException("nombre d'argument(s) illégal");
        //verifie que le poids du sac est bien un nombre
        try{
            Integer.parseInt(args[1]);
        }catch (NumberFormatException ne){
            throw new IllegalArgumentException("le poids doit etre un nombre");
        }
    }

    /**
     * lance la résolution du sac
     * @param args les parametres de resolution
     */
    public void start(String[] args){
        SacADos sac = new SacADos(Integer.parseInt(args[1]));
        //essaye de resoudre le sac
        try {
            long start = System.currentTimeMillis();
            sac.resoudre(args[2],args[0]);
            long finish = System.currentTimeMillis();
            System.out.println("temps: "+(finish-start));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("le fichier spécifié est introuvable");
        }
        //affiche le resultat obtenu
        System.out.println(sac);
        System.out.println("le poids du sac : " + sac.getPoids());
        System.out.println("la valeur du sac : " + sac.getPrix());
    }

    /**
     * cree une liste contenant tous les objets presents dans le fichier
     * @param path le chemin
     * @return la liste des objets
     * @throws FileNotFoundException si le fichier est introuvable
     */
    public static ArrayList<Item> rdFile(String path) throws FileNotFoundException {
        ArrayList<Item> obj = new ArrayList<>();
        Scanner scan = new Scanner(new File(path));
        //ajoute les objets
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] data = line.split(";");
            //si le fichier est mal formatee alors le programme se stoppe
            try{
                obj.add(new Item(data[0],Integer.parseInt(data[1].trim()), Integer.parseInt(data[2].trim())));
            }catch (ArrayIndexOutOfBoundsException e){
                throw new IllegalArgumentException("la ligne " + line + " n'est pas bien formatée");
            }
        }
        return obj;
    }
}
