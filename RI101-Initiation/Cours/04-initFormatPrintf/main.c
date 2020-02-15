/* ========================================================================== */
/* Projet : initFormatPrintf -- Formats de printf                             */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int a;
    float b;

    a = 17;
    b = 17.0;

    printf("%%d   : %d\n", a);
    printf("%%6d  : %6d\n", a);
    printf("%%-6d : %-6d\n\n", a);

    printf("%%f       : %f\n", b);
    printf("%%17.3f   : %17.3f\n", b);
    printf("%%-17.3f  : %-17.3f\n\n", b);

    return 0;
}
