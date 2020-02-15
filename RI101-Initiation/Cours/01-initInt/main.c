/* ========================================================================== */
/* Projet : initInt -- Saisie de deux nombres, affichage de la somme          */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int a, b, sum;

    printf("Introduisez deux nombres : ");
    scanf("%d %d", &a, &b);
    sum = a + b;
    printf("La somme est %d\n\n", sum);

    return 0;
}
