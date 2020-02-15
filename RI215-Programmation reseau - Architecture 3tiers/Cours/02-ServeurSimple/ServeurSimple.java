// ==========================================================================
// ServeurSimple : lancement d'un serveur qui s'arrete au bout de 10 secondes
// --------------------------------------------------------------------------
// Le client correspondant est ClientSimple
// --------------------------------------------------------------------------
// Ce programme lance le serveur, envoie un message de bienvenue, lit un
// message du client, et s'arrete... Les textes échangés sont codés en UTF-8.
// --------------------------------------------------------------------------
// Si le client ne se connecte pas dans les 10 secondes, le serveur s'arrete
// ==========================================================================

import java.net.*;
import java.io.*;

public class ServeurSimple
{
    public static void main(String argv[])
    {

// --------------------------------------------------------------------------
// serveur       : objet serveur
// socketServeur : reference d'une socket du serveur vers le client
// sortie        : flux vers le client
// entree        : flux en provenance du client
// ligne         : chaine de lecture et d'ecriture dans les flux
// --------------------------------------------------------------------------
        ServerSocket serveur;
        Socket socketServeur;
        PrintWriter sortie;
        BufferedReader entree;
        String ligne;

        try
        {

// --------------------------------------------------------------------------
// Creation et lancement d'un serveur attache au port 8189 de l'ordinateur
// courant.
// --------------------------------------------------------------------------
            serveur = new ServerSocket(8189);

            try
            {

// --------------------------------------------------------------------------
// Parametrage du parametre SO_TIMEOUT qui permet de limiter le temps
// d'attente du serveur. Le serveur va attendre 10 secondes qu'un client se
// connecte... A defaut, il emet une SocketTimeoutException.
// --------------------------------------------------------------------------
                serveur.setSoTimeout(10000);  

                System.out.println("Un client doit se connecter avant "
                    + serveur.getSoTimeout() / 1000 + " secondes.");

// --------------------------------------------------------------------------
// La methode accept() demande au programme d'attendre jusqu'a ce qu'un
// client se connecte. La connexion du client s'accompagne de la creation
// d'un objet Socket qui permet de dialoguer avec lui. La methode accept()
// retourne la reference de cette "Socket".
// --------------------------------------------------------------------------
                socketServeur = serveur.accept();
                try
                {

// --------------------------------------------------------------------------
// Ouverture des flux.
// --------------------------------------------------------------------------
                    sortie = new PrintWriter(
                        new OutputStreamWriter(
                            socketServeur.getOutputStream(), "UTF-8"));

                    entree = new BufferedReader(
                        new InputStreamReader(
                            socketServeur.getInputStream(), "UTF-8"));

// --------------------------------------------------------------------------
// Envoi du message de bienvenue
// --------------------------------------------------------------------------
                    sortie.println("Bienvenue, ch€r client !");
                    sortie.flush();

// --------------------------------------------------------------------------
// Lecture du message du client
// --------------------------------------------------------------------------
                    ligne = entree.readLine();
                    System.out.println(ligne);
                }
                finally
                {
                    socketServeur.close();
                }
            }
            catch (SocketTimeoutException e)
            {
                System.out.println(
                    "Temps d'attente de la connexion client dépassé !");
            }
            finally
            {
                serveur.close();
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
