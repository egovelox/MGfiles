/* ========================================================================== */
/* Projet : chaiAdresses -- chaines de caracteres                             */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    char* chaine;

    chaine = "Oie";

    printf("%c   %3d   %p\n", *chaine, *chaine, chaine);
    do
    {
        chaine++;
        printf("%c   %3d   %p\n", *chaine, *chaine, chaine);
    }
    while(*chaine != 0);

    return 0;
}
