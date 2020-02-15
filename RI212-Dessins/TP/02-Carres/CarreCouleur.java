// ==========================================================================
// APPLICATION Carres : classe CarreCouleur
// --------------------------------------------------------------------------
// Ecran avec composants graphiques, vecteurs de dessins
// ==========================================================================

import java.awt.*;


// ==========================================================================
// Classe CarreCouleur
// --------------------------------------------------------------------------
// Dans Rectangle, on peut acceder aux proprietes publiques :
// x, y, height, width
// ==========================================================================

public class CarreCouleur extends Rectangle
{
   private Color couleur;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public CarreCouleur(int x, int y, int taille, Color couleur)
   {
      super(x, y, taille, taille);
      this.couleur = couleur;
   }

// --------------------------------------------------------------------------
// affiche
// --------------------------------------------------------------------------
   public void affiche(Graphics g)
   {
      g.setColor(couleur);
      g.fillRect(x, y, height, width);
   }

// --------------------------------------------------------------------------
// deplace
// --------------------------------------------------------------------------
   public void deplace(int dx, int dy)
   {
      x += dx;
      y += dy;
   }

// --------------------------------------------------------------------------
// setCouleur
// --------------------------------------------------------------------------
   public void setCouleur(Color couleur)
   {
      this.couleur = couleur;
   }

// --------------------------------------------------------------------------
// setTaille
// --------------------------------------------------------------------------
   public void setTaille(int taille)
   {
      this.height = taille;
      this.width  = taille;
   }

// --------------------------------------------------------------------------
// getTaille
// --------------------------------------------------------------------------
   public int getTaille()
   {
      return this.height;
   }
}
