// ==========================================================================
// Classe TestPoint                                   Application TestPoint
// ==========================================================================

public class TestPoint
{
    public static void main(String argv[])
    {
        Point p1, p2;

        p1 = new Point(10, 20);
        p2 = new Point(12, 40);

// --------------------------------------------------------------------------
// Affichage des proprietes des objets p1 et p2.
// --------------------------------------------------------------------------
        System.out.println("\nProprietes");
        System.out.println("p1.x = " + p1.getX() + ", p1.y = " + p1.getY());
        System.out.println("p2.x = " + p2.getX() + ", p2.y = " + p2.getY());
    }
}
