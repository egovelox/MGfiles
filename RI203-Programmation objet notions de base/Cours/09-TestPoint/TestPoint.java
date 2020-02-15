// ==========================================================================
// Classe TestPoint                           
// --------------------------------------------------------------------------
// Ramasse-miettes
// ==========================================================================

public class TestPoint
{
    public static void main(String argv[])
    {
        Point p;

// --------------------------------------------------------------------------
// Instanciation de l'objet p et affichage de la reference.
// --------------------------------------------------------------------------
        p = new Point();
        System.out.println("p : " + p);

// --------------------------------------------------------------------------
// Nouvelle instanciation de l'objet p et affichage de la reference.
// --------------------------------------------------------------------------
// L'objet precedemment reference par p n'est plus accessible, car son
// adresse a ete ecrasee. L'espace perdu est recupere automatiquement par
// le "garbage collector" (ramasse-miettes).
// --------------------------------------------------------------------------
        p = new Point();
        System.out.println("p : " + p);
    }
}
