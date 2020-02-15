// ==========================================================================
// Classe Panneau                                         Application Dessin3
// ==========================================================================

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel
{
    private Point coordonneesRect;

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (coordonneesRect != null) 
            g.fillRect(coordonneesRect.x, coordonneesRect.y, 8, 8);
    }

    public void setCoordonneesRect(Point coordonneesRect)
    {
        this.coordonneesRect = coordonneesRect;
    }
}
