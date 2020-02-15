// ========================================================================
// Classe FractionEx07 : classe Fraction pour l'exercice Exception07
// ------------------------------------------------------------------------
// Creation d'un nouveau type d'exception pour empecher l'instanciation
// d'une fraction avec denominateur nul
// ========================================================================

public class Fraction
{
    private int numerateur;
    private int denominateur;

    public Fraction(int numerateur, int denominateur) 
        throws DenominateurNulException
    {
        if (denominateur == 0)
        {
            throw new DenominateurNulException();
        }

        this.numerateur = numerateur;
        this.denominateur = denominateur;
    }

    public int partieEntiere()
    {
        return numerateur / denominateur;
    }

    public String toString()
    {
        if (denominateur != 1)
        {
            return numerateur + " / " + denominateur;
        }
        else
        {
            return "" + numerateur;
        }
    }
}

