// ==========================================================================
// Classe TestPoint                                  
// ==========================================================================

public class TestPoint
{
    public static void main(String argv[])
    {
        Point p1, p2;

        p1 = new Point();
        p2 = new Point(15, 17);

        System.out.println("\nApres instanciation");
        System.out.println("p1.x = " + p1.getX() + ", p1.y = " + p1.getY());
        System.out.println("p2.x = " + p2.getX() + ", p2.y = " + p2.getY());

        p1.reinit(20, 40);
        p2.reinit();

        System.out.println("\nApres reinitialisation");
        System.out.println("p1.x = " + p1.getX() + ", p1.y = " + p1.getY());
        System.out.println("p2.x = " + p2.getX() + ", p2.y = " + p2.getY());
    }
}