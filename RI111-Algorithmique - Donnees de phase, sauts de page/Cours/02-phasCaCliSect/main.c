/* ========================================================================== */
/* Projet : phasCaCliSect                                                     */
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

    FILE* edition;

/* -------------------------------------------------------------------------- */
/* Criteres de reference                                                      */
/* -------------------------------------------------------------------------- */
    char crNoSec[4];
    char crNoCli[5];

/* -------------------------------------------------------------------------- */
/* Chiffre d'affaires, remise, totaux secteur                                 */
/* -------------------------------------------------------------------------- */
    float ca;
    float remise;
    float totalCaSec;
    float totalRemiseSec;

/* -------------------------------------------------------------------------- */
/* Lignes d'edition                                                           */
/* -------------------------------------------------------------------------- */
    char lt1[81] = "";
    char lt2[81] = "";
    char ligne1[81] = "";
    char ligne2[81] = "";

    char chaineNum[81];    /* Pour convertir les valeurs numeriques en chaine */

/* -------------------------------------------------------------------------- */
/* Compteur de lignes pour les sauts de page                                  */
/* -------------------------------------------------------------------------- */
    int compteurLignes; /* Nombre de lignes "ligne1" et "ligne2" deja ecrites */
                        /* (On comptera aussi les lignes blanches avant et    */
                        /* apres la "ligne2").                                */

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier des produits                                          */
/* -------------------------------------------------------------------------- */
    fichierProduits = fopen("C:\\C\\fichiers\\produitsCA", "rb");

    if (fichierProduits == NULL)
    {
        printf("***** ERREUR OUVERTURE FICHIER produitsCA *****\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier d'edition                                             */
/* -------------------------------------------------------------------------- */
    edition = fopen("C:\\C\\fichiers\\editionCA.txt", "wt");

    if (edition == NULL)
    {
        printf("*** ERREUR OUVERTURE FICHIER EDITION ***\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* DEBUT PROGRAMME                                                            */
/* -------------------------------------------------------------------------- */
    placeSousChaine(lt1, "CA ET REMISES PAR CLIENT ET SECTEUR", 1, 'd');
    placeSousChaine(lt2, "SECTEUR", 1, 'd');
    placeSousChaine(lt2, "CLIENT", 15, 'd');
    placeSousChaine(lt2, "CA", 33, 'g');
    placeSousChaine(lt2, "REMISE", 57, 'g');

    fprintf(edition, "%s\n\n", lt1);
    fprintf(edition, "%s\n\n", lt2);

    compteurLignes = 0;

    fread(&produit, sizeof(PRODUIT), 1, fichierProduits);


    do
    {

/* -------------------------------------------------------------------------- */
/* DEBUT SECTEUR                                                              */
/* -------------------------------------------------------------------------- */
        strcpy(crNoSec, produit.noSec);
        totalCaSec = 0;
        totalRemiseSec = 0;
        placeSousChaine(ligne1, crNoSec, 1, 'd');

        do
        {

/* -------------------------------------------------------------------------- */
/* DEBUT CLIENT                                                               */
/* -------------------------------------------------------------------------- */
            strcpy(crNoCli, produit.noCli);
            ca = 0;
            placeSousChaine(ligne1, crNoCli, 15, 'd');

            do
            {

/* -------------------------------------------------------------------------- */
/* TRAITEMENT PRODUIT                                                         */
/* -------------------------------------------------------------------------- */
                ca += produit.qte * produit.PU;

                fread(&produit, sizeof(PRODUIT), 1, fichierProduits);
            }
            while((!feof(fichierProduits)) &&
                    (strcmp(produit.noSec, crNoSec) == 0) &&
                    (strcmp(produit.noCli, crNoCli) == 0));

/* -------------------------------------------------------------------------- */
/* INTER                                                                      */
/* -------------------------------------------------------------------------- */
            doubleChaine(ca, 0, chaineNum);
            placeSousChaine(ligne1, chaineNum, 35, 'g');

            if(ca >= 1000)
            {

/* -------------------------------------------------------------------------- */
/* TRAITEMENT REMISE                                                          */
/* -------------------------------------------------------------------------- */
                remise = ca / 10;
                totalRemiseSec += remise;

                doubleChaine(remise, 0, chaineNum);
                placeSousChaine(ligne1, chaineNum, 55, 'g');
            }

/* -------------------------------------------------------------------------- */
/* FIN CLIENT                                                                 */
/* -------------------------------------------------------------------------- */
            totalCaSec += ca;

            if (compteurLignes >= 20)
            {
                fprintf(edition, "\f");

                fprintf(edition, "%s\n\n", lt1);
                fprintf(edition, "%s\n\n", lt2);

                placeSousChaine(ligne1, crNoSec, 1, 'd');

                compteurLignes = 0;
            }

            fprintf(edition, "%s\n", ligne1);
            strcpy(ligne1, "");
            compteurLignes++;
        }
        while((!feof(fichierProduits)) &&
                (strcmp(produit.noSec, crNoSec) == 0));

/* -------------------------------------------------------------------------- */
/* FIN SECTEUR                                                                */
/* -------------------------------------------------------------------------- */
        placeSousChaine(ligne2, "TOTAL SECTEUR", 15, 'd');
        doubleChaine(totalCaSec, 0, chaineNum);
        placeSousChaine(ligne2, chaineNum, 35, 'g');
        doubleChaine(totalRemiseSec, 0, chaineNum);
        placeSousChaine(ligne2, chaineNum, 55, 'g');

        fprintf(edition, "\n%s\n\n", ligne2);
        strcpy(ligne2, "");
        compteurLignes += 3;
    }
    while(!feof(fichierProduits));

/* -------------------------------------------------------------------------- */
/* FIN PROGRAMME                                                              */
/* -------------------------------------------------------------------------- */
    fclose(fichierProduits);
    fclose(edition);

    return 0;
}
