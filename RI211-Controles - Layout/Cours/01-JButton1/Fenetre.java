// ==========================================================================
// Classe Fenetre                                        Application JButton1
// --------------------------------------------------------------------------
// Cette classe implémente l'interface ActionListener (pour écouter
// l'évènement lié au bouton).
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

// -------------------------------------------------------------------------- 
// Constructeur :
// -------------------------------------------------------------------------- 
    public Fenetre(String s)
    {
        super(s);
        addWindowListener(new EcouteFenetre());

// ---------------------------------------------------------------------
// Creation de l'objet panneauFond :
// ---------------------------------------------------------------------
        panneauFond = new JPanel();
        panneauFond.setBackground(Color.black);

// ---------------------------------------------------------------------
// Creation des boutons :
// ---------------------------------------------------------------------
        bouton1 = new JButton("BLANC");
        bouton1.setFont(new Font("TimesRoman", Font.BOLD + Font.ITALIC, 40));

        bouton2 = new JButton("Couleur initiale : NOIR");

        bouton1.addActionListener(this);
        bouton2.addActionListener(this);

// ---------------------------------------------------------------------
// Ajout des boutons au panneauFond :
// ---------------------------------------------------------------------
        panneauFond.add(bouton1);
        panneauFond.add(bouton2);

// ---------------------------------------------------------------------
// Ajout du panneauFond à la fenetre :
// ---------------------------------------------------------------------
//        getContentPane().add(panneauFond);
        add(panneauFond);

        pack();
        setVisible(true);
    }

// --------------------------------------------------------------------------
// Méthode de l'interface ActionListener
// --------------------------------------------------------------------------
// La methode getSource() retourne la reference du composant qui a emis
// l'evenement.
// --------------------------------------------------------------------------
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
