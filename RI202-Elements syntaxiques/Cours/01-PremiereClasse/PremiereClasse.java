// ==========================================================================
// PremiereClasse : elements syntaxiques
// ==========================================================================

import java.io.IOException;
import utilitairesMG.divers.Clavier;

public class PremiereClasse
{
    public static void main(String argv[]) throws IOException
    {
        int i;
        double x;

        System.out.print("Saisir une valeur numerique : ");
        x = Clavier.readDouble();
        
        i = (int)x;
        i++;
        
        System.out.println("i : " + i);
    }
}