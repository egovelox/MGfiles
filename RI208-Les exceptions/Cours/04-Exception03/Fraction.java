// ========================================================================
// Classe Fraction
// ========================================================================

public class Fraction
{
    private int numerateur;
    private int denominateur;

    public Fraction(int numerateur, int denominateur)
    {
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