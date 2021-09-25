public class BTreeCS extends BTreeCA{
    private BTreeCS pere;

    public BTreeCS(){
        super();
    }

    public BTreeCS(Integer value){
        super(value);
        this.pere = this;
    }

    public BTreeCS(Integer value, BTreeCS filsGauche, BTreeCS filsDroit){
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

    public float getPoids(){
        float res =0;
        if (this.pere!=this)
            res = this.getRootValue() + pere.getRootValue();
        return res;
    }

}
