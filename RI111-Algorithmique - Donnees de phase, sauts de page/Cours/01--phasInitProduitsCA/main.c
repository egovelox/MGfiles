/* ========================================================================== */
/* Projet : phasInitProduitsCA                                                */
/* -------------------------------------------------------------------------- */
/* initialisation du fichier des produits a  partir d'un fichier texte        */
/* (produitsCA.txt)                                                           */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <string.h>
#include <stdlib.h>
#include <stdio.h>

#include "C:\C\utilitaires\entetes\chaines.h"

typedef struct
{
    char  noSec[4];
    char  noCli[5];
    char  noPro[4];
    int   qte;
    float PU;
} PRODUIT;

/* ========================================================================== */
/* PROGRAMME PRINCIPAL                                                        */
/* ========================================================================== */

int main()
{
    FILE* fichierProduits;
    PRODUIT produit;

    FILE* fichierTexteProduits;
    char ligne[81];

    char mot[21];
    double valeur;

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier texte des produits                                    */
/* -------------------------------------------------------------------------- */
    fichierTexteProduits = fopen("C:\\C\\fichiers\\produitsCA.txt", "rt");

    if (fichierTexteProduits == NULL)
    {
        printf("***** ERREUR OUVERTURE FICHIER produitsCA.txt *****\n");
        exit(1);
    }

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier binaire des produits                                  */
/* -------------------------------------------------------------------------- */
    fichierProduits = fopen("C:\\C\\fichiers\\\\produitsCA", "wb");

    if (fichierProduits == NULL)
    {
        printf("***** ERREUR OUVERTURE FICHIER produitsCA *****\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* Lecture du premier produit :                                               */
/* -------------------------------------------------------------------------- */
    fgets(ligne, 80, fichierTexteProduits);

    while(!feof(fichierTexteProduits))
    {
        isole(ligne, produit.noSec);

        isole(ligne, produit.noCli);

        isole(ligne, produit.noPro);

        isole(ligne, mot);
        produit.qte = atoi(mot);

        isole(ligne, mot);
        chaineDouble(mot, &valeur);
        produit.PU = (float)valeur;

        fwrite(&produit, sizeof(PRODUIT), 1, fichierProduits);
        fgets(ligne, 80, fichierTexteProduits);
    }

    fclose(fichierProduits);
    fclose(fichierTexteProduits);

    return 0;
}
