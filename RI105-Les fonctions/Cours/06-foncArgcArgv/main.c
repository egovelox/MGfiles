/* ========================================================================== */
/* Projet : foncArgcArgv -- affichage d'un texte complete par un parametre    */
/*                          lu en ligne de commande.                          */
/* ========================================================================== */

#include <stdio.h>

int main(int argc, char* argv[])
{
    char* message;
    printf("%d  %s\n", argc, argv[0]);

    if(argc > 1)
    {
        message = argv[1];
    }
    else
    {
        message = "CHARBONNIERE";
    }

    printf("MESANGE %s.\n", message);

    return 0;
}
