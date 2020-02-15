// ==========================================================================
// Classe Lapin :
// ==========================================================================
public class Lapin
{

// --------------------------------------------------------------------------
// Proprietes :
// --------------------------------------------------------------------------
// nombre : nombre de lapins crees
// nombremaxi : nombre maximum de lapins de l'elevage
// --------------------------------------------------------------------------
    private static int nombre = 0;
    private static int nombremaxi = 5;

// --------------------------------------------------------------------------
// Methodes : Constructeur (incrementation du nombre de Lapins)
// --------------------------------------------------------------------------
    private Lapin()
    {
        nombre++;
    }

// --------------------------------------------------------------------------
// creerLapin
// --------------------------------------------------------------------------
// static : pour etre appelee avant toute instanciation d'objet Lapin
// Retourne un objet Lapin ou la référence null
// --------------------------------------------------------------------------
    public static Lapin creerLapin()
    {
        Lapin lapin;

        if (nombre < nombremaxi)
        {
            lapin = new Lapin();
            System.out.println("Nombre de lapins crees : " + nombre);
        }
        else
        {
            System.out.println("Lapin non cree, il y en a deja " + nombremaxi);
            lapin = null;
        }
        return lapin;
    }
}