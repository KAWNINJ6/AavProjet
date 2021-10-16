package SacADos.Resolution;

import SacADos.Item;
import SacADos.SacADos;

import java.util.ArrayList;
import java.util.Collections;

public class Glouton extends Resolution{

    public Glouton(SacADos sac, ArrayList<Item> items) {
        super(sac, items);
    }

    public void resoudre(){
        //trie le tableau des items à l'aide de la methode compareTo dans l'ordre décroissant
        items.sort(Collections.reverseOrder());
        for (Item item:items) {
            //ajoute l'objet si la charge maximale du sac n'est pas depassee
            if(item.getPoids()+sac.getPoids() <= sac.getPoidsMax()){
                sac.addItem(item);
            }
        }
    }

}
