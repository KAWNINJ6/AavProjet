public class Item implements Comparable<Item>{
    private String nom;
    private float poids;
    private float prix;

    public Item(String nom, float poids, float prix) {
        this.nom = nom;
        this.poids = poids;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public float getPoids() {
        return poids;
    }

    public float getPrix() {
        return prix;
    }

    @Override
    public int compareTo(Item it){
        return Float.compare((getPrix()/getPoids()),(it.getPrix()/it.getPoids()));
    }

    public String toString() {
        return nom + " ; " + poids+ " ; " +prix+"\n\r";
    }
}
