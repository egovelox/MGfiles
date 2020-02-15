// ==========================================================================
// Classe ClasseFille
// ==========================================================================

public class ClasseFille implements Formidable, Admirable
{

// --------------------------------------------------------------------------
// Redefinition de la methode de l'interface Formidable
// --------------------------------------------------------------------------
    public void methodeFormidable()
    {
        System.out.println("methodeFormidable()");
    }

// --------------------------------------------------------------------------
// Redefinition des methodes de l'interface Admirable
// --------------------------------------------------------------------------
    public void methodeAdmirable1()
    {
        System.out.println("methodeAdmirable1()");
    }

    public void methodeAdmirable2()
    {
        System.out.println("methodeAdmirable2()");
    }
}