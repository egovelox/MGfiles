// ==========================================================================
// APPLICATION TestStringStringBuffer
// --------------------------------------------------------------------------
// Essais sur les classes String et StringBuffer
// ==========================================================================

public class TestStringStringBuffer
{
    public static void main(String argv[])
    {

// --------------------------------------------------------------------------
// String
// --------------------------------------------------------------------------
        System.out.println("String :");
        
        String s = "Hirondelle";
        System.out.println(Integer.toHexString(s.hashCode()) + " " + s);
        s = s + " de cheminée";
        System.out.println(Integer.toHexString(s.hashCode()) + " " + s);

// --------------------------------------------------------------------------
// StringBuffer
// --------------------------------------------------------------------------
        System.out.println("\nStringBuffer :");

        StringBuffer sb = new StringBuffer("Hirondelle");
        System.out.println(Integer.toHexString(sb.hashCode()) + " " + sb);
        sb.append("  de cheminée");
        System.out.println(Integer.toHexString(sb.hashCode()) + " " + sb);
    }
}