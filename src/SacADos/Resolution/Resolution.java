package SacADos.Resolution;

import SacADos.Item;
import SacADos.SacADos;
import java.util.ArrayList;

/**
 * Classe abstraite d'une resolution
 */
public abstract class Resolution {
    //le sac
    protected SacADos sac;
    //la liste d'objets à inserer dans le sac
    protected ArrayList<Item> items;

    /**
     * initialise la resolution avec un sac avec une capacité max et une liste d'items
     * @param sac   le sac à remplir
     * @param items la liste d'items
     */
    public Resolution(SacADos sac, ArrayList<Item> items){
        this.sac=sac;
        this.items=items;
    }

    /**
     * resoud le probleme du sac en ajoutant les objets trouves par la resolution dans le sac
     */
    public abstract void resoudre();
}
