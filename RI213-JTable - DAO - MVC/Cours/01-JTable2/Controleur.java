// ==========================================================================
// Classe Controleur                                      Application JTable2
// -------------------------------------------------------------------------- 
// JTable cree avec deux Vector
// ==========================================================================

import java.util.*;
import utilitairesMG.graphique.*;

public class Controleur
{

// -------------------------------------------------------------------------- 
// Programme principal de l'application
// -------------------------------------------------------------------------- 
    public static void main(String args[])
    {
        Vector<Vector<Object>> listeLignes;
        Vector<String> listeColonnes;

// -------------------------------------------------------------------------- 
// Creation des vecteurs des donnees a afficher.
// -------------------------------------------------------------------------- 
        listeLignes = creeListeLignes();
        listeColonnes = creeListeColonnes();

// -------------------------------------------------------------------------- 
// Affichage de la fenetre.
// -------------------------------------------------------------------------- 
        javax.swing.SwingUtilities.invokeLater(
            new Runnable()
            {
                public void run()
                {
                    LF.setLF();
                    Fenetre fenetre =  
                        new Fenetre("JTable par défaut", 
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
    public static Vector<String> creeListeColonnes()
    {
        Vector<String> listeColonnes = new Vector<String>();

        listeColonnes.addElement("NUMERO");
        listeColonnes.addElement("NOM");
        listeColonnes.addElement("ADRESSE");
        listeColonnes.addElement("CODE_POSTAL");
        listeColonnes.addElement("VILLE");
        listeColonnes.addElement("CODE_SECTEUR");

        return listeColonnes;
    }
}
