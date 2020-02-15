// ==========================================================================
// APPLICATION TestJdbcSql
// --------------------------------------------------------------------------
// Chargement du driver MySQL
// Connexion a une base de donnees.
// Creation d'un objet Statement pour executer des traitements SQL.
// Execution d'un SELECT SQL.
// Affichage des donnees lues.
// --------------------------------------------------------------------------
// Ce programme comporte des blocs try...catch imbriques pour une ecriture
// correctement structuree
// ==========================================================================

import java.sql.*;
import java.io.*;

public class TestJdbcSql
{
    public static void main(String args[]) throws IOException
    {
        Connection connexion;
        Statement traitement;
        ResultSet resultats;
        ResultSetMetaData colonnes;

        String nomColonne;
        boolean eof;

// --------------------------------------------------------------------------
// Chargement du pilote qui assure la connexion a la base de donnees.
// --------------------------------------------------------------------------
// L'appel de Class.forname indique a la JVM qu'elle doit trouver, charger
// et initialiser la classe passee en parametre. L'initialisation comprend
// l'enregistrement de cette classe aupres du gestionnaire de pilotes. Ce
// gestionnaire est la classe DriverManager (utilisee plus loin...). Il
// conserve une reference de tous les pilotes charges.
// --------------------------------------------------------------------------
// Erreur possible : ClassNotFoundException
// --------------------------------------------------------------------------
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

// --------------------------------------------------------------------------
// Etablir la connexion : si la connexion a la base de donnees reussit, la
// variable connexion recoit la reference d'un objet de type Connection pret
// a executer les methodes de l'interface Connection.
// --------------------------------------------------------------------------
// Erreur possible : SQLException
// --------------------------------------------------------------------------
            try
            {
//                connexion = DriverManager.getConnection(
//                    "jdbc:mysql://localhost/gnmi?user=util_bip&password=x");
                connexion = DriverManager.getConnection(
                    "jdbc:mysql://94010-6101877/gnmi","util_bip", "x");
                //System.out.println(connexion.getClass().getName());

// --------------------------------------------------------------------------
// Creation de l'objet Statement :
// --------------------------------------------------------------------------
// Erreur possible : SQLException
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
                        resultats = traitement.executeQuery(
                            "SELECT * FROM CONTACT WHERE NOM LIKE '%V%'");
                        colonnes = resultats.getMetaData();

// --------------------------------------------------------------------------
// Affichage des resultats :
// --------------------------------------------------------------------------
// Erreur possible : SQLException
// --------------------------------------------------------------------------
                        try
                        {
// --------------------------------------------------------------------------
// Affichage des caracteristiques des colonnes
// --------------------------------------------------------------------------
                            System.out.println("\nListe des colonnes :\n");
                            for (int i = 1; i <= colonnes.getColumnCount(); i++)
                            {
                                System.out.println(
                                    colonnes.getColumnName(i) + "("
                                    + colonnes.getColumnClassName(i)
                                    + ", taille : "
                                    + colonnes.getColumnDisplaySize(i)
                                    +")");
                            }

// --------------------------------------------------------------------------
// Affichage des lignes selectionnees
// --------------------------------------------------------------------------
// Le premier appel de la methode next() permet de se positionner sur la 
// premiere ligne selectionnee, si elle existe. Les appels suivants 
// permettent d'avancer ligne par ligne dans le ResultSet. La methode next()
// retourne false quand il n'y a plus de lignes à lire.
// --------------------------------------------------------------------------
                            System.out.println("\nResultat du Select :");

                            eof = !resultats.next();
                            if (eof)
                            {
                                System.out.println(
                                    "/nAucune ligne selectionnee.");
                            }

                            while (!eof)
                            {
                                System.out.println("");
                                for (int i = 1; 
                                     i <= colonnes.getColumnCount(); 
                                     i++)
                                {
                                    nomColonne = colonnes.getColumnName(i);
// --------------------------------------------------------------------------
// La methode getObject(i) permet le lire la ieme valeur(colonne) de la ligne
// sur laquelle on est positionne.
// --------------------------------------------------------------------------
                                    System.out.println(nomColonne + " = " 
                                        + resultats.getObject(i));
                                }
                                eof = !resultats.next();
                            }
                        }
                        catch (SQLException e)
                        {
                            System.out.println(
                                "Erreur affichage des resultats.");
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