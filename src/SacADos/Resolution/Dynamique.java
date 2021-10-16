package SacADos.Resolution;

import SacADos.Item;
import SacADos.SacADos;

import java.util.ArrayList;

/**
 * Resolution par programmation dynamique, avec une complexité quadratique
 */
public class Dynamique extends Resolution {

    public Dynamique(SacADos sac, ArrayList<Item> items) {
        super(sac, items);
    }

    public void resoudre() {
        int PRECISION = 1; // indique le nbr de chiffre après la virgule voulus
        int nbItem = items.size();
        int PoidsMax = (int)sac.getPoidsMax()*PRECISION;
        float[][] table = new float[nbItem][PoidsMax+1]; // matrice n(nombre d'objets) * n(poids maximal) des solutions

        // remplie la premiere ligne de la matrice
        for(int c = 0; c < PoidsMax; ++c){
            table[0][c] = items.get(0).getPoids() * PRECISION > c ? 0 : items.get(0).getPrix();
        }
        // remplie le reste de la matrice
        for (int l = 1; l < nbItem; ++l){
            Item it = items.get(l);
            for(int c=0; c <= PoidsMax; ++c){
                table[l][c] = it.getPoids() * PRECISION > c ? table[l-1][c] : Math.max(table[l-1][c], table[l-1][(int)(c - it.getPoids()*PRECISION)] + it.getPrix());
            }
        }

        // remonte le tableau, puis rajoute au sac les items avec la meilleur solution
        int i = nbItem-1;
        int j = PoidsMax;

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
