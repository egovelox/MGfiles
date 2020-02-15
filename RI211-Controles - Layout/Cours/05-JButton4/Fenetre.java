// ==========================================================================
// Classe Fenetre                                        Application JButton4
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame implements ActionListener
{
    private JPanel panneauFond;
    private JScrollPane defileur;

    private JButton monBouton1;
    private JButton monBouton2;

    public Fenetre(String s)
    {
        super(s);
        addWindowListener(new EcouteFenetre());

// ---------------------------------------------------------------------
// Creation de l'objet panneauFond :
// ---------------------------------------------------------------------
        panneauFond = new JPanel();
        panneauFond.setBackground(new Color(220, 120, 220));

// ---------------------------------------------------------------------
// Creation des boutons et ajout de leurs ecouteurs
// ---------------------------------------------------------------------
        monBouton1 = new JButton("FAUCON");
        monBouton2 = new JButton("BONDREE APIVORE");

        monBouton1.addActionListener(this);
        monBouton2.addActionListener(this);

// ---------------------------------------------------------------------
// Ajout des boutons au panneau
// ---------------------------------------------------------------------
        panneauFond.add(monBouton1);
        panneauFond.add(monBouton2);
        
        FlowLayoutMG.unifieTailleComposants(panneauFond);

// ---------------------------------------------------------------------
// Creation d'un defileur (JScrollPane) ayant le panneau pour client
// ---------------------------------------------------------------------
        defileur = new JScrollPane(panneauFond);

// ---------------------------------------------------------------------
// Ajout du defileur a la fenetre
// ---------------------------------------------------------------------
        add(defileur);

        pack();
        setVisible(true);
    }

// ---------------------------------------------------------------------
// getActionCommand() affiche le nom du bouton cliqué ("FAUCON"...)
// ---------------------------------------------------------------------
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
    }
}
