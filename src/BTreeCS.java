public class BTreeCS extends BTreeCA{
    private BTreeCS père;

    public BTreeCS(){
        super();
    }

    public BTreeCS(Integer value){
        super(value);
        this.père = this;
    }

    public BTreeCS(Integer value, float poids, BTreeCS filsGauche, BTreeCS filsDroit){
        super(value, poids, filsGauche, filsDroit);
        this.père = this;
        filsGauche.setPère(this);
        filsDroit.setPère(this);
    }

    public void setPère(BTreeCS père){
        this.père = père;
    }

    public BTreeCS getPère(){
        return this.père;
    }
}
