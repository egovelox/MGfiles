import java.awt.Point;

public class CercleCouleur extends Cercle
{
    private String couleur;
    
    public CercleCouleur(Point centre, int rayon, String couleur)
    {
        super(centre, rayon);
        this.couleur = couleur;
    }
    
    public void affiche()
    {
        System.out.println("Affichage du cercle coloré  : " + this);
    }
    
    public String toString()
    {
        return super.toString() + ", couleur " + couleur;
    }
}
