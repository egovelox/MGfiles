// ==========================================================================
// APPLICATION TpStringEx1 : exercices sur les chaines de caracteres
// --------------------------------------------------------------------------
// Transformer les minuscules en majuscules et reciproquement.
// ==========================================================================

public class TpStringEx1
{
    public static void main(String arg[])
    {
        String chaine;                // Chaine a traiter
        String chaineTravail;         // Chaine de travail
        char c;                       // Caractere examine
        int i;                        // Indice du caractere examine

        chaine = "J'utilise JAVA avec brio !";
        System.out.println("AU DEPART : " + chaine);

        chaineTravail = "";

        for (i = 0; i < chaine.length(); i++)
        {
            c = chaine.charAt(i);

            if ((c >= 'a') && (c <= 'z'))
            {
                c += 'A' - 'a';
            }
            else
            {
                if ((c >= 'A') && (c <= 'Z'))
                {
                    c += 'a' - 'A';
                }
            }
            chaineTravail += c;
        }

        chaine = chaineTravail;
        System.out.println("A LA FIN  : " + chaine);
    }
}
