package objetDistant;

import java.sql.SQLException;
import java.util.Vector;
import javax.ejb.Remote;
import metierMapping.*;

@Remote
public interface MappingRemote
{

// ----------------------------------------------------------------------------
// Chercher un contact (lire) : retourne le contact "numero" ou une SQLException
// ----------------------------------------------------------------------------
    public Contact lireContact(Integer numero)  throws SQLException;

// ----------------------------------------------------------------------------
// Liste de tous les contacts ou SQLException
// ----------------------------------------------------------------------------
// Le Vector<Vector> retourne contient deux Vector :
// . Le premier (poste 0) contient le Vector<Contact> de tous les contacts
// . Le deuxieme (poste 1) contient le Vector<Colonne> des colonnes de la table
//   des contacts.
// ----------------------------------------------------------------------------
    public Vector<Vector> lireListeContacts() throws SQLException;

// ----------------------------------------------------------------------------
// Modification d'un contact.
// ----------------------------------------------------------------------------
// Retourne 1 si la modification est reussie, 0 si incident (le contact
// n'existe pas) ou une SQLException
// ----------------------------------------------------------------------------
    public int modifierContact(Contact contact) throws SQLException;

// ----------------------------------------------------------------------------
// Liste de tous les secteurs ou SQLException
// ----------------------------------------------------------------------------
// Le Vector<Vector> retourne contient deux Vector :
// . Le premier (poste 0) contient le Vector<Secteur> de tous les secteurs
// . Le deuxieme (poste 1) contient le Vector<Colonne> des colonnes de la table
//   des secteurs.
// ----------------------------------------------------------------------------
    public Vector<Vector> lireListeSecteurs() throws SQLException;

}