/* ========================================================================== */
/* Projet : initOpeIncr -- Utilisation des operateurs ++ --                   */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int a, b, sum;

    a = b = 5;
    sum = a + b;   printf("a = %d    b = %d      sum = %d \n", a, b, sum);
    sum = a++ + b; printf("a = %d    b = %d      sum = %d \n", a, b, sum);
    sum = ++a + b; printf("a = %d    b = %d      sum = %d \n", a, b, sum);
    sum = --a + b; printf("a = %d    b = %d      sum = %d \n", a, b, sum);
    sum = a-- + b; printf("a = %d    b = %d      sum = %d \n", a, b, sum);
    sum = a + b;   printf("a = %d    b = %d      sum = %d \n", a, b, sum);

    return 0;
}
