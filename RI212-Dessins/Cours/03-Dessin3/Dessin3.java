// ==========================================================================
// Classe Dessin3                                         Application Dessin3
// -------------------------------------------------------------------------- 
// Dessins dynamiques dans un panneau. Trace des clics dans la fenetre.
// ==========================================================================

public class Dessin3
{
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable() 
            {
                public void run() 
                {
                    Fenetre fenetre = new Fenetre("Trace de clics - Version 1");
                }
            }
        );
    }
}
