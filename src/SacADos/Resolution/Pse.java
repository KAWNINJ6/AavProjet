package SacADos.Resolution;

import Arbre.BTreeCS;

import SacADos.Item;
import SacADos.SacADos;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Pse extends Glouton{

    private int borneInf, poidsMax;
    BTreeCS meilleurnoeud;

    public Pse(SacADos sac, ArrayList<Item> items) {
        super(sac,items);
    }

    public void resoudre() {
        super.resoudre();
        int borneSup = 0;
        borneInf = 0;
        poidsMax =  sac.getPoidsMax();

        for (Item item: sac.getObjets()) {
            borneInf += item.getPrix();
        }
        for (Item item: items) {
            if (item != null)
                borneSup+=item.getPrix();
        }

        BTreeCS racine = new BTreeCS();
        meilleurnoeud=racine;
        creerArbre(0,racine,borneSup);
        PrintStream os = new PrintStream(System.out);
        racine.print(os);
        sac.vider();
        ajoutRes(meilleurnoeud);
    }

    public void ajoutRes( BTreeCS meilleurnoeud){
        if (meilleurnoeud.getRootValue()!=null)
            sac.addItem(items.get(meilleurnoeud.getRootValue()));
        if(meilleurnoeud.getPere()!=null)
            ajoutRes(meilleurnoeud.getPere());
    }

    public void getPoidsPrix(BTreeCS noeud , int[] tab){
        if(noeud.getRootValue()!=null){
            tab[0] += items.get(noeud.getRootValue()).getPoids();
            tab[1] += items.get(noeud.getRootValue()).getPrix();
        }
        if (noeud.getPere()!=null)
            getPoidsPrix(noeud.getPere(),tab);
    }

    private void creerArbre(int index, BTreeCS noeud, int borneSup) {
        noeud.setRightTree(new BTreeCS(index,noeud));
        noeud.setLeftTree(new BTreeCS(noeud));

        int[] PoidsPrix = {0,0};
        getPoidsPrix((BTreeCS) noeud.getRightTree(), PoidsPrix);
        if (PoidsPrix[1] >= borneInf && PoidsPrix[0] <= poidsMax) {
            meilleurnoeud = (BTreeCS) noeud.getRightTree();
            borneInf = PoidsPrix[1];
        }
//        if (index < items.size()-1 && PoidsPrix[0] < poidsMax){
//            creerArbre(index+1, (BTreeCS) noeud.getRightTree(),borneInf);
//            int borneMax = borneSup - items.get(index).getPrix();
//            if (borneMax>=borneInf){
//                creerArbre(index+1,(BTreeCS) noeud.getLeftTree(),borneMax);
//            }
//        }
        if (index < items.size()-1) {
            int borneMax = borneSup - items.get(index).getPrix();
            if (borneSup>=borneInf) {
                creerArbre(index + 1, (BTreeCS) noeud.getRightTree(), borneSup);
                creerArbre(index + 1, (BTreeCS) noeud.getLeftTree(), borneMax);
            }
        }

    }

}
