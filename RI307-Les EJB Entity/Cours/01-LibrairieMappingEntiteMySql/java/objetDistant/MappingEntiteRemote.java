package objetDistant;

import java.util.Vector;
import javax.ejb.Remote;
import tables.*;
import utilitairesMG.divers.Colonne;

@Remote
public interface MappingEntiteRemote
{
    public Contact lireContact(Integer numero);
    public Contact rafraichirContact(Integer numero);
    public int creerContact(Contact contact);
    public int modifierContact(Contact contact);
    public int detruireContact(Contact contact);
    
    public Vector<Contact> lireListeContacts();
    public Vector<Contact> lireListeContactsParNom(String extraitNom);
    public Vector<Versement> lireListeVersementsContact(Contact contact);
    public Vector<Colonne> lireListeColonnes(String nomTable);

    public Secteur lireSecteur(Integer code);
    public Secteur rafraichirSecteur(Integer code);
    public Vector<Secteur> lireListeSecteurs();
}
