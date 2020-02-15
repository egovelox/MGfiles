// ==========================================================================
// Classe TestPoint                                   Application TestPoint
// ==========================================================================

public class TestPoint
{
    public static void main(String argv[])
    {
        Point p;

        p = new Point();

        System.out.println("\nProprietes");
        p.afficheXY();
 
        p.modifieXY(10, 20);
        System.out.println("\nProprietes (apres modification)");
        p.afficheXY();
    }
}
