// ==========================================================================
// APPLICATION TableauInt : Tableau de primitives de type int
// ==========================================================================

public class TableauInt
{
    public static void main(String argv[])
    {
        int i;
        int tableau[];

        tableau = new int[3];
        System.out.println(
            "tableau : " + tableau + " longueur : " + tableau.length);

        for (i = 0; i < tableau.length; i++)
        {
            tableau[i] = i + 1;
        }

        for (i = 0; i < tableau.length; i++)
        {
            System.out.println("tableau[" + i + "] = " + tableau[i]);
        }
    }
}