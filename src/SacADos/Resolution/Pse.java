package SacADos.Resolution;

import Arbre.BTreeCS;
import SacADos.Item;
import SacADos.SacADos;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Resolution PSE, resolution par abre binaire de recherche de complexite log(n)
 * elle est une sous classe de la methode glouton car elle sera initialisee par celle ci
 */
public class Pse extends Glouton{

    private int borneInf, poidsMax;
    // le noeud contenant la meilleure solution trouvee
    BTreeCS meilleurnoeud;

    public Pse(SacADos sac, ArrayList<Item> items) {
        super(sac,items);
    }

    public void resoudre() {
        //initialise le sac avec la methode gloutonne
        super.resoudre();
        int borneSup = 0;
        borneInf = 0;
        // la charge maximale du sac
        poidsMax =  sac.getPoidsMax();
        //on initialise la borne inferieure avec le total des prix des objets dans le sac obtenu avec la methode gloutonne
        borneInf=sac.getPrix();
        //on initialise la borne supérieure avec le total des prix de tous les objets
        for (Item item: items) {
            borneSup+=item.getPrix();
        }
        //initialisation de l'arbre binaire de recherche ainsi que du meilleur noeud
        BTreeCS racine = new BTreeCS();
        meilleurnoeud=racine;


        creerArbre(0,racine,borneSup);
        // affichage de l'arbre
//        PrintStream os = new PrintStream(System.out);
//        racine.print(os);

        //vide le sac a cause de la methode gloutonne
        sac.vider();
        ajoutRes(meilleurnoeud);
    }

    /**
     * ajoute recursivement les items a partir du meilleur noeud
     * @param meilleurnoeud le noeud de la meilleur branche
     */
    public void ajoutRes( BTreeCS meilleurnoeud){
        //ajoute l'item de l'indice de la valeur du noeud dans le sac
        if (meilleurnoeud.getRootValue()!=null)
            sac.addItem(items.get(meilleurnoeud.getRootValue()));
        //tant que le noeud n'est pas la racine de l'arbre on remonte l'arbre
        if(meilleurnoeud.getPere()!=null)
            ajoutRes(meilleurnoeud.getPere());
    }

    /**
     * a partir d'un noeud ajoute recursivement la valeur et le poids total de la branche d'un ABR
     * @param noeud le noeud
     * @param tab   [0] le poids total, [1] le prix total
     */
    public void getPoidsPrix(BTreeCS noeud , int[] tab){
        if(noeud.getRootValue()!=null){
            tab[0] += items.get(noeud.getRootValue()).getPoids();
            tab[1] += items.get(noeud.getRootValue()).getPrix();
        }
        if (noeud.getPere()!=null)
            getPoidsPrix(noeud.getPere(),tab);
    }

    /**
     * cree l'ABR
     * @param index indice de la profondeur de l'arbre qui est la position de l'item dans la liste Items
     * @param noeud le noeud actuel
     * @param borneSup la borne superieure
     */
    private void creerArbre(int index, BTreeCS noeud, int borneSup) {
        //cree les 2 fils d'un noeud : cote droit on ajoute l'objet, cote gauche on le retire
        noeud.setRightTree(new BTreeCS(index,noeud));
        noeud.setLeftTree(new BTreeCS(noeud));

        int[] PoidsPrix = {0,0};
        getPoidsPrix((BTreeCS) noeud.getRightTree(), PoidsPrix);
        //si la solution du noeud droit est meilleur que le meilleur resultat actuel
        if (PoidsPrix[1] >= borneInf && PoidsPrix[0] <= poidsMax) {
            //nouveau meilleur noeud
            meilleurnoeud = (BTreeCS) noeud.getRightTree();
            //actualisation de la borne inferieure
            borneInf = PoidsPrix[1];
        }


        int[] current = {0,0};
        getPoidsPrix(noeud,current);
        if (index < items.size()-1 && current[0] <= poidsMax) {
            int borneMax = borneSup - items.get(index).getPrix();
            //si la borne superieure est inferieure a la borne inferieure alors on coupe l'arbre
            if (borneSup>=borneInf) {
                creerArbre(index + 1, (BTreeCS) noeud.getRightTree(), borneSup);
                creerArbre(index + 1, (BTreeCS) noeud.getLeftTree(), borneMax);
            }
        }

    }

}
