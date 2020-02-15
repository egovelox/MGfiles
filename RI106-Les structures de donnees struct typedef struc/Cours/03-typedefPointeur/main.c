/* ========================================================================== */
/* Projet : typedefPointeur -- Pointeur sur une structures de donnees         */
/* ========================================================================== */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/* -------------------------------------------------------------------------- */
/* La declaration suivante permet de definir un nouveau type de donnees.      */
/* Elle ne reserve pas d'espace en memoire.                                   */
/* -------------------------------------------------------------------------- */

typedef struct
{
    int numero;
    char nom[51];
} STAGIAIRE;

int main()
{
    STAGIAIRE* pStagiaire;       /* Declaration d'un pointeur sur un STAGIAIRE */

/* -------------------------------------------------------------------------- */
/* Allocation d'une variable de type STAGIAIRE "pointee" par pStagiaire       */
/* -------------------------------------------------------------------------- */
    pStagiaire = (STAGIAIRE*) calloc(1, sizeof(STAGIAIRE));

/* -------------------------------------------------------------------------- */
/* Initialisation des differentes proprietes du STAGIAIRE                     */
/* -------------------------------------------------------------------------- */
    pStagiaire->numero = 10;
    strcpy(pStagiaire->nom, "Pie");

/* -------------------------------------------------------------------------- */
/* Affichage des differentes proprietes du STAGIAIRE                          */
/* -------------------------------------------------------------------------- */
    printf("Stagiaire : %3d  %s\n\n", pStagiaire->numero, pStagiaire->nom);

    return 0;
}
