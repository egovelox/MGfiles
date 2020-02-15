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
        System.out.println("p.x = " + p.getX() + ", p.y = " + p.getY());

        p.setX(10);
        p.setY(20);
        System.out.println("\nProprietes (apres modification)");
        System.out.println("p.x = " + p.getX() + ", p.y = " + p.getY());
    }
}
