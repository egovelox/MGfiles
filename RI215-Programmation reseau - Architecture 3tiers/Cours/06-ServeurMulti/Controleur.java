// ==========================================================================
// Projet serveurMulti : serveur multiThreads (echo)
// --------------------------------------------------------------------------
// Controleur : programme principal de lancement du serveur.
// ==========================================================================
import java.io.*;
import utilitairesMG.divers.*;

public class Controleur
{
    public static void main(String[] argv) throws IOException
    {
        ServeurMulti serveur;

// --------------------------------------------------------------------------
// Instanciation et demarrage du thread serveur.
// --------------------------------------------------------------------------
        serveur = new ServeurMulti();
        serveur.start();
        System.out.println("Le serveur a demarre...");

        System.out.println("Tapez Entree pour l'arreter...");
        Clavier.readString();

// --------------------------------------------------------------------------
// L'execution de la methode interrupt envoie un signal au Thread serveur.
// La methode interrupted() de celui-ci renvoie alors la valeur true.
// --------------------------------------------------------------------------
        serveur.interrupt();

// --------------------------------------------------------------------------
// Le Thread main se termine ici. Toutefois, tant que tous les Threads client
// crees par le serveur tournent, l'application continue de tourner (la
// Clavier reste ouverte). Quand tous les Threads sont arretes, la Clavier
// se ferme.
// --------------------------------------------------------------------------
        System.out.println("Le serveur est arrete...");
    }
}
