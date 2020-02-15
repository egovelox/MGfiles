// ==========================================================================
// APPLICATION TestLapin : CONSTRUCTEUR PRIVE
// ==========================================================================

public class TestLapin
{
    public static void main(String argv[])
    {
        Lapin lapin;

// --------------------------------------------------------------------------
// Creation des Lapins jusqu'au nombre maximum.
// --------------------------------------------------------------------------
        do
        {
            lapin = Lapin.creerLapin();
        }
        while (lapin != null);

        System.out.println("\n\nVoila... Ca suffit comme ca !\n");
    }
}