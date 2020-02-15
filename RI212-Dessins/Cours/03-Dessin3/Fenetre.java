// ==========================================================================
// Classe Fenetre                                         Application Dessin3
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame implements MouseListener
{
    private Panneau panneauFond;

    public Fenetre(String s)
    {
        super(s);
        addWindowListener(new EcouteFenetre());

// -------------------------------------------------------------------------- 
// Creation de l'objet panneauFond :
// -------------------------------------------------------------------------- 
        panneauFond = new Panneau();
        panneauFond.setBackground(Color.white);
        panneauFond.setForeground(Color.black);
        panneauFond.setPreferredSize(new Dimension(300, 200));
        panneauFond.addMouseListener(this);

// --------------------------------------------------------------------------
// Ajout du panneau de fond a la fenetre :
// --------------------------------------------------------------------------
        getContentPane().add(panneauFond);

        pack();
        setVisible(true);
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
        panneauFond.setCoordonneesRect(e.getPoint());
        panneauFond.repaint();
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
