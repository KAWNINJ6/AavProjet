import Arbre.BTreeCS;
import SacADos.Resolution.Dynamique;
import SacADos.Item;
import SacADos.SacADos;
import Utils.AppManager;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Item> Items = SacADos.rdFile("./items.txt");
//        try {
//            ArrayList<Item> Items2 = SacADos.rdFile("./itemssoft.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        SacADos sac2 = new SacADos(12);
//        SacADos sac = new SacADos(4);
//        System.out.println(sac.toString());
//        SacADos.Resolution.Dynamique.dynamique(sac, Items);
//        Dynamique dynamique = new Dynamique();
//        dynamique.resoudre(sac,Items);
//        System.out.println(sac.toString());

        AppManager app = new AppManager();
        app.checkInput(args);
        app.start(args);

    }
}
