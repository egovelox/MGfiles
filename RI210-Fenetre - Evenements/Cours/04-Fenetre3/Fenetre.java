// ==========================================================================
// Classe Fenetre                                        Application Fenetre3
// --------------------------------------------------------------------------
// Classe Fenetre heritee de JFrame
// ==========================================================================

import javax.swing.*;

public class Fenetre extends JFrame
{
    public Fenetre(String titre)
    {
        super(titre);
        prepareFenetre();
    }
    
    private void prepareFenetre()
    {
        setBounds(400, 400, 300, 200);
    }
}
