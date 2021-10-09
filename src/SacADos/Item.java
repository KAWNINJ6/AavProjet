package SacADos;

public class Item implements Comparable<Item>{
    private String nom;
    private int poids;
    private int prix;

    public Item(String nom, int poids, int prix) {
        this.nom = nom;
        this.poids = poids;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public int getPoids() {
        return poids;
    }

    public int getPrix() {
        return prix;
    }

    @Override
    public int compareTo(Item it){
        return Float.compare(((float) getPrix()/(float)getPoids()),((float)it.getPrix()/(float)it.getPoids()));
    }

    public String toString() {
        return nom + " ; " + poids+ " ; " +prix+"\n\r";
    }
}
