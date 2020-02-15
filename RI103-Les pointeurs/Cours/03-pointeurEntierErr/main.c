/* ========================================================================== */
/* Projet : pointeurEntierErr -- Exemple de pointeur illegal                  */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int* p;

    p = 0;            /* Attention, cette affectation met l'adresse memoire 0  */
                      /* dans le pointeur p... danger !                        */
    *p = 10;

    return 0;
}
