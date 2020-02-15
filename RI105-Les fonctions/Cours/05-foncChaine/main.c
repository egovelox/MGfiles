/* ========================================================================== */
/* Projet : foncChaine                                                        */
/* -------------------------------------------------------------------------- */
/* Affichage des codes ASCII des caracteres de la chaine                      */
/* ========================================================================== */

#include <stdio.h>


/* -------------------------------------------------------------------------- */
/* Declaration de la fonction "foncChaine"                                    */
/* -------------------------------------------------------------------------- */

void foncChaine(char* chaine);


int main()
{
    char chaine[81];

    printf("Entrer une chaine de caracteres : ");
    gets(chaine);

    foncChaine(chaine);
    return 0;
}

/* -------------------------------------------------------------------------- */
/* Fonction d'affichage des codes ascii des caracteres de la chaine           */
/* -------------------------------------------------------------------------- */

void foncChaine(char* chaine)
{
    int i;

    i = 0;
    while (chaine[i] != 0)
    {
        printf("%d  ", chaine[i]);
        i++;
    }

    printf("%d\n", chaine[i]);
}
