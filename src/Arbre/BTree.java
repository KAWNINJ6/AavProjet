package Arbre;

/** Interface pour les arbres binaires */
public interface BTree {

    /** accesseur : renvoie vrai si l'arbre ne contient aucun element */
    boolean isEmpty();

    /** accesseur : renvoie la valeur contenue a la racine de l'arbre */
    Integer getRootValue();

    /** accesseur : renvoie le sous-arbre gauche de l'arbre */
    BTree getLeftTree();

    /** accesseur : renvoie le sous-arbre droit de l'arbre */
    BTree getRightTree();

    /** accesseur : renvoie la valeur a la racine du sous-arbre gauche */
    Integer getLeftValue();

    /** accesseur : renvoie la valeur a la racine du sous-arbre droit */
    Integer getRightValue();

    /** modificateur : ajoute un sous-arbre gauche a la racine de l'arbre */
    void setLeftTree(BTree leftTree);

    /** modificateur : ajoute un sous-arbre droit a la racine de l'arbre */
    void setRightTree(BTree rightTree);


}