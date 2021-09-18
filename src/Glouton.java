import java.util.ArrayList;
import java.util.Collections;

public class Glouton {
    public static void glouton(SacADos sac, ArrayList<Item> items){
        Collections.sort(items,Collections.reverseOrder());
        for (Item item:items) {
            if(item.getPoids()+sac.getPoids() <= sac.getPoidsMax()){
                sac.addItem(item);
            }
        }
    }

}
