// ==========================================================================
// Saisie1 : saisie au clavier
// --------------------------------------------------------------------------
// Ce programme montre l'utilisation directe de la methode read() de
// l'objet System.in. Cette methode est definie dans la classe abstraite
// InputStream et surchargée dans la classe BufferedInputStream.
// ==========================================================================

import java.io.*;

public class Saisie1
{
    public static void main(String args[]) throws IOException
    {
        int codeRetour;

// --------------------------------------------------------------------------
// La methode read() retourne l'octet lu, mais le stocke dans un int.
// --------------------------------------------------------------------------
        System.out.print("Saisir un caractere (puis entrée) : ");
        codeRetour = System.in.read();
        System.out.println("Octet lu (en hexadécimal) : " + 
                Integer.toHexString(codeRetour));
    }
}