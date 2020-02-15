// ==========================================================================
// APPLICATION VectorString
// --------------------------------------------------------------------------
// Vecteur ne contenant que des String
// ==========================================================================

import java.util.*;

public class VectorString
{
    public static void main(String argv[])
    {
        int i;

// --------------------------------------------------------------------------
// Instanciation d'un Vector :
// --------------------------------------------------------------------------
        Vector<String> listeString = new Vector<String>();

// --------------------------------------------------------------------------
// Création de 3 postes :
// --------------------------------------------------------------------------
        listeString.add("Oie bernache");
        listeString.add("Moineau");
        listeString.add("Vautour");
        
        System.out.println("Taille de la liste : " + listeString.size() + "\n");

// --------------------------------------------------------------------------
// Remarque :
//
// L'ajout d'un element d'un type different de String provoque une erreur de
// compilation. Exemple :  
//    
//      listeString.add(new StringBuffer("Autruche"));
// --------------------------------------------------------------------------

// --------------------------------------------------------------------------
// Affichage des chaines :
// --------------------------------------------------------------------------
        System.out.println("Chaines : ");

        for (i = 0; i < listeString.size(); i++)
        {
            System.out.println("listeString.get(" + i + ") = "
                + listeString.get(i));
        }

// --------------------------------------------------------------------------
// Affichage des chaines en majuscules :
// --------------------------------------------------------------------------
        System.out.println("\nChaines en majuscules : ");

        for (i = 0; i < listeString.size(); i++)
        {
            System.out.println(listeString.get(i).toUpperCase());
        }
    }
}
