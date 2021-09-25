public class BTreeCA implements BTree{

    private Item item;
    private BTreeCA filsGauche;
    private BTreeCA filsDroit;

    public BTreeCA(){}

    public BTreeCA(Integer value){
        this.value = value;
        this.filsGauche = new BTreeCA();
        this.filsDroit = new BTreeCA();
    }

    public BTreeCA(Integer value, BTreeCA filsGauche, BTreeCA filsDroit){
        this.value = value;
        this.filsGauche = filsGauche;
        this.filsDroit = filsDroit;
    }

    @Override
    public boolean isEmpty() {
        return this.filsGauche.isEmpty() && this.filsDroit.isEmpty();
    }

    @Override
    public float getRootValue(){
        return item.getPrix();
    }

    @Override
    public BTree getLeftTree()  {
        return this.filsGauche;
    }

    @Override
    public BTree getRightTree() {
        return this.filsDroit;
    }

    @Override
    public float getLeftValue() {
        return this.filsGauche.getRootValue();
    }

    @Override
    public float getRightValue() {
        return this.filsDroit.getRootValue();
    }

    @Override
    public void setLeftTree(BTree leftTree) {
        this.filsGauche = (BTreeCA) leftTree;
    }

    @Override
    public void setRightTree(BTree rightTree) {
        this.filsDroit = (BTreeCA) rightTree;
    }



    public int sizeOfTree(){
        if (this.isEmpty()){
            return 0;
        } else{
            return 1 + this.filsGauche.sizeOfTree() + this.filsDroit.sizeOfTree();
        }
    }
}
