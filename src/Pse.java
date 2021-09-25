import java.util.ArrayList;

public class Pse {
    public void resoudre(SacADos sac, ArrayList<Item> items) {
        float borneInf = 0, borneSup = 0;
        Glouton.resoudre(sac, items);
        for (Item item : items) {
            borneInf +=item.getPrix();
        }

        BTreeCS racine = new BTreeCS();
        BTreeCS meilleurnoeud=racine;
        creerArbre(0,racine,borneSup,borneInf);

    }

    private void creerArbre(int i, BTreeCS noeud, float borneSup, float borneInf) throws Exception {
        noeud.setRightTree(new BTreeCS(i));
        noeud.setLeftTree(new BTreeCS());
        if(noeud.getPoids())
    }
}
