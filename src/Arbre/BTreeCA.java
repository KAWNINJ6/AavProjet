package Arbre;


import java.io.PrintStream;

public class BTreeCA implements BTree{

    private Integer value;
    private BTreeCA filsGauche;
    private BTreeCA filsDroit;


    public BTreeCA(){}

    public BTreeCA(int value){
        this.value = value;
        this.filsGauche = new BTreeCA();
        this.filsDroit = new BTreeCA();
    }

    public BTreeCA(int value, BTreeCA filsGauche, BTreeCA filsDroit){
        this.value = value;
        this.filsGauche = filsGauche;
        this.filsDroit = filsDroit;
    }

    @Override
    public boolean isEmpty() {
        return this.filsGauche.isEmpty() && this.filsDroit.isEmpty();
    }

    @Override
    public Integer getRootValue(){
        return this.value;
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
    public Integer getLeftValue() {
        return this.filsGauche.getRootValue();
    }

    @Override
    public Integer getRightValue() {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        if (this.filsGauche != null)
            sb.append("{").append(this.filsGauche.toString()).append("}");
        if (this.value==null)
            sb.append(" ");
        else
            sb.append(this.value);
        if (this.filsDroit != null)
            sb.append("[").append(this.filsDroit.toString()).append("]");
        return sb.toString();
    }

    public void traversePreOrder(StringBuilder sb, String padding, String pointer, BTreeCA node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getRootValue() );
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (node.filsDroit != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.filsGauche);
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.filsDroit);
        }
    }

    public void print(PrintStream os) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", this);
        os.print(sb.toString());
    }
}
