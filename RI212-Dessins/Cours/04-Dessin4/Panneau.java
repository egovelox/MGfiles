// ==========================================================================
// Classe Panneau                                         Application Dessin4
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Panneau extends JPanel implements MouseListener
{
    private Point coordonneesRect;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public Panneau()
    {
        addMouseListener(this);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (coordonneesRect != null) 
            g.fillRect(coordonneesRect.x, coordonneesRect.y, 8, 8);
    }

// --------------------------------------------------------------------------
// Méthodes de l'interface MouseListener
// --------------------------------------------------------------------------
    public void mouseClicked(MouseEvent e)
    {
    }

// --------------------------------------------------------------------------
// Modifie la position du rectangle quand la souris est enfoncee
// --------------------------------------------------------------------------
    public void mousePressed(MouseEvent e)
    {
        coordonneesRect = e.getPoint();
        repaint();
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }
}
