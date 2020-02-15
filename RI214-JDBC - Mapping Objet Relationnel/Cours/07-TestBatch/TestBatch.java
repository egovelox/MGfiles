// ==========================================================================
// APPLICATION TestBatch
// --------------------------------------------------------------------------
// Cette application reprend TestInsert mais en utilisant executeBatch qui
// permet de lancer plusieurs requetes en meme temps (plus rapide)
// ==========================================================================

import java.sql.*;
import java.io.*;
import utilitairesMG.jdbc.*;

public class TestBatch
{
    public static void main(String args[]) throws IOException
    {
        String requeteSQL;
        BaseDeDonnees base;
        AccesBase accesBase;
        Connection connexion;
        Statement traitement;
        int[] codesRetour;
        int i;

// --------------------------------------------------------------------------
// Chargement du pilote qui assure la connexion a la base de donnees.
// La methode forName "charge la classe" SQLServerDriver du package
// com.microsoft.sqlserver.jdbc.
// --------------------------------------------------------------------------
// Erreur possible : ClassNotFoundException
// --------------------------------------------------------------------------
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

// --------------------------------------------------------------------------
// Base(s) de donnees utilisee(s)
// --------------------------------------------------------------------------
            base = new BaseDeDonnees(
                "jdbc:mysql://localhost/gnmi?user=util_bip&password=x");
            accesBase = new AccesBase(base);

// --------------------------------------------------------------------------
// Etablir une connection a la base
// --------------------------------------------------------------------------
            try
            {
                connexion = accesBase.getConnection();

// --------------------------------------------------------------------------
// Creation d'un objet Statement pour y ajouter les requetes
// --------------------------------------------------------------------------
                try
                {
                    traitement = connexion.createStatement();

// --------------------------------------------------------------------------
// Execution des requetes
// --------------------------------------------------------------------------
                    try
                    {
                        requeteSQL = "DELETE FROM EMPLOYE";
                        traitement.addBatch(requeteSQL);
                        System.out.println(requeteSQL + " ajoutee...");

                        requeteSQL = "INSERT INTO EMPLOYE VALUES"
                            + "(1, 'Balbuzard Pêcheur', NULL, '2016-04-25')";
                        traitement.addBatch(requeteSQL);
                        System.out.println(requeteSQL + " ajoutee...");

                        requeteSQL = "INSERT INTO EMPLOYE VALUES"
                            + "(10, 'Vautour Fauve', 1811, '2016-11-5')";
                        traitement.addBatch(requeteSQL);
                        System.out.println(requeteSQL + " ajoutee...");

                        requeteSQL = "INSERT INTO EMPLOYE VALUES"
                            + "(17, 'Faucon pélerin', 800, '2016-10-15')";
                        traitement.addBatch(requeteSQL);
                        System.out.println(requeteSQL + " ajoutee...");

                        codesRetour = traitement.executeBatch();

                        System.out.println("\nTableau des codes retour :");

                        for (i = 0; i < codesRetour.length; i++)
                        {
                            System.out.println("codesRetour[" + i + "] = " 
                                + codesRetour[i]);
                        }
                    }
                    catch (SQLException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    finally
                    {
                        traitement.close();
                    }
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
                System.out.println(e.getMessage());
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
