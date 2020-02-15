/* ========================================================================== */
/* Projet : chaiTableauErr -- tableau de caracteres                           */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    char chaine[81]; /* Tableau destine a recevoir une chaine de 80 caracteres */
                     /* plus le zero final                                     */


    chaine = "Oie bernache !";

    printf("\n\nChaine saisie --> ");
    puts(chaine);

    return 0;
}
