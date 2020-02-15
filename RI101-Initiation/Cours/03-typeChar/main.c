/* ========================================================================== */
/* Projet : typeChar -- Valeur d'un caractere, suivant le format              */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    char a;

    a = 'A';
    printf("Caractere : %c \n", a);
    printf("Entier    : %d \n\n", a);        /* code ascii, en decimal (65)   */

    a = a + 3;
    printf("Caractere : %c \n", a);
    printf("Entier    : %d \a\n\n", a);      /* code ascii, en decimal (68)   */

    return 0;
}
