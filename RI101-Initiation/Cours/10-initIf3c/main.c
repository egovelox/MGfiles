/* ========================================================================== */
/* Projet : initIf3c -- if multiple                                           */
/* -------------------------------------------------------------------------- */
/* Une serie de trois nombres est-elle ordonnee ?                             */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int a, b, c;

    printf("Introduisez trois nombres : ");
    scanf("%d %d %d", &a, &b, &c);

    if ((a <= b) && (b <= c))
    {
        printf("Ordonne...\n");
    }
    else
    {
        printf("Non ordonne...\n");
    }

    return 0;
}
