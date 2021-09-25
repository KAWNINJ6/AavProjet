public interface BTree {

    boolean isEmpty();
    /* accesseur : renvoie vrai si l'arbre ne contient aucun element */

    float getRootValue();
    /* accesseur : renvoie la valeur contenue a la racine de l'arbre */

    BTree getLeftTree();
    /* accesseur : renvoie le sous-arbre gauche de l'arbre */

    BTree getRightTree();
    /* accesseur : renvoie le sous-arbre droit de l'arbre */

    float getLeftValue();
    /* accesseur : renvoie la valeur a la racine du sous-arbre gauche */

    float getRightValue();
    /* accesseur : renvoie la valeur a la racine du sous-arbre droit */

    void setLeftTree(BTree leftTree);
    /* modificateur : ajoute un sous-arbre gauche a la racine de l'arbre */

    void setRightTree(BTree rightTree);
    /* modificateur : ajoute un sous-arbre droit a la racine de l'arbre */


    float getPoids();
}