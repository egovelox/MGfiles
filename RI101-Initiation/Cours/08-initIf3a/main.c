/* ========================================================================== */
/* Projet : initIf3a -- if imbriques                                          */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int a, b, c;

    printf("Introduisez trois nombres : ");
    scanf("%d %d %d", &a, &b, &c);

    if (a <= b) if (b <= c) printf("Ordonne...\n");
    else                    printf("Non ordonne...\n");

    return 0;
}
