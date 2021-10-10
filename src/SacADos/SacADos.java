package SacADos;

import SacADos.Resolution.Dynamique;
import SacADos.Resolution.Glouton;
import SacADos.Resolution.Pse;
import SacADos.Resolution.Resolution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SacADos {

    private ArrayList<Item> objets;
    private int poidsMax;

    public int getPoidsMax() {
        return poidsMax;
    }

    public ArrayList<Item> getObjets() {
        return objets;
    }

    public SacADos(String path, int poidsMax) throws FileNotFoundException {
        objets = rdFile(path);
        this.poidsMax = poidsMax;
    }

    public SacADos(int poidsMax) {
        objets = new ArrayList<>();
        this.poidsMax = poidsMax;
    }

    public static ArrayList<Item> rdFile(String path) throws FileNotFoundException {
        ArrayList<Item> obj = new ArrayList<>();
        Scanner scan = new Scanner(new File(path));
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] data = line.split(";");
            try{
                obj.add(new Item(data[0],Integer.parseInt(data[1].trim()), Integer.parseInt(data[2].trim())));
            }catch (ArrayIndexOutOfBoundsException e){
                throw new IllegalArgumentException("la ligne " + line + " n'est pas bien formatée");
            }
        }
        return obj;
    }

    public void addItem(Item it){
        objets.add(it);
    }

    public int getPoids(){
        int x = 0;
        for (Item item:objets) {
            x+= item.getPoids();
        }
        return x;
    }

    public int getPrix(){
        int x = 0;
        for (Item item:objets) {
            x+= item.getPrix();
        }
        return x;
    }

    public void resoudre(String Methode, String dataPath) throws FileNotFoundException {
        Resolution resolution;
        ArrayList<Item> Items = new ArrayList<>(SacADos.rdFile(dataPath));
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

    public String toString(){
        StringBuilder sb = new StringBuilder();
        objets.forEach((item)->sb.append(item.toString()));
        return sb.toString();
    }

    public void vider() {
        objets.clear();
    }
}
