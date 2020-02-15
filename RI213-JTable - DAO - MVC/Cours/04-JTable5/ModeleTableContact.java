// ==========================================================================
// Classe ModeleTableContact                              Application JTable4
// -------------------------------------------------------------------------- 
// Modele de table constitue a partir d'un vecteur de contacts.
// ==========================================================================

import java.util.*;
import utilitairesMG.divers.*;

public class ModeleTableContact extends ModeleTable
{

// -------------------------------------------------------------------------- 
// CONSTRUCTEUR
// -------------------------------------------------------------------------- 
// On transforme la liste d'objets 'Contact' en  lignes (Vector<Object>) pour
// alimenter le ModeleTable
// -------------------------------------------------------------------------- 
    public ModeleTableContact(Vector<Contact> listeContacts,
                              Vector<Colonne> listeColonnes)
    {
        Vector<Vector<Object>> listeLignes = new Vector<Vector<Object>>();

        for (int i = 0; i < listeContacts.size(); i++)
        {
            Vector<Object> ligne = new Vector<Object>();
            Contact c = listeContacts.elementAt(i);

            ligne.addElement(c.getNumero());
            ligne.addElement(c.getNom());
            ligne.addElement(c.getAdresse());
            ligne.addElement(c.getCodePostal());
            ligne.addElement(c.getVille());
            ligne.addElement(c.getCodeSecteur());

            listeLignes.addElement(ligne);
        }

        setListeLignes(listeLignes);
        setListeColonnes(listeColonnes);
    }
}
