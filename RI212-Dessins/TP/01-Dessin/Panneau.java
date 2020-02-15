// ==========================================================================
// Classe Panneau                                          Application Dessin
// -------------------------------------------------------------------------- 
// Dessins dynamiques dans un panneau. Trace des clics dans le fenetre.
// Le "dessin" est rendu permanent. Le nombre de clics est illimite...
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Panneau extends JPanel implements MouseListener
{
    private Vector<Point> vectRect = new Vector<Point>();

    public Panneau()
    {
        addMouseListener(this);
    }

    public void paintComponent(Graphics g)
    {
        int i;
        Point coordonneesRect;

        super.paintComponent(g);
        for (i = 0; i < vectRect.size(); i++)
        {
            coordonneesRect = vectRect.get(i);
            g.fillRect(coordonneesRect.x, coordonneesRect.y, 6, 6);
        }
    }

// --------------------------------------------------------------------------
// Méthodes de l'interface MouseListener
// --------------------------------------------------------------------------
    public void mouseClicked(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
        vectRect.add(e.getPoint());
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
