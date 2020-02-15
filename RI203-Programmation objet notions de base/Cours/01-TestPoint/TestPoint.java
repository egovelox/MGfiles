// ==========================================================================
// Classe TestPoint                                   
// --------------------------------------------------------------------------
// Utilisation de la classe Point
// ==========================================================================

public class TestPoint
{
    public static void main(String argv[])
    {
        Point p;

        p = new Point();
        System.out.println("Référence de l'objet Point (p) : " + p);
        System.out.println("\nProprietes");
        System.out.println("p.x = " + p.x + ", p.y = " + p.y);

        p.x = 10;
        p.y = 20;
        System.out.println("\nProprietes (apres modification)");
        System.out.println("p.x = " + p.x + ", p.y = " + p.y);
    }
}
