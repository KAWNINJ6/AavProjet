package SacADos;

import SacADos.Resolution.Dynamique;
import SacADos.Resolution.Glouton;
import SacADos.Resolution.Pse;
import SacADos.Resolution.Resolution;
import Utils.AppManager;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * SacADos est un sac qui a un poids maximal et qui peut accueillir des objets
 */
public class SacADos {
    // liste d'objets present dans le sac
    private ArrayList<Item> objets;
    // le poids maximal du sac
    private int poidsMax;

    /**
     * initialise un sac
     * @param poidsMax le poids maximal que peut supporter le sac
     */
    public SacADos(int poidsMax) {
        objets = new ArrayList<>();
        this.poidsMax = poidsMax;
    }

    /**
     * getter de la charge maximal du sac
     * @return le poids
     */
    public int getPoidsMax() {
        return poidsMax;
    }

    /**
     * getter de la liste d'objets contenu dans le sac
     * @return les objets
     */
    public ArrayList<Item> getObjets() {
        return objets;
    }

    /**
     * ajoute un item dans le sac
     * @param it    item a ajouter
     */
    public void addItem(Item it){
        objets.add(it);
    }

    /**
     * calcule le poids total des objets contenus dans le sac
     * @return le poids des objets
     */
    public int getPoids(){
        int x = 0;
        for (Item item:objets) {
            x+= item.getPoids();
        }
        return x;
    }

    /**
     * calcule le prix total des objets contenus dans le sac
     * @return le prix des objets
     */
    public int getPrix(){
        int x = 0;
        for (Item item:objets) {
            x+= item.getPrix();
        }
        return x;
    }

    /**
     * initialise une methode de resolution selon la methode donnee puis resoud le probleme
     * @param Methode la methode voulue
     * @param dataPath  l'emplacement du fichier contenant la liste des objets a mettre dans le sac
     * @throws FileNotFoundException    si le fichier au chemin specifie n'existe pas
     */
    public void resoudre(String Methode, String dataPath) throws FileNotFoundException {
        Resolution resolution;
        ArrayList<Item> Items = new ArrayList<>(AppManager.rdFile(dataPath));
        switch(Methode) {
            case "GLOUTONNE":
                resolution = new Glouton(this, Items);
                break;
            case "DYNAMIQUE":
                resolution = new Dynamique(this, Items);
                break;
            case "PSE":
                resolution = new Pse(this, Items);
                break;
            default:
                throw new IllegalStateException("La méthode: " + Methode + " n'existe pas");
        }
        resolution.resoudre();
    }

    /**
     * le toString d'un sac
     * @return la liste de touts les objets contenus dans le sac
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Charge Max : ").append(poidsMax).append("\n").append(System.getProperty("line.separator"));
        objets.forEach((item)->sb.append(item.toString()));
        return sb.toString();
    }

    /**
     * vide le sac de ses objets
     */
    public void vider() {
        objets.clear();
    }
}
