// ==========================================================================
// Classe Dessin                                           Application Dessin
// -------------------------------------------------------------------------- 
// Dessins dynamiques dans un panneau. Trace des clics dans le fenetre.
// Le "dessin" est rendu permanent. Le nombre de clics est illimite...
// ==========================================================================

public class Dessin
{
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable() 
            {
                public void run() 
                {
                    Fenetre fenetre = new Fenetre("Trace de clics permanents");
                }
            }
        );
    }
}