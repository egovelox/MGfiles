/* ========================================================================== */
/* Projet : fichierBinTexte -- Ecriture dans un fichier binaire               */
/*                             Ecriture dans un fichier texte                 */
/* ========================================================================== */


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
                         /* -------------------------------------------------- */
    FILE* binaire;       /* Pointeur vers le fichier binaire                   */
                         /*                                                    */
    FILE* texte;         /* Pointeur vers le fichier texte                     */
                         /*                                                    */
    int i;               /* entier a ecrire sur les deux fichiers              */
                         /* -------------------------------------------------- */

/* -------------------------------------------------------------------------- */
/* Ouverture en ecriture (w) du fichier binaire (b)                           */
/* -------------------------------------------------------------------------- */
    binaire = fopen("C:\\C\\fichiers\\binaire", "wb");
    if (binaire == 0)
    {
        printf(" *** Erreur d'ouverture du fichier binaire ***");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* Ouverture en ecriture (w) du fichier texte (t)                             */
/* -------------------------------------------------------------------------- */
    texte = fopen("C:\\C\\fichiers\\texte", "wt");
    if (texte == 0)
    {
        printf(" *** Erreur d'ouverture du fichier texte ***");
        exit(1);
    }

/* -------------------------------------------------------------------------- */
/* Ecritures de i                                                             */
/* -------------------------------------------------------------------------- */
    i = 17;

    fwrite(&i, sizeof(int), 1, binaire);
    fprintf(texte, "%d", i);

    fclose(binaire);
    fclose(texte);

    return 0;
}
