package Arbre;

/**
 * {@inheritDoc}
 * Cet arbre binaire possede aussi le pere en attribut ce qui permet de remonter a la racine de l'arbre à partir d'un noeud
 */
public class BTreeCS extends BTreeCA{
    private BTreeCS pere;

    public BTreeCS(){
        super();
    }

    public BTreeCS(BTreeCS pere){
        super();
        this.pere = pere;
    }

    public BTreeCS(int value, BTreeCS pere){
        super(value);
        this.pere = pere;
    }

    /**
     * return le pere du noeud
     * @return le pere
     */
    public BTreeCS getPere(){
        return this.pere;
    }

}
