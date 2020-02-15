// ==========================================================================
// Classe Controle2                                     Application Controle2
// ==========================================================================

public class Controle2
{
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable() 
            {
                public void run() 
                {
                    Fenetre fenetre = new Fenetre("Controle2");
                }
            }
        );
    }
}
