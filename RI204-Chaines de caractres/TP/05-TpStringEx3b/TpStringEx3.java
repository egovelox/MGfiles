// ==========================================================================
// APPLICATION TpStringEx3 : exercices sur les chaines de caracteres
// --------------------------------------------------------------------------
// Remplacer JAVA par C++.
// ==========================================================================

public class TpStringEx3
{
    public static void main(String arg[])
    {
        String chaine;                // Chaine a traiter

        chaine = "J'utilise JAVA avec brio !";
        System.out.println("AU DEPART : " + chaine);

// --------------------------------------------------------------------------
// Remplacement de java par c++
// Ici, c'est le replace avec CharSequence : on peut voir que String implemente CharSequence
// Sinon replaceAll mais attention aux expressions regulieres !!!
// --------------------------------------------------------------------------
        chaine = chaine.replace("JAVA", "C++");
        System.out.println("A LA FIN  : " + chaine);
        
        chaine = chaine.replace("C++", "JAVA");
        System.out.println("A LA FIN  : " + chaine);
    }
}
