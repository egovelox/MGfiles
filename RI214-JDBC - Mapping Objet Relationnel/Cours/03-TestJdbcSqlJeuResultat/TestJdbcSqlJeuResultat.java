// ==========================================================================
// APPLICATION TestJdbcSqlJeuResultat
// ==========================================================================

import java.sql.*;
import java.io.*;
import utilitairesMG.jdbc.JeuResultat;

public class TestJdbcSqlJeuResultat
{
    public static void main(String args[]) throws IOException
    {
        Connection connexion;
        Statement traitement;
        ResultSet resultats;
        JeuResultat jeuResultat;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

// --------------------------------------------------------------------------
// Etablir la connexion.
// --------------------------------------------------------------------------
            try
            {
                connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/gnmi?user=util_bip&password=x");

// --------------------------------------------------------------------------
// Creation de l'objet Statement.
// --------------------------------------------------------------------------
                try
                {
                    traitement = connexion.createStatement();

// --------------------------------------------------------------------------
// Execution de la requete.
// --------------------------------------------------------------------------
                    try
                    {
                        resultats = traitement.executeQuery(
                            "SELECT * FROM CONTACT WHERE NOM LIKE '%V%'");
                        try
                        {
                            jeuResultat = new JeuResultat(resultats);

// --------------------------------------------------------------------------
// Affichage des resultats :
// --------------------------------------------------------------------------
                            System.out.println(jeuResultat.getColonnes());
                            System.out.println(jeuResultat.getLignes());
                        }
                        finally
                        {
                            resultats.close();
                        }
                    }
                    catch (SQLException e)
                    {
                        System.out.println("Requete incorrecte.");
                    }
                    finally
                    {
                        traitement.close();
                    }
                }
                catch (SQLException e)
                {
                    System.out.println("Creation Statement incorrecte.");
                }
                finally
                {
                    connexion.close();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Connexion impossible.");
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Echec du chargement du pilote.");
        }
    }
}