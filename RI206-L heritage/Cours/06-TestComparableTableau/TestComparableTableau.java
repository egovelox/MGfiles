// ==========================================================================
// APPLICATION TestComparableTableau
// ==========================================================================

import utilitairesMG.divers.*;

public class TestComparableTableau
{
    public static void main(String argv[])
    {

// --------------------------------------------------------------------------
// La methode trier(Comparable tableau[]) de la classe TriBulleTableau a pour 
// parametre un tableau d'objets de type Comparable. 
// Elle pourra donc trier n'importe quel tableau d'objets d'une classe qui 
// implemente l'interface Comparable (qui possede donc la methode compareTo). 
// --------------------------------------------------------------------------
// C'est le cas des classes Integer et String.
// --------------------------------------------------------------------------
        String tabString[] = 
            {"Martin", "Albert", "Jacques", "Nadia", "Ali"};

        Integer tabInteger[] =
            {new Integer(6), new Integer(17), new Integer(3)};

        System.out.println("Chaines a trier :");
        TriBulleTableau.afficher(tabString);
        TriBulleTableau.trier(tabString);
        System.out.println("\nChaines triees:");
        TriBulleTableau.afficher(tabString);

        System.out.println("\n\nEntiers a trier :");
        TriBulleTableau.afficher(tabInteger);
        TriBulleTableau.trier(tabInteger);
        System.out.println("\nEntiers tries:");
        TriBulleTableau.afficher(tabInteger);
    }
}