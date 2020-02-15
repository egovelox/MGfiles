// ==========================================================================
// APPLICATION TestJdbcUtil
// --------------------------------------------------------------------------
// Cet exemple reprend l'exemple TestJdbcSql avec utilisation des classes
// utilitaires de utilitairesMG...
// ==========================================================================

import java.sql.*;
import java.io.*;
import utilitairesMG.jdbc.*;

public class TestJdbcUtil
{

    public static void main(String args[]) throws IOException
    {

// ==========================================================================
// DECLARATIONS
// ==========================================================================
        BaseDeDonnees base;
        AccesBase accesBase;
        JeuResultat resultats;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

// --------------------------------------------------------------------------
// Base de donnees utilisee et objet d'acces à cette base.
// --------------------------------------------------------------------------
            base = new BaseDeDonnees(
                "jdbc:mysql://localhost/gnmi?user=util_bip&password=x");
            accesBase = new AccesBase(base);

// --------------------------------------------------------------------------
// Etablir une connection a la base
// --------------------------------------------------------------------------
            try
            {
                accesBase.getConnection();

// --------------------------------------------------------------------------
// Exécution de la requete
// --------------------------------------------------------------------------
                try
                {
                    resultats = accesBase.executeQuery(
                        "SELECT * FROM CONTACT WHERE NOM LIKE '%V%'");

// --------------------------------------------------------------------------
// Liste des colonnes
// --------------------------------------------------------------------------
                    System.out.println("Liste des colonnes :\n");
                    System.out.println(resultats.getColonnes());

// --------------------------------------------------------------------------
// Liste des lignes
// --------------------------------------------------------------------------
                    System.out.println("\n\nListe des lignes :\n");
                    System.out.println(resultats.getLignes());
                }
                catch (SQLException e)
                {
                    System.out.println(e.getMessage());
                }
                finally
                {
                    accesBase.closeConnection();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Connexion impossible " + e.getMessage());
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Echec du chargement du pilote " + e.getMessage());
        }
    }
}