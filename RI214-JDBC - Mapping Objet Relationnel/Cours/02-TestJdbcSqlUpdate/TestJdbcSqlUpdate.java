// ==========================================================================
// APPLICATION TestJdbcSqlUpdate
// --------------------------------------------------------------------------
// Chargement du driver MySQL
// Connexion a une base de donnees.
// Creation d'un objet Statement pour executer des traitements SQL.
// Execution d'un UPDATE SQL.
// Affichage du nombre de lignes modifiees.
// --------------------------------------------------------------------------
// Ce programme comporte des blocs try...catch imbriques pour une ecriture
// correctement structuree
// ==========================================================================

import java.sql.*;
import java.io.*;

public class TestJdbcSqlUpdate
{
    public static void main(String args[]) throws IOException
    {

// ==========================================================================
// DECLARATIONS
// ==========================================================================
        Connection connexion;
        Statement traitement;
        Integer nombreLignes;

// --------------------------------------------------------------------------
// Chargement du pilote qui assure la connexion a la base de donnees.
// --------------------------------------------------------------------------
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

// --------------------------------------------------------------------------
// Etablir la connexion
// --------------------------------------------------------------------------
            try
            {
                connexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/gnmi?user=util_bip&password=x");

// --------------------------------------------------------------------------
// Creation de l'objet Statement :
// --------------------------------------------------------------------------
                try
                {
                    traitement = connexion.createStatement();

// --------------------------------------------------------------------------
// Execution de la requete, grace a l'objet Statement :
// --------------------------------------------------------------------------
// Erreur possible : SQLException
// --------------------------------------------------------------------------
                    try
                    {
                        nombreLignes = traitement.executeUpdate(
                            "UPDATE VERSEMENT SET MONTANT = MONTANT * 1.1");
                        System.out.println("Nombre de lignes modifiées : "
                            + nombreLignes);

                    }
                    catch (SQLException e)
                    {
                        System.out.println("Requete incorrecte.");
                        System.out.println(e.getMessage());
                    }
                    finally
                    {
                        traitement.close();
                    }
                }
                catch (SQLException e)
                {
                    System.out.println("Creation Statement incorrecte.");
                    System.out.println(e.getMessage());
                }
                finally
                {
                    connexion.close();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Connexion impossible.");
                System.out.println(e.getMessage());
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Echec du chargement du pilote SQLServer.");
            System.out.println(e.getMessage());
        }
    }
}
