// ==========================================================================
// APPLICATION TestInsert
// --------------------------------------------------------------------------
// Creation d'un objet Statement - Execution de requetes INSERT
// ==========================================================================

import java.sql.*;
import java.io.*;
import utilitairesMG.jdbc.*;

public class TestInsert
{
    public static void main(String args[]) throws IOException
    {
        int codeRetour;
        String requeteSQL;
        BaseDeDonnees base;
        AccesBase accesBase;

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
                accesBase.getConnection();

// --------------------------------------------------------------------------
// Execution des requetes
// --------------------------------------------------------------------------
                try
                {
                    requeteSQL = "DELETE FROM EMPLOYE";
                    codeRetour = accesBase.executeUpdate(requeteSQL);
                    System.out.println(
                        requeteSQL + "\nCode retour = " + codeRetour);

                    requeteSQL = "INSERT INTO EMPLOYE VALUES"
                        + "(1, 'Balbuzard Pêcheur', NULL, '2016-04-25')";
                    codeRetour = accesBase.executeUpdate(requeteSQL);
                    System.out.println(
                        requeteSQL + "\nCode retour = " + codeRetour);

                    requeteSQL = "INSERT INTO EMPLOYE VALUES"
                        + "(4, 'Moineau Friquet', 2214, NULL)";
                    codeRetour = accesBase.executeUpdate(requeteSQL);
                    System.out.println(
                        requeteSQL + "\nCode retour = " + codeRetour);

                    requeteSQL = "INSERT INTO EMPLOYE VALUES"
                        + "(7, 'Aigle Royal', 1331, '2015-03-24')";
                    codeRetour = accesBase.executeUpdate(requeteSQL);
                    System.out.println(
                        requeteSQL + "\nCode retour = " + codeRetour);
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
