// ==========================================================================
// Classe Fenetre5Invoke                          
// --------------------------------------------------------------------------
// Visualisation des threads de l'application.
// ==========================================================================

public class Fenetre5Invoke
{

// -------------------------------------------------------------------------- 
// Creation et visualisation de la fenetre.
// -------------------------------------------------------------------------- 
// La creation est invoquee dans le thread de gestion des evenements, ce qui 
// est fait grace a l'appel de la methode invokeLater.
// -------------------------------------------------------------------------- 
// C'est necessaire car les composants de SWING ne sont pas "thread-safe".
// -------------------------------------------------------------------------- 
    public static void main(String args[])
    {
        System.out.println("main() : " + Thread.currentThread().getName());
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Fenetre fenetre = new Fenetre("Fenetre5Invoke");
            }
        }
        );
    }
}
