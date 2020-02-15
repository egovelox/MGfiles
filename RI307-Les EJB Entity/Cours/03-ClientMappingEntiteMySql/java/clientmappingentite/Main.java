package clientmappingentite;

import java.util.Hashtable;
import java.util.Vector;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import objetDistant.MappingEntiteRemote;
import tables.*;

public class Main
{
    public static void main(String[] args) throws NamingException
    {
        Contact contact;

        Hashtable variablesEnv = new Hashtable();
        variablesEnv.put("org.omg.CORBA.ORBInitialHost", "localhost");
        variablesEnv.put("org.omg.CORBA.ORBInitialPort", "3700");

        Context ctx = new InitialContext(variablesEnv);
        MappingEntiteRemote baseMapping =
            (MappingEntiteRemote) ctx.lookup("jndiMappingEntiteMySql");

/*        contact = baseMapping.lireContact(100);

        if (contact != null)
        {
            System.out.println(contact.getNom());
            Vector<Versement> listeVersements =
                    baseMapping.lireListeVersementsContact(contact);

            System.out.println(
                "Liste des versements du contact " + contact.getNom());
            for(int i = 0; i < listeVersements.size(); i++)
            {
                System.out.println(listeVersements.get(i).getMontant()); 
            }
        }
        else
        {
            System.out.println("Contact inconnu");
        }
*/
// ----------------------------------------------------------------------------
// Creation d'un nouveau contact
// ----------------------------------------------------------------------------
/*
        contact = new Contact();
        contact.setNumero(333);

        contact.setNom("FAUCôN");
        contact.setVille("CRETEIL");
        contact.setAdresse("15, avenue du chat huant");
        contact.setCodePostal("75010");

        int retour = baseMapping.creerContact(contact);
        System.out.println("retour creer(1) = " + retour); 
*/

// ----------------------------------------------------------------------------
// Quelques listes
// ----------------------------------------------------------------------------
/*        System.out.println("\n\nListe des colonnes de la table CONTACT : ");
        System.out.println(baseMapping.lireListeColonnes("tables.Contact"));
*/        
/*        System.out.println("\n\nListe des contacts : ");
        Vector<Contact> listeContacts = baseMapping.lireListeContacts();
        for(int i = 0; i < listeContacts.size(); i++)
        {
            System.out.println(listeContacts.get(i).getNom());
        } */
        System.out.println(
            "\nListe des contacts dont le nom contient la lettre U : ");
        Vector<Contact> listeContacts = baseMapping.lireListeContactsParNom("U");
        for(int i = 0; i < listeContacts.size(); i++)
        {
            System.out.println(listeContacts.get(i).getNom());
        }
/*
        System.out.println("\n\nListe des colonnes de la table VERSEMENT : ");
        System.out.println(baseMapping.lireListeColonnes("tables.Versement")); */
    }
}
