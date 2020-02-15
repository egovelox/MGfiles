// ==========================================================================
// Classe Figure : figures geometriques
// --------------------------------------------------------------------------
// Figure implemente l'interface Comparable
// La methode compareTo prend un parametre de type Object. 
// ==========================================================================

public abstract class Figure implements Comparable
{
    public int compareTo(Object o)
    {
        return surface().compareTo(((Figure)o).surface());
    }
// --------------------------------------------------------------------------
// Methode abstraite surface (permet de compiler Figure). Elle sera 
// surchargee dans les classes derivees
// --------------------------------------------------------------------------

    public abstract Float surface();
}
