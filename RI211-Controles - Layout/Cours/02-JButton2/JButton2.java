// ==========================================================================
// Classe JButton2                                       Application JButton2
// --------------------------------------------------------------------------
// Tests sur les tailles par defaut.
// Ajustement de la taille de deux boutons dans un panneau.
// ==========================================================================

public class JButton2
{
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable() 
            {
                public void run() 
                {
                    Fenetre fenetre = 
                        new Fenetre("JButton2 : 2 boutons de meme taille");
                }
            }
        );
    }
}
