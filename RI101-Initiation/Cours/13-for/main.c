/* ========================================================================== */
/* Projet : for -- Boucle for                                                 */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int nombre;
    int n;

    printf("Entrer le nombre de boucles a effectuer (entier >= 0) : ");
    scanf("%d", &nombre);

    for (n = 1; n <= nombre; n++)
    {
        printf("Indice : %2d\n", n);
    }

    return 0;
}
