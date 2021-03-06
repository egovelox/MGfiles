/* ========================================================================== */
/* Projet : tablAdresses -- Tableau, adresses, op�rateurs * et &              */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int tab[3] = {5, 15, 10};

/* -------------------------------------------------------------------------- */
/* Valeurs des trois postes                                                   */
/* -------------------------------------------------------------------------- */
    printf("tab[0] = %d\n",   tab[0]);
    printf("tab[1] = %d\n",   tab[1]);
    printf("tab[2] = %d\n\n", tab[2]);

/* -------------------------------------------------------------------------- */
/* Adresses des trois postes                                                  */
/* -------------------------------------------------------------------------- */
    printf("tab     = %p\n",   tab);
    printf("tab + 1 = %p\n",   tab + 1);
    printf("tab + 2 = %p\n\n", tab + 2);

/* -------------------------------------------------------------------------- */
/* Operateur * : valeurs situ�es aux trois adresses                           */
/* -------------------------------------------------------------------------- */
    printf("*tab       = %d\n",   *tab);
    printf("*(tab + 1) = %d\n",   *(tab + 1));
    printf("*(tab + 2) = %d\n\n", *(tab + 2));

/* -------------------------------------------------------------------------- */
/* Operateur & : adresses des trois postes                                    */
/* -------------------------------------------------------------------------- */
    printf("&tab[0] = %p\n",   &tab[0]);
    printf("&tab[1] = %p\n",   &tab[1]);
    printf("&tab[2] = %p\n\n", &tab[2]);

    return 0;
}
