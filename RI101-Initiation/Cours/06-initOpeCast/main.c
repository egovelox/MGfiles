/* ========================================================================== */
/* Projet : initOpeCast -- Utilisation des operateurs de conversion (cast)    */
/* -------------------------------------------------------------------------- */
/* Calcul du ratio de deux nombres entiers.                                   */
/* Le troisieme appel de "printf" affiche le résultat de la division entière  */
/* de a par b, (3.000000)                                                     */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int a, b;

    a = 10;
    b = 3;

    printf("Le rapport est %f\n", (float) a / b);
    printf("Le rapport est %f\n", (float) a / (float) b);
    printf("Le rapport est %f\n", (float) (a / b));

    return 0;
}

