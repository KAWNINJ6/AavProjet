package SacADos.Resolution;


import SacADos.Item;
import SacADos.SacADos;

import java.util.ArrayList;

public class Dynamique extends Resolution {

    public Dynamique(SacADos sac, ArrayList<Item> items) {
        super(sac, items);
    }

    public void resoudre() {
        int PRECISION= 1;
        int nbItem = items.size();
        int PoidsMax = (int)sac.getPoidsMax()*PRECISION;
        float[][] table = new float[nbItem][PoidsMax+1];
        for(int c=0; c < PoidsMax;++c){
            table[0][c]=items.get(0).getPoids()* PRECISION >c? 0:items.get(0).getPrix();
        }
        for (int l = 1; l< nbItem;++l){
            Item it = items.get(l);
            for(int c=0; c <= PoidsMax;++c){
                table[l][c] = it.getPoids()*PRECISION > c ? table[l-1][c]:Math.max(table[l-1][c],table[l-1][(int)(c-it.getPoids()*PRECISION)]+it.getPrix());
            }
        }

        int i=nbItem-1;
        int j=PoidsMax;

        while(table[i][j] == table[i][j-1])
            --j;
        while(j > 0) {
            while (i > 0 && table[i][j] == table[i - 1][j])
                --i;
            j = j - (int) (items.get(i).getPoids()*PRECISION);
            if (j >= 0)
                sac.addItem(items.get(i));
            --i;
        }
    }
}
