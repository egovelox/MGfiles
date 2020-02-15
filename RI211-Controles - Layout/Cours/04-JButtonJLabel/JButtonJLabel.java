// ==========================================================================
// Classe JButtonJLabel                             Application JButtonJLabel
// -------------------------------------------------------------------------- 
// Adaptation de l'application JButton2.
// -------------------------------------------------------------------------- 
// Les affichages lies aux choix des boutons se font dans un JLabel de la
// fenetre.
// ==========================================================================

public class JButtonJLabel
{
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable() 
            {
                public void run() 
                {
                    Fenetre fenetre = new Fenetre("JButtonJLabel");
                }
            }
        );
    }
}
