/* ========================================================================== */
/* Projet : pointeurEntier -- Exemple de pointeur                             */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int* p;           /* Pointeur sur un entier. Cette ecriture suggere que la */
                      /* variable p est du type pointeur sur un entier (int*)  */
                      /* On pourrait aussi ecrire int *p, qui suggere que la   */
                      /* variable *p est du type entier, ce qui est aussi vrai */

    int n;

/* -------------------------------------------------------------------------- */
/* Initialisation et affichage de n                                           */
/* -------------------------------------------------------------------------- */
    n = 17;
    printf("n  = %d\n\n", n);

/* -------------------------------------------------------------------------- */
/* Initialisation et affichage de p                                           */
/* -------------------------------------------------------------------------- */
    p = &n;                         /* Affectation de l'adresse de n dans p    */
    printf("p  = %p\n\n", p);

/* -------------------------------------------------------------------------- */
/* Affichage de la valeur pointee par p                                       */
/* -------------------------------------------------------------------------- */
    printf("*p = %d\n\n", *p);

/* -------------------------------------------------------------------------- */
/* Incrementation de la valeur pointee par p. Affichage de n                  */
/* -------------------------------------------------------------------------- */
    (*p)++;
    printf("n  = %d\n\n", n);

    return 0;
}
