import java.awt.Point;

public class TestCercle
{
    public static void main(String argv[])
    {
        Cercle c;
        System.out.println("Deplacement du cercle :");
        c = new Cercle(new Point(100, 100), 25);
        c.deplace(new Point(95, 120));

        CercleCouleur cc;
        System.out.println("\nDeplacement du cercle coloré :");
        cc = new CercleCouleur(new Point(100, 100), 25, "vert");
        cc.deplace(new Point(95, 120));
    }
}