// ==========================================================================
// Classe JButton1                                       Application JButton1
// --------------------------------------------------------------------------
// Fenetre avec 2 BOUTONS, methodes getActionCommand(), getSource()
// ==========================================================================

public class JButton1
{
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable() 
            {
                public void run() 
                {
                    Fenetre fenetre = new Fenetre("JButton1 : 2 boutons");
                }
            }
        );
    }
}
