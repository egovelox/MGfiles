// ==========================================================================
// APPLICATION TestSurfaceComparable
// --------------------------------------------------------------------------
// Tri TriBulle applique a des figures geometriques.
// On va trier ces figures par surface croissante.
// ==========================================================================

import utilitairesMG.divers.TriBulleTableau;

public class TestSurfaceComparable
{
    public static void main(String argv[])
    {
        Figure tabFigures[] =
        {
            new Triangle(6, 2),
            new Cercle(4),
            new Rectangle(7, 9),
            new Triangle(6, 17),
            new Cercle(3),
            new Triangle(6, 7),
            new Rectangle(3, 14)
        };

        System.out.println("Figures a trier :\n");
        TriBulleTableau.afficher(tabFigures);
        TriBulleTableau.trier(tabFigures);
        System.out.println("\n\nFigures triees :\n");
        TriBulleTableau.afficher(tabFigures);
    }
}