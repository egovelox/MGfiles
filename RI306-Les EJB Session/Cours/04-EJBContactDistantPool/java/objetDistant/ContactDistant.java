package objetDistant;

import daoJdbcMapping.ContactDAO;
import java.sql.SQLException;
import java.util.Hashtable;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import metierMapping.*;
import utilitairesMG.jdbc.AccesBase;
import utilitairesMG.jdbc.BaseDeDonnees;

@Stateless
public class ContactDistant implements ContactDistantRemote
{
    private BaseDeDonnees base;
    private DataSource ds;

// ----------------------------------------------------------------------------
// Chargement de l'EJB : ouverture de la connexion a la base
// ----------------------------------------------------------------------------
    @PostConstruct
    public void ouvreBase()
    {
        base = new BaseDeDonnees();

        try
        {
            Hashtable variablesEnv = new Hashtable();
            variablesEnv.put("org.omg.CORBA.ORBInitialHost", "localhost");
            variablesEnv.put("org.omg.CORBA.ORBInitialPort", "3700");
            Context ctx = new InitialContext(variablesEnv);
            ds = (DataSource) ctx.lookup("jndiPoolGnmiMySql");
        }
        catch (NamingException e)
        {
            System.out.println(e.getMessage());
        }
    }

// ----------------------------------------------------------------------------
// Implementation de la methode de l'interface
// ----------------------------------------------------------------------------
    public Contact lireContact(Integer numeroContact) throws SQLException
    {
        Contact contact;
        AccesBase accesBase;
        ContactDAO contactDAO;

        accesBase = new AccesBase(base);
        contactDAO = new ContactDAO(accesBase);

        accesBase.setConnection(ds.getConnection());

        try
        {
            contact = new Contact();
            contact.setNumero(numeroContact);
            contactDAO.lire(contact);
        }
        finally
        {
            accesBase.closeConnection();
        }
        return contact;
    }
}
