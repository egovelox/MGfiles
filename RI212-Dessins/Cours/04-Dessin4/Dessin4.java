// ==========================================================================
// Classe Dessin4                                         Application Dessin4
// -------------------------------------------------------------------------- 
// Meme programme que Dessin3.java, mais avec l'ecouteur de MouseEvent est
// la classe Panneau.
// ==========================================================================

public class Dessin4
{
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable() 
            {
                public void run() 
                {
                    Fenetre fenetre = new Fenetre("Trace de clics - Version 2");
                }
            }
        );
    }
}
