// ==========================================================================
// Saisie2 : saisie au clavier
// --------------------------------------------------------------------------
// Ce programme montre l'utilisation des methodes read() heritees de la
// classe abstraite Reader. Un objet de type InputStreamReader (pont
// entre un flux d'octets et un flux de caracteres Unicode) va etre cree.
// Son constructeur a comme parametre System.in, flux d'entree d'octets
// correspondant au clavier.
// ==========================================================================

import java.io.*;

public class Saisie2
{
    public static void main(String args[]) throws IOException
    {
        int codeRetour;

        InputStreamReader entree = new InputStreamReader(System.in);
        System.out.println(entree.getEncoding());

        System.out.print("Saisir un caractere (puis entrée) : ");
        codeRetour = entree.read();
        System.out.println("Octet lu (en hexadécimal) : " + 
                Integer.toHexString(codeRetour));
    }
}
