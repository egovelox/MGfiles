// ==========================================================================
// Classe JButton3                                       Application JButton3
// --------------------------------------------------------------------------
// La fenetre possede 1 bouton (ajout).
// Quand on actionne le bouton ajout, cela cree un nouveau bouton.
// Quand on actionne un nouveau bouton, il disparait.
// ==========================================================================

public class JButton3
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
                        new Fenetre("JButton3 : Boutons Dynamiques");
                }
            }
        );
    }
}
