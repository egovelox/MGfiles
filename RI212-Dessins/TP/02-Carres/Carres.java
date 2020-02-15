// ==========================================================================
// APPLICATION Carres :
// --------------------------------------------------------------------------
// Ecran avec composants graphiques, vecteurs de dessins
// ==========================================================================

public class Carres
{
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable() 
            {
                public void run() 
                {
                    Fenetre fenetre = new Fenetre("Les petits carrés");
                }
            }
        );
    }
}