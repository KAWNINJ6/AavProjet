package Arbre;

import SacADos.Item;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class BTreeCS extends BTreeCA{
    private BTreeCS pere;

    public BTreeCS(){
        super();
    }

    public BTreeCS(int value){
        super(value);
        this.pere = this;
    }

    public BTreeCS(BTreeCS pere){
        super();
        this.pere = pere;
    }
    public BTreeCS(int value, BTreeCS pere){
        super(value);
        this.pere = pere;
    }

    public BTreeCS(int value, BTreeCS filsGauche, BTreeCS filsDroit){
        super(value, filsGauche, filsDroit);
        this.pere = this;
        filsGauche.setPere(this);
        filsDroit.setPere(this);
    }

    public void setPere(BTreeCS pere){
        this.pere = pere;
    }

    public BTreeCS getPere(){
        return this.pere;
    }


}
