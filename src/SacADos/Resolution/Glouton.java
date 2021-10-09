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
        items.sort(Collections.reverseOrder());
        for (Item item:items) {
            if(item.getPoids()+sac.getPoids() <= sac.getPoidsMax()){
                sac.addItem(item);
            }
        }
    }

}
