import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SacADos {
    private ArrayList<Item> objets;
    private float poidsMax;

    public float getPoidsMax() {
        return poidsMax;
    }

    public SacADos(String path, float poidsMax) throws FileNotFoundException {
        objets = rdFile(path);
        this.poidsMax = poidsMax;
    }

    public SacADos(float poidsMax) {
        objets = new ArrayList<Item>();
        this.poidsMax = poidsMax;
    }

    public static ArrayList<Item> rdFile(String path) throws FileNotFoundException {
        ArrayList<Item> obj = new ArrayList<Item>();
        Scanner scan = new Scanner(new File(path));
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] data = line.split(";");
            assert (data.length == 3);
            obj.add(new Item(data[0],Float.parseFloat(data[1]), Float.parseFloat(data[2])));
        }
        return obj;
    }

    public void addItem(Item it){
        objets.add(it);
    }

    public float getPoids(){
        float x = 0;
        for (Item item:objets) {
            x+= item.getPoids();
        }
        return x;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("");
        objets.forEach((item)->sb.append(item.toString()));
        return sb.toString();
    }
}
