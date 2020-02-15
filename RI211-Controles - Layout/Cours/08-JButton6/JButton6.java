// ==========================================================================
// Classe JButton6                                       Application JButton6
// -------------------------------------------------------------------------- 
// Dynamique des composants et scrolling : validate() et revalidate()
// ==========================================================================

public class JButton6
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
                        new Fenetre("JButton6 : validate() et revalidate()");
                }
            }
        );
    }
}
