// ==========================================================================
// Projet serveurMulti : serveur multiThreads (echo)
// --------------------------------------------------------------------------
// ServeurMulti : Serveur (thread maitre de l'application).
// ==========================================================================

import java.net.*;
import java.io.*;

public class ServeurMulti extends Thread
{
    public void run()
    {

// --------------------------------------------------------------------------
// socketServeur : reference d'une socket du serveur vers le client
// threadClient : thread de traitement du client
// --------------------------------------------------------------------------
        ServerSocket serveur;
        boolean actif;
        Socket socketServeur;
        Thread threadClient;

        try
        {
            serveur = new ServerSocket(8189);
            try
            {
                serveur.setSoTimeout(10);
                actif = true;

// --------------------------------------------------------------------------
// Le serveur sera actif jusqu'a ce que le programme Principal envoie un
// ordre d'interruption (interrupt()). Dans ce cas, la methode interrupted()
// renvoie true. Le programme ne fonctionne que parce qu'on a limite le
// temps d'attente du accept() par la methode setSoTimeout(1000) dans le
// constructeur. Sinon, le programme attend indefiniment qu'un client se
// connecte...
// --------------------------------------------------------------------------
                while (actif)
                {
                    try
                    {
                        socketServeur = serveur.accept();

                        threadClient = new ThreadClient(socketServeur);
                        threadClient.start();
                    }
                    catch (SocketTimeoutException e)
                    {
                        if (interrupted())
                        {
                            actif = false;
                        }
                    }
                }
            }
            finally
            {
                serveur.close();
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}