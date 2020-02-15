// ==========================================================================
// Classe Point                                        Application TestPoint2
// ==========================================================================

public class Point
{
    private int x;
    private int y;

    public void afficheXY()
    {
      System.out.println("x = " + x + ", y = " + y);
    }

    public void modifieXY(int x, int y)
    {
       this.x = x;
       this.y = y;
    }
}
