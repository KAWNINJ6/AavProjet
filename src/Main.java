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
        AppManager app = new AppManager();
        app.checkInput(args);
        app.start(args);

    }
}
