import java.util.ArrayList;

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
        float[][] table = new float[items.size()][(int)sac.getPoidsMax()+1];
        for(int c=0; c < sac.getPoidsMax()+1;++c){
            table[0][c]=items.get(0).getPoids()>c? 0:items.get(0).getPrix();
        }
        for (int l = 1; l< items.size();l++){
            Item it = items.get(l);
            for(int c=0; c <= sac.getPoidsMax();c++){
                table[l][c] = it.getPoids() > c ? table[l-1][c]:Math.max(table[l-1][c],table[l-1][(int)(c-it.getPoids())]+it.getPrix());
            }
        }
//        for (float[] ligne: table) {
//            for (float colonne: ligne) {
//                System.out.print(colonne + ",");
//            }
//            System.out.println("\n");
//        }
        int i=items.size()-1,j=(int)sac.getPoidsMax();
        while (table[i][j]==(table[i][j-1])){
            j--;
        }
        System.out.println("ok");
        while(j>0){
            System.out.println("cool");
            while (i>0 && table[i][j]==(table[i-1][j])){
                i--;
                j=(int)(j-items.get(i).getPoids());
                if (j>0){
                    sac.addItem(items.get(i));
                    i--;
                }
            }
        }
        System.out.println("super");
    }
}
