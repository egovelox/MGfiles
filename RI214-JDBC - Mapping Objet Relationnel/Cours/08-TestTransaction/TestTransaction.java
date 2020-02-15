// ==========================================================================
// APPLICATION TestTransaction
// --------------------------------------------------------------------------
// Transaction - commit - rollback
// ==========================================================================

import java.sql.*;
import java.io.*;
import utilitairesMG.jdbc.*;

public class TestTransaction
{
    public static void main(String args[]) throws IOException
    {
        int codeRetour;
        String requeteSQL;
        BaseDeDonnees base;
        AccesBase accesBase;
        Connection connexion;

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

                try
                {
                    connexion.setAutoCommit(false);

// --------------------------------------------------------------------------
// Execution des requetes
// --------------------------------------------------------------------------
                    try
                    {
                        requeteSQL = "UPDATE EMPLOYE SET EMPSAL = EMPSAL * 1.1";
                        codeRetour = accesBase.executeUpdate(requeteSQL);

                        requeteSQL = "DELETE FROM EMPLOYE WHERE EMPNUM = 17";
                        codeRetour = accesBase.executeUpdate(requeteSQL);

                        requeteSQL = "INSERT INTO EMPLOYE VALUES"
                            + "(17, 'Faucon pélerin', 800, '2016/10/16')";
                        codeRetour = accesBase.executeUpdate(requeteSQL);

                        connexion.commit();
                    }
                    catch (SQLException e)
                    {
                        System.out.println(e.getMessage());
                        connexion.rollback();
                    }
                }
                catch (SQLException e)
                {
                    System.out.println("Erreur setAutoCommit().");
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
