// ==========================================================================
// Classe TestPoint                                   
// ==========================================================================

public class TestPoint
{
    public static void main(String argv[])
    {
        Point p1, p2;

        System.out.println("Nombre points = " + Point.getNombrePoints());

        p1 = new Point();
        System.out.println("Nombre points = " + Point.getNombrePoints());

        p2 = new Point(15, 17);
        System.out.println("Nombre points = " + Point.getNombrePoints());
    }
}