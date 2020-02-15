// ==========================================================================
// Classe Fenetre                           
// --------------------------------------------------------------------------
// Visualisation des threads de l'application.
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements WindowListener
{
    public Fenetre(String titre)
    {
        super(titre);
        System.out.println("Fenetre() : " + Thread.currentThread().getName());

        setBounds(100, 100, 300, 300);

        addWindowListener(this);
        setVisible(true);
    }

// --------------------------------------------------------------------------
// Methodes de Windowlistener
// --------------------------------------------------------------------------
    public void windowClosing(WindowEvent e)
    {
        System.out.println("windowClosing() : " + 
            Thread.currentThread().getName());
        System.exit(0);
    }

    public void windowActivated(WindowEvent e)
    {
    }

    public void windowClosed(WindowEvent e)
    {
    }

    public void windowDeactivated(WindowEvent e)
    {
    }

    public void windowDeiconified(WindowEvent e)
    {
    }

    public void windowIconified(WindowEvent e)
    {
    }

    public void windowOpened(WindowEvent e)
    {
    }
}
