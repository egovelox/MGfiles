// ==========================================================================
// Classe Fenetre5InvokeErreurs         
// --------------------------------------------------------------------------
// Visualisation des threads de l'application.
// ==========================================================================

public class Fenetre5InvokeErreurs
{
    private static Fenetre fenetre;

    public static void main(String args[]) throws InterruptedException
    {
        System.out.println("main() : " + Thread.currentThread().getName());
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                fenetre = new Fenetre("Fenetre6Invoke");
            }
        }
        );

// --------------------------------------------------------------------------
// C'est là qu'est la pagaille ! On appelle des methodes de la fenetre dans 
// le thread main. Sans la temporisation, la Fenetre n'est pas encore 
// instanciee quand le setLayout est appelle. D'ou une exception.
// --------------------------------------------------------------------------
        //Thread.sleep(1000);
        fenetre.setVisible(true);
        System.out.println("setVisible() : " + Thread.currentThread().getName());
    }
}
