// ==========================================================================
// Classe Fenetre5Threads                      
// --------------------------------------------------------------------------
// Visualisation des threads de l'application.
// ==========================================================================

public class Fenetre5Threads
{

// -------------------------------------------------------------------------- 
// Creation et visualisation de la fenetre : appel direct du constructeur de
// la fenetre.
// -------------------------------------------------------------------------- 
// La methode main() demarre dans le thread principal : main
// Le new et donc le constructeur de la classe Fenetre s'execute dans ce 
// thread (main). Mais le thread qui gere les evenements sur les composants 
// Swing est l'EDT : AWT-EventQueue-0. 
// -------------------------------------------------------------------------- 
    public static void main(String args[])
    {
        System.out.println("main() : " + Thread.currentThread().getName());
        Fenetre maFenetre = new Fenetre("Fenetre5Threads");
    }
}
