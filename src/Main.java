import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Item> Items = SacADos.rdFile("./items.txt");
        ArrayList<Item> Items2 = SacADos.rdFile("./itemssoft.txt");
        SacADos sac2 = new SacADos(12);
        SacADos sac = new SacADos(4);
        //System.out.println(sac.toString());
//        Dynamique.dynamique(sac, Items);
        Dynamique.resoudre(sac,Items);
        System.out.println(sac.toString());
    }
}
