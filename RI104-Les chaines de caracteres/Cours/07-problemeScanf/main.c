/* ========================================================================== */
/* Projet : problemeScanf                                                     */
/* -------------------------------------------------------------------------- */
/* Probleme pose par le scanf en cas de mauvaise saisie numerique.            */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int i;
    double x;

    printf("Saisir l'entier i : ");
    scanf("%d", &i);
    printf("i = %d\n", i);

    printf("\n\nSaisir le double x : ");
    scanf("%lf", &x);
    printf("x = %lf\n", x);

    return 0;
}
