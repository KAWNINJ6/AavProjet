package SacADos;

/**
 * Represente un objet qui peut être mis dans le sac
 */
public class Item implements Comparable<Item>{
    //le nom de l'objet
    private String nom;
    //son poids
    private int poids;
    //son prix
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

    /**
     * compare 2 items par rapport au prix/poids
     * @param it le 2e item
     * @return 0 si =, >0 si it < this, <0 si it > this
     */
    @Override
    public int compareTo(Item it){
        return Float.compare(((float) getPrix()/(float)getPoids()),((float)it.getPrix()/(float)it.getPoids()));
    }

    public String toString() {
        return nom + " ; " + poids+ " ; " +prix+"\n\r";
    }
}
