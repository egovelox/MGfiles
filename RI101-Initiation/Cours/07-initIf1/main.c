/* ========================================================================== */
/* Projet : initIf1 -- if                                                     */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int a, b;

    printf("Introduisez deux nombres : ");
    scanf("%d %d", &a, &b);

    printf("a <= b : %d\n", a <= b);

    if (a <= b)
        printf("Croissant\n\n");
    else
        printf("Decroissant\n\n");

    return 0;
}
