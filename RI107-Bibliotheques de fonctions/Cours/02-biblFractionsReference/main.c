/* ========================================================================== */
/* Projet : biblFractionsReference                                            */
/* -------------------------------------------------------------------------- */
/* main.c : PROGRAMME DE TEST DE LA BIBLIOTHEQUE DE GESTION DES FRACTIONS     */
/* ========================================================================== */

#include <stdio.h>
#include <conio.h>

#include "C:\c\utilitaires\entetes\fractions.h"

int main()
{
    FRACTION f1, f2, f3;

    f2.Num = 5;
    f2.Den = 2;

/* -------------------------------------------------------------------------- */
/* Saisie de la fraction f1                                                   */
/* -------------------------------------------------------------------------- */
    printf("Saisie de la fraction f1\n");
    saisie(&f1);

    while(f1.Den == 0)
    {
        printf("Denominateur de la fraction f1 nul !\n\n");
        saisie(&f1);
    }

/* -------------------------------------------------------------------------- */
/* Calcul de la somme (simplifiee)                                            */
/* -------------------------------------------------------------------------- */
    f3 = somme(f1, f2);

/* -------------------------------------------------------------------------- */
/* Affichage de la somme                                                      */
/* -------------------------------------------------------------------------- */
    printf("\nSomme de ");
    affiche(f1);
    printf(" et de ");
    affiche(f2);
    printf(" = ");
    affiche(f3);
    printf("\n");

    return 0;
}
