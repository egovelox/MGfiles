// ==========================================================================
// Classe Dessin2                                         Application Dessin2
// -------------------------------------------------------------------------- 
// Affichage d'un panneau (JPanel).
// Dessins dynamiques dans ce panneau. Appel de repaint().
// ==========================================================================

public class Dessin2
{
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable() 
            {
                public void run() 
                {
                    Fenetre fenetre = new Fenetre("Appel de repaint");
                }
            }
        );
    }
}
