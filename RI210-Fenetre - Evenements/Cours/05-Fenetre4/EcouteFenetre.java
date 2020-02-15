// ==========================================================================
// Classe EcouteFenetre        
// --------------------------------------------------------------------------
// Classe EcouteFenetre qui herite de la classe WindowAdapter.
// --------------------------------------------------------------------------
// WindowAdapter est une classe qui implemente l'interface WindowListener.
// Il suffit de redefinir les methodes qui nous interessent. Les autres n'ont 
// aucune action (elles sont definies vides dans WindowAdapter).
// ==========================================================================

import java.awt.event.*;

public class EcouteFenetre extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}