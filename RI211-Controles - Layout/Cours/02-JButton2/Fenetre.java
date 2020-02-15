// ==========================================================================
// Classe Fenetre                                        Application JButton2
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame implements ActionListener
{
    private JPanel panneauFond;
    private JButton bouton1;
    private JButton bouton2;

    public Fenetre(String s)
    {
        super(s);
        addWindowListener(new EcouteFenetre());

// ---------------------------------------------------------------------
// Creation de l'objet panneauFond :
// ---------------------------------------------------------------------
        panneauFond = new JPanel();
        panneauFond.setBackground(Color.black);

        bouton1 = new JButton("BLANC");
        bouton1.setFont(new Font("TimesRoman", Font.BOLD + Font.ITALIC, 40));

        bouton2 = new JButton("Couleur initiale : NOIR");

        bouton1.addActionListener(this);
        bouton2.addActionListener(this);

// ---------------------------------------------------------------------
// Calcul de la taille preferee des boutons
// ---------------------------------------------------------------------
// maxWidth est la plus grande des largeurs préférées des deux boutons
// maxHeight est la plus grande des hauteurs préférées des deux boutons
// ---------------------------------------------------------------------
        int maxWidth;
        int maxHeight;

        if ((bouton1.getPreferredSize().width)
            > (bouton2.getPreferredSize().width))
        {
            maxWidth = (bouton1.getPreferredSize().width);
        }
        else
        {
            maxWidth = (bouton2.getPreferredSize().width);
        }

        if ((bouton1.getPreferredSize().height)
            > (bouton2.getPreferredSize().height))
        {
            maxHeight = (bouton1.getPreferredSize().height);
        }
        else
        {
            maxHeight = (bouton2.getPreferredSize().height);
        }

// ---------------------------------------------------------------------
// Modification de la taille preferee des boutons
// ---------------------------------------------------------------------
        bouton1.setPreferredSize(new Dimension(maxWidth, maxHeight));
        bouton2.setPreferredSize(new Dimension(maxWidth, maxHeight));

        panneauFond.add(bouton1);
        panneauFond.add(bouton2);

        add(panneauFond);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == bouton1)
        {
            panneauFond.setBackground(Color.white);
        }
        else
        {
            panneauFond.setBackground(Color.black);
        }
    }
}
