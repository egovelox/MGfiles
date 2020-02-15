// ==========================================================================
// Classe Controleur                                      Application JTable3
// -------------------------------------------------------------------------- 
// Affichage d'une JTable dans la fenêtre, avec scrolling. La JTable est 
// construite a partir d'un modele de table.
// ==========================================================================

import java.util.*;
import utilitairesMG.graphique.*;
import utilitairesMG.divers.*;

public class Controleur
{

// -------------------------------------------------------------------------- 
// Programme principal de l'application
// -------------------------------------------------------------------------- 
    public static void main(String args[])
    {
        Vector<Colonne> listeColonnes;
        Vector<Vector<Object>> listeLignes;

// -------------------------------------------------------------------------- 
// Creation des vecteurs des donnees a afficher.
// -------------------------------------------------------------------------- 
        listeLignes = creeListeLignes();
        listeColonnes = creeListeColonnes();

// -------------------------------------------------------------------------- 
// Affichage de la fenetre.
// -------------------------------------------------------------------------- 
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable()
            {
                public void run()
                {
                    LF.setLF();
                    Fenetre fenetre = 
                        new Fenetre("Modèle de table - Classe Colonne", 
                                    listeLignes, 
                                    listeColonnes);
                }
            }
        );
    }

// -------------------------------------------------------------------------- 
// Creation de la liste des lignes a afficher dans la JTable
// -------------------------------------------------------------------------- 
// Remarque : listeLignes est un vecteur de vecteurs...
// -------------------------------------------------------------------------- 
    public static Vector<Vector<Object>> creeListeLignes()
    {
        Vector<Vector<Object>> listeLignes = new Vector<Vector<Object>>();
        Vector<Object> donneesLigne;

        donneesLigne = new Vector<Object>();
        donneesLigne.addElement(new Integer(100));
        donneesLigne.addElement("AIGLE");
        donneesLigne.addElement("Rue des coucous");
        donneesLigne.addElement("94000");
        donneesLigne.addElement("CRETEIL");
        donneesLigne.addElement(new Integer(1));

        listeLignes.addElement(donneesLigne);

        donneesLigne = new Vector<Object>();
        donneesLigne.addElement(new Integer(101));
        donneesLigne.addElement("VAUTOUR");
        donneesLigne.addElement("Avenue du Verdier");
        donneesLigne.addElement("94100");
        donneesLigne.addElement("SAINT MAUR");
        donneesLigne.addElement(new Integer(3));

        listeLignes.addElement(donneesLigne);

        donneesLigne = new Vector<Object>();
        donneesLigne.addElement(new Integer(103));
        donneesLigne.addElement("MERLE");
        donneesLigne.addElement("Rue Aristide Bruant");
        donneesLigne.addElement("92120");
        donneesLigne.addElement("VANVES");
        donneesLigne.addElement(new Integer(3));

        listeLignes.addElement(donneesLigne);

        return listeLignes;
    }

// -------------------------------------------------------------------------- 
// Creation de la liste des colonnes a afficher dans la JTable
// -------------------------------------------------------------------------- 
    public static Vector<Colonne> creeListeColonnes()
    {
        Vector<Colonne> listeColonnes = new Vector<Colonne>();

// --------------------------------------------------------------------------
// Creation du vecteur des colonnes
// --------------------------------------------------------------------------
        listeColonnes.add(
            new Colonne("NUMERO", new Integer(5), "java.lang.Integer"));

        listeColonnes.add(
            new Colonne("NOM", new Integer(20), "java.lang.String"));

        listeColonnes.add(
            new Colonne("ADRESSE", new Integer(50), "java.lang.String"));

        listeColonnes.add(
            new Colonne("CODE_POSTAL", new Integer(12), "java.lang.String"));

        listeColonnes.add(
            new Colonne("VILLE", new Integer(20), "java.lang.String"));

        listeColonnes.add(
            new Colonne("CODE_SECTEUR", new Integer(1), "java.lang.Integer"));

        return listeColonnes;
    }
}
