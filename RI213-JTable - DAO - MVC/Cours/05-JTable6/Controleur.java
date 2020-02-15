// ==========================================================================
// Classe Controleur                                      Application JTable6
// -------------------------------------------------------------------------- 
// La JTable est remplie avec un vecteur d'objets Contact. Elle utilise un
// modele de table ET un modele de colonne.
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
        Vector<Contact> listeContacts;

// -------------------------------------------------------------------------- 
// Creation des vecteurs des donnees a afficher.
// -------------------------------------------------------------------------- 
        listeContacts = creeListeContacts();
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
                        new Fenetre("JTable éditable", 
                                    listeContacts, 
                                    listeColonnes);
                }
            }
        );
    }

// -------------------------------------------------------------------------- 
// Creation de la liste des Contacts a afficher dans la JTable
// -------------------------------------------------------------------------- 
// Remarque : listeContacts est un vecteur d'objets Contact...
// -------------------------------------------------------------------------- 
    public static Vector<Contact> creeListeContacts()
    {
        Vector<Contact> listeContacts = new Vector<Contact>();
        Contact contact;

        contact = new Contact();
        contact.setNumero(100);
        contact.setNom("AIGLE");
        contact.setAdresse("Rue des coucous");
        contact.setCodePostal("94000");
        contact.setVille("CRETEIL");
        contact.setCodeSecteur(1);

        listeContacts.addElement(contact);

        contact = new Contact();
        contact.setNumero(101);
        contact.setNom("VAUTOUR");
        contact.setAdresse("Avenue du Verdier");
        contact.setCodePostal("94100");
        contact.setVille("SAINT MAUR");
        contact.setCodeSecteur(3);

        listeContacts.addElement(contact);

        contact = new Contact();
        contact.setNumero(112);
        contact.setNom("MERLE");
        contact.setAdresse("Rue Aristide Bruant");
        contact.setCodePostal("92120");
        contact.setVille("VANVES");
        contact.setCodeSecteur(3);

        listeContacts.addElement(contact);

        return listeContacts;
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
        listeColonnes.addElement(
            new Colonne("NUMERO", new Integer(5), "java.lang.Integer"));

        listeColonnes.addElement(
            new Colonne("NOM", new Integer(20), "java.lang.String"));

        listeColonnes.addElement(
            new Colonne("ADRESSE", new Integer(50), "java.lang.String"));

        listeColonnes.addElement(
            new Colonne("CODE_POSTAL", new Integer(12), "java.lang.String"));

        listeColonnes.addElement(
            new Colonne("VILLE", new Integer(20), "java.lang.String"));

        listeColonnes.addElement(
            new Colonne("CODE_SECTEUR", new Integer(1), "java.lang.Integer"));

        return listeColonnes;
    }
}
