// ==========================================================================
// APPLICATION TableauString : Tableau de references String
// ==========================================================================

public class TableauString
{
    public static void main(String argv[])
    {

// --------------------------------------------------------------------------
// Creation du tableau : la syntaxe utilisee permet d'instancier un tableau
// de 5 references de String. On utilise 2 constructeurs de la classe String.
// --------------------------------------------------------------------------
        int i;
        String tableau[];

        tableau = new String[5];

        tableau[0] = "BALBUZARD PECHEUR";
        tableau[1] = "OIE BERNACHE";
        tableau[2] = new String();
        tableau[4] = new String("VERDIER");

// --------------------------------------------------------------------------
// Affichage du tableau :
// --------------------------------------------------------------------------
        System.out.println("\nContenu du tableau : \n");

        for (i = 0; i < tableau.length; i++)
        {
            System.out.println("tableau[" + i + "] = " + tableau[i]);
        }
    }
}
