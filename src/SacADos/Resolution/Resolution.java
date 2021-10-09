package SacADos.Resolution;

import SacADos.Item;
import SacADos.SacADos;
import java.util.ArrayList;

public abstract class Resolution {

    protected SacADos sac;
    protected ArrayList<Item> items;
    public Resolution(SacADos sac, ArrayList<Item> items){
        this.sac=sac;
        this.items=items;
    }

    public abstract void resoudre();
}
