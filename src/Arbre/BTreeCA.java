package Arbre;

import java.io.PrintStream;

/**
 * Représente un arbre binaire
 */
public class BTreeCA implements BTree{
    private Integer value;
    private BTreeCA filsGauche;
    private BTreeCA filsDroit;

    /**
     * Initialise un arbre vide
     */
    public BTreeCA(){}

    /**
     * Initialise un arbre avec une valeur
     * @param value la valeur
     */
    public BTreeCA(int value){
        this.value = value;
        this.filsGauche = new BTreeCA();
        this.filsDroit = new BTreeCA();
    }

    /**
     * Initialise un arbre avec une valeur ainsi que deux branche fils
     * @param value La valeur
     * @param filsGauche    Arbre lié à la branche(fils) gauche
     * @param filsDroit     Arbre lié à la branche(fils) droit
     */
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.filsGauche != null)
            sb.append("{").append(this.filsGauche).append("}");
        if (this.value==null)
            sb.append(" ");
        else
            sb.append(this.value);
        if (this.filsDroit != null)
            sb.append("[").append(this.filsDroit).append("]");
        return sb.toString();
    }

    /**
     * methode d'affichage d'un arbre
     * @param sb    le stringbuilder pour afficher l'arbre
     * @param padding   la chaine qui contient l'indentation du noeud
     * @param pointer   la chaine qui contient les sous-branches d'un arbre
     * @param node   le noeud actuel
     */
    public void traversePreOrder(StringBuilder sb, String padding, String pointer, BTreeCA node) {
        if (node != null) {
            //ajout du nouveau noeud
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getRootValue() );
            sb.append("\n");
            //ajout de la représentation des noeuds fils
            String paddingForBoth = padding + "│  ";
            String pointerForRight = "└──";
            String pointerForLeft = (node.filsDroit != null) ? "├──" : "└──";
            //ajout des noeuds fils
            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.filsGauche);
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.filsDroit);
        }
    }

    /**
     * affiche l'arbre sur le flux d'écriture
     * @param os le flux
     */
    public void print(PrintStream os) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", this);
        os.print(sb);
    }
}
