/* ========================================================================== */
/* Projet : foncFraction : Fonctions - Fractions                              */
/* ========================================================================== */

#include <stdio.h>
#include <stdlib.h>

void saisie(int*, int*);
void somme(int, int, int, int, int*, int*);
int pgcd(int, int);
void affiche(int, int);



/* ========================================================================== */
/* Programme principal                                                        */
/* ========================================================================== */

int main()
{
    int n1, d1, n2, d2, n3, d3;

/* -------------------------------------------------------------------------- */
/* Saisie des fractions                                                       */
/* -------------------------------------------------------------------------- */
    printf("Saisie fraction 1\n");
    saisie(&n1, &d1);

    while(d1 == 0)
    {
        printf("Denominateur fraction 1 nul !\n\n");
        saisie(&n1, &d1);
    }

    printf("\n\nSaisie fraction 2\n");
    saisie(&n2, &d2);

    while(d2 == 0)
    {
        printf("Denominateur fraction 2 nul !\n\n");
        saisie(&n2, &d2);
    }

/* -------------------------------------------------------------------------- */
/* Calcul de la somme (simplifiee)                                            */
/* -------------------------------------------------------------------------- */
    somme(n1, d1, n2, d2, &n3, &d3);

/* -------------------------------------------------------------------------- */
/* Affichage de la somme                                                      */
/* -------------------------------------------------------------------------- */
    printf("\nSomme des fractions : ");
    affiche(n3, d3);

    return 0;
}

/* ========================================================================== */
/* Saisie de la fraction                                                      */
/* ========================================================================== */

void saisie(int* pNum, int* pDen)
{
    char ligne[81];

    printf("Introduisez le numerateur : ");
    gets(ligne);
    *pNum = atoi(ligne);

    printf("Introduisez le denominateur : ");
    gets(ligne);
    *pDen = atoi(ligne);
}

/* ========================================================================== */
/* Somme de deux fractions                                                    */
/* ========================================================================== */

void somme(int num1, int den1, int num2, int den2, int* pNum3, int* pDen3)
{
    int diviseur;

    *pNum3 = (num1 * den2) + (num2 * den1);
    *pDen3 = den1 * den2;

    diviseur = pgcd(*pNum3, *pDen3);
    *pNum3 = *pNum3 / diviseur;
    *pDen3 = *pDen3 / diviseur;
}

/* ========================================================================== */
/* pgcd de deux entiers                                                       */
/* ========================================================================== */

int pgcd(int n1, int n2)
{
    while (n1 != n2)
    {
        if (n1 > n2) n1 -= n2;
        else         n2 -= n1;
    }
    return n1;
}

/* ========================================================================== */
/* affichage d'une fraction precedee d'un texte                               */
/* ========================================================================== */

void affiche(int num, int den)
{
    if (den != 1)
    {
        printf("%d/%d\n", num, den);
    }
    else
    {
        printf("%d\n", num);
    }
}
