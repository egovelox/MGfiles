// ==========================================================================
// Classe JButton5                                       Application JButton5
// -------------------------------------------------------------------------- 
// Meme application que JButton4 mais amelioration de la presentation du 
// scrolling en utilisant la classe FlowLayoutMG (utilitairesMG).
// ==========================================================================

public class JButton5
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
                        new Fenetre("JButton5 : Scrolling ameliore");
                }
            }
        );
    }
}
