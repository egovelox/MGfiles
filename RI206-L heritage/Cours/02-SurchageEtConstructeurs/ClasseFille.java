// ==========================================================================
// Classe ClasseFille
// ==========================================================================

public class ClasseFille extends ClasseMere
{
    private int x;

    public ClasseFille(int x)
    {
        super();
        this.x = x;
    }

    public void initialiser()
    {
        System.out.println("initialiser ClasseFille !");
        System.out.println(x);
    }
}