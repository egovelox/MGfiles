/* ========================================================================== */
/* Projet : while -- Boucle while                                             */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int nombre;
    int n;

    printf("Entrer le nombre de boucles a effectuer (entier >= 0) : ");
    scanf("%d", &nombre);

    n = 1;

/* La boucle s'effectue tant que l'indice n'a pas atteint la valeur nombre */
    while (n <= nombre)
    {

/* Affichage, puis incrémentation de l'indice */
        printf("Indice : %2d\n", n);
        n++;
    }

    return 0;
}
