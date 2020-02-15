// ==========================================================================
// APPLICATION ArrayListString
// ==========================================================================

import java.util.*;

public class ArrayListString
{
    public static void main(String argv[])
    {
        int i;

// --------------------------------------------------------------------------
// Instanciation d'un ArrayList :
// --------------------------------------------------------------------------
        ArrayList<String> listeString;
        listeString = new ArrayList<String>();

// --------------------------------------------------------------------------
// Création de 3 postes :
// --------------------------------------------------------------------------
        listeString.add("Oie bernache");
        listeString.add("Moineau");
        listeString.add("Vautour");

// --------------------------------------------------------------------------
// Remarque :
//
// L'ajout d'un element d'un type different de String provoque une erreur de
// compilation. Exemple :  
//    
//      listeString.add(new StringBuffer("Autruche"));
// --------------------------------------------------------------------------

// --------------------------------------------------------------------------
// Affichage des chaines en majuscules :
// --------------------------------------------------------------------------
        System.out.println("Chaines en majuscules :\n");

        for (i = 0; i < listeString.size(); i++)
        {
            System.out.println(listeString.get(i).toUpperCase());
        }
    }
}
