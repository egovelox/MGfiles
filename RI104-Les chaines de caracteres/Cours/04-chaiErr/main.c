/* ========================================================================== */
/* Projet : chaiErr -- saisie d'une chaine de caracteres au clavier           */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    char* adresse;

    printf("Saisir une chaine de caracteres : ");
    gets(adresse);

    printf("\n\nChaine saisie --> ");
    puts(adresse);

    return 0;
}
