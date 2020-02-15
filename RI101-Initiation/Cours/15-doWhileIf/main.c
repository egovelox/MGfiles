/* ========================================================================== */
/* Projet : doWhileIf -- Boucle do...while et if                              */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int nombre;
    int n;

    printf("Entrer le nombre de boucles a effectuer (entier >= 0) : ");
    scanf("%d", &nombre);


    if(nombre == 0)
    {
        printf("Aucune boucle a effectuer !\n");
    }
    else
    {
        n = 1;

        do
        {
            printf("Indice : %2d\n", n);
            n++;
        }
        while (n <= nombre);
    }

    return 0;
}
