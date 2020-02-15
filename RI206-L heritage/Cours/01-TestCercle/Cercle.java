import java.awt.Point;

public class Cercle
{
    private Point centre;
    private int rayon;

    public Cercle(Point centre, int rayon)
    {
        this.centre = centre;
        this.rayon = rayon;
    }

    public void affiche()
    {
        System.out.println("Affichage du cercle  : " + this);
    }

    public void efface()
    {
        System.out.println("Effacement du cercle : " + this);
    }

    public void deplace(Point nouveauCentre)
    {
        efface();
        centre = nouveauCentre;
        affiche();
    }

    public String toString()
    {
        return centre.x + ", " + centre.y + ", rayon " + rayon;
    }
}