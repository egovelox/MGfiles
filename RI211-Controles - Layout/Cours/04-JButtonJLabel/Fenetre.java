// ==========================================================================
// Classe Fenetre                                   Application JButtonJLabel
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame implements ActionListener
{
    private JPanel panneauFond;

    private JPanel panneauCentre;
    private JButton monBouton1;
    private JButton monBouton2;

    private JPanel panneauSud;
    private JLabel message;

    public Fenetre(String s)
    {
        super(s);
        addWindowListener(new EcouteFenetre());

// ---------------------------------------------------------------------
// Creation de l'objet panneauFond. L'organiser en BorderLayout :
// ---------------------------------------------------------------------
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());

// ---------------------------------------------------------------------
// Creation de l'objet panneauCentre et ajout de ses composants :
// ---------------------------------------------------------------------
        panneauCentre = new JPanel();
        panneauCentre.setBackground(Color.yellow);

        monBouton1 = new JButton("FAUCON");
        monBouton2 = new JButton("BONDREE APIVORE");

        monBouton1.addActionListener(this);
        monBouton2.addActionListener(this);

        panneauCentre.add(monBouton1);
        panneauCentre.add(monBouton2);
        
// ---------------------------------------------------------------------
// Methode qui met tous les composants du panneauCentre a la meme taille
// ---------------------------------------------------------------------
        FlowLayoutMG.unifieTailleComposants(panneauCentre);

// ---------------------------------------------------------------------
// Creation de l'objet panneauSud et ajout de son composant :
// ---------------------------------------------------------------------
        panneauSud = new JPanel();
        panneauSud.setBackground(Color.white);

        message = new JLabel(" ");
        panneauSud.add(message);

// ---------------------------------------------------------------------
// Ajout de panneauCentre et panneauSud a panneauFond :
// ---------------------------------------------------------------------
        panneauFond.add(panneauCentre);
        panneauFond.add(panneauSud, BorderLayout.SOUTH);

        add(panneauFond);

        pack();
        setVisible(true);

// ---------------------------------------------------------------------
// L'instruction suivante permet de positionner la fenetre au milieu de 
// l'ecran. 
// ---------------------------------------------------------------------
// Le parametre de la methode setLocationRelativeTo est la reference 
// d'un composant par rapport auquel on centre le composant courant (ici 
// la JFrame). Quand ce parametre vaut null, c'est au centre de l'ecran.
// ---------------------------------------------------------------------
        setLocationRelativeTo(null);
    }

// -------------------------------------------------------------------------- 
// Traitement des choix sur les boutons.
// -------------------------------------------------------------------------- 
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == monBouton1)
        {
            message.setText("Vous avez choisi le bouton "
                + e.getActionCommand() + ".");
        }
        else
        {
            message.setText("Elle mange sans doute des abeilles !");
        }
    }
}
