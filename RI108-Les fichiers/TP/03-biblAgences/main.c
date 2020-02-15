/* ========================================================================== */
/* Projet : biblAgences                                                       */
/* -------------------------------------------------------------------------- */
/* main.c : affichage du fichier des agences                                  */
/* ========================================================================== */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "agences.h"


int main()
{
    FILE* fichierAgences;
    AGENCE agence;

    fichierAgences = fopen("C:\\C\\fichiers\\agences", "rb");

    if (fichierAgences == NULL)
    {
        printf("***** ERREUR OUVERTURE FICHIER AGENCES *****\n\n");
        exit(1);
    }

    printf("Liste des agences :\n\n");

    fread(&agence, sizeof(AGENCE), 1, fichierAgences);

    while(!feof(fichierAgences))
    {
        printf("%3d  %s\n", agence.numero, agence.nom);
        fread(&agence, sizeof(AGENCE), 1, fichierAgences);
    }

    fclose(fichierAgences);
    return 0;
}
