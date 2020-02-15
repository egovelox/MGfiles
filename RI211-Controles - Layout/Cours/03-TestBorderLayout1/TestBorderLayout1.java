// ==========================================================================
// Classe TestBorderLayout1                     Application TestBorderLayout1
// -------------------------------------------------------------------------- 
// Placement de panneaux dans une fenetre, en utilisant le gestionnaire de
// mise en page BorderLayout.
// ==========================================================================

public class TestBorderLayout1
{
    public static void main(String args[])
    {
        javax.swing.SwingUtilities.invokeLater
        (
            new Runnable() 
            {
                public void run() 
                {
                    Fenetre fenetre = new Fenetre("BorderLayout");
                }
            }
        );
    }
}
