import java.util.ArrayList;
import java.util.function.Predicate;

public class Dynamique {

    public static void dynamique(SacADos sac, ArrayList<Item> items) {
        float[][] matrice = new float[items.size()+1][(int)(sac.getPoidsMax() * Math.pow(10.0, 0)+1)];

        for (int i = 0; i <= sac.getPoidsMax(); i++) {
            if ((items.get(0).getPoids() * Math.pow(10.0, 0)) > i)
                matrice[0][i] = 0;
            else
                matrice[0][i] = items.get(0).getPrix();
        }

        for (int i = 1; i <= items.size(); i++) {
            for (int j = 0; j <= sac.getPoidsMax(); j++) {
                if (items.get(i-1).getPoids() * Math.pow(10.0, 0) > j) {
                    matrice[i][j] = matrice[i-1][j];
                }else
                    matrice[i][j] = Math.max(matrice[i-1][j],
                            matrice[i-1][(int)(j - (items.get(i-1).getPoids() * Math.pow(10.0, 0)))] +
                            items.get(i-1).getPrix());
            }
        }

        for (float[] ligne: matrice) {
            for (float colonne: ligne) {
                System.out.print(colonne + ",");
            }
            System.out.println("\n");
        }

        float res = matrice[items.size()][(int)sac.getPoidsMax()];
        float poidsMax = sac.getPoidsMax();
        ArrayList<Item> solution = new ArrayList<>();

        for (int i = items.size(); i > 0 && res > 0; i--) {
            if (res != matrice[i-1][(int)(sac.getPoidsMax() * Math.pow(10.0, 0))]) {
                solution.add(items.get(i-1));
                res -= items.get(i-1).getPrix();
                poidsMax -= items.get(i-1).getPoids();
            }
        }
        solution.forEach((soluce)-> System.out.println(soluce.toString()));
    }


    public static void dyna(SacADos sac, ArrayList<Item> items) {
        int PRECISION= 10;
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

        for (float[] ligne: table) {
            for (float colonne: ligne) {
                System.out.print(colonne + ",");
            }
            System.out.println("\n");
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
