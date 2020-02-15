// ==========================================================================
// APPLICATION TableauIrregulier
// ==========================================================================

public class TableauIrregulier
{
    public static void main(String args[])
    {
        int tableau[][];
        int lig, col;

// --------------------------------------------------------------------------
// Creation des lignes
// --------------------------------------------------------------------------
        tableau = new int[3][];

        System.out.println(
            "Longueur du tableau (nombre de lignes) : " + tableau.length);

// --------------------------------------------------------------------------
// Pour chaque ligne, creation des colonnes. Le tableau cree est triangulaire
// --------------------------------------------------------------------------
        for (lig = 0; lig < 3; lig++)
        {
            tableau[lig] = new int[lig + 1];
        }

// --------------------------------------------------------------------------
// Affichage du tableau
// --------------------------------------------------------------------------
         for (lig = 0; lig < 3; lig++)
        {
            for (col = 0; col < tableau[lig].length; col++)
            {
                System.out.print(tableau[lig][col] + " ");
            }
            System.out.print("\n");
        }
    }
}
