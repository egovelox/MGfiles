// ==========================================================================
// Classe Fenetre                                         Application JTable4
// ==========================================================================

import javax.swing.*;
import java.util.*;
import java.awt.*;
import utilitairesMG.graphique.*;
import utilitairesMG.divers.*;

public class Fenetre extends JFrame
{
    private JPanel panneauFond;

    private JTable table;
    private ModeleTableContact modeleTable;

    private JScrollPane defileur;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public Fenetre(String s, Vector<Contact> listeContacts,
                             Vector<Colonne> listeColonnes)
    {
        super(s);
        addWindowListener(new EcouteFenetre());

// --------------------------------------------------------------------------
// Création de l'objet JPanel :
// --------------------------------------------------------------------------
        panneauFond = new JPanel();
        panneauFond.setLayout(new BorderLayout());
        panneauFond.setPreferredSize(new Dimension(500, 150));

// --------------------------------------------------------------------------
// Création de l'objet JTable :
// --------------------------------------------------------------------------
        modeleTable = new ModeleTableContact(listeContacts, listeColonnes);
        table = new JTable(modeleTable);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        defileur = new JScrollPane(table);
        defileur.getViewport().setBackground(new Color(250, 190, 130));

        panneauFond.add(defileur);

        getContentPane().add(panneauFond);

        pack();
        setVisible(true);
    }
}
