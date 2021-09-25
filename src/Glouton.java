import java.util.ArrayList;
import java.util.Collections;

public class Glouton {
    public static void resoudre(SacADos sac, ArrayList<Item> items){
        items.sort(Collections.reverseOrder());
        for (Item item:items) {
            if(item.getPoids()+sac.getPoids() <= sac.getPoidsMax()){
                sac.addItem(item);
            }
        }
    }

}
