// ==========================================================================
// Classe Dessin1                                         Application Dessin1
// -------------------------------------------------------------------------- 
// Affichage d'un panneau (JPanel) jaune. Dessin dans ce panneau.
// Redefinition de la methode paintComponent de la classe JPanel.
// ==========================================================================

public class Dessin1
{
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable() 
            {
                public void run() 
                {
                    Fenetre fenetre = new Fenetre("Panneau Jaune");
                }
            }
        );
    }
}
