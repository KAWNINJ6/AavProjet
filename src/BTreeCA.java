public class BTreeCA implements BTree{

    private Integer value;
    private float poids;
    private BTreeCA filsGauche;
    private BTreeCA filsDroit;

    public BTreeCA(){}

    public BTreeCA(Integer value){
        this.value = value;
        this.filsGauche = new BTreeCA();
        this.filsDroit = new BTreeCA();
    }

    public BTreeCA(Integer value, float poids, BTreeCA filsGauche, BTreeCA filsDroit){
        this.value = value;
        this.poids = poids;
        this.filsGauche = filsGauche;
        this.filsDroit = filsDroit;
    }

    @Override
    public boolean isEmpty() {
        return this.filsGauche.isEmpty() && this.filsDroit.isEmpty();
    }

    @Override
    public int getRootValue() throws Exception {
        return this.value;
    }

    @Override
    public BTree getLeftTree() throws Exception {
        return this.filsGauche;
    }

    @Override
    public BTree getRightTree() throws Exception {
        return this.filsDroit;
    }

    @Override
    public int getLeftValue() throws Exception {
        return this.filsGauche.value;
    }

    @Override
    public int getRightValue() throws Exception {
        return this.filsDroit.value;
    }

    @Override
    public void setRootValue(int val) throws Exception {
        this.value = val;
    }

    @Override
    public void setLeftTree(BTree leftTree) throws Exception {
        this.filsGauche = (BTreeCA) leftTree;
    }

    @Override
    public void setRightTree(BTree rightTree) throws Exception {
        this.filsDroit = (BTreeCA) rightTree;
    }

    @Override
    public void setLeftValue(int leftSubRoot) throws Exception {
        this.filsGauche.value = leftSubRoot;
    }

    @Override
    public void setRightValue(int rightSubRoot) throws Exception {
        this.filsDroit.value = rightSubRoot;
    }

    @Override
    public float getPoids() {
        return this.poids;
    }

    public int sizeOfTree(){
        if (this.isEmpty()){
            return 0;
        } else{
            return 1 + this.filsGauche.sizeOfTree() + this.filsDroit.sizeOfTree();
        }
    }
}
