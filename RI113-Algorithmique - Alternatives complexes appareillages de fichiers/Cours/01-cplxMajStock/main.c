/* ========================================================================== */
/* Projet : cplxMajStock                                                      */
/* -------------------------------------------------------------------------- */
/* Mise à jour du fichier nouveau stock a partir des fichiers ancienStock et  */
/* mouvements. Des incidents peuvent se produire (mouvements pour des         */
/* produits inconnus dans le fichier stock).                                  */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "C:\C\utilitaires\entetes\chaines.h"

/* -------------------------------------------------------------------------- */
/* Structure PRODUIT                                                          */
/* -------------------------------------------------------------------------- */

typedef struct
{
    char numero[3];
    char libelle[21];
    int  quantite;
} PRODUIT;

/* -------------------------------------------------------------------------- */
/* Structure MOUVEMENT                                                        */
/* -------------------------------------------------------------------------- */

typedef struct
{
    char numeroProduit[3];
    int  quantite;
    char code;
} MOUVEMENT;


int main()
{
    PRODUIT produitAS, produitNS;
    MOUVEMENT mouvement;

    FILE* fichierAS;
    FILE* fichierMouvements;
    FILE* fichierNS;
    FILE* fichierIncidents;

    char nPro[3];     /* Numero de produit a traiter                           */

/* -------------------------------------------------------------------------- */
/* Ouverture des fichiers                                                     */
/* -------------------------------------------------------------------------- */
    fichierAS = fopen("C:\\C\\fichiers\\ancienStockCplx", "rb");

    if (fichierAS == NULL)
    {
        printf(" *** ERREUR OUVERTURE FICHIER ancienStockCplx ***\n");
        exit(0);
    }

    fichierMouvements = fopen("C:\\C\\fichiers\\mouvementsCplx", "rb");

    if (fichierMouvements == NULL)
    {
        printf(" *** ERREUR OUVERTURE FICHIER mouvementsCplx ***\n");
        exit(0);
    }

    fichierNS = fopen("C:\\C\\fichiers\\nouveauStockCplx", "wb");

    if (fichierNS == NULL)
    {
        printf(" *** ERREUR OUVERTURE FICHIER nouveauStockCplx ***\n");
        exit(0);
    }

    fichierIncidents = fopen("C:\\C\\fichiers\\incidentsCplx.txt", "wt");

    if (fichierIncidents == NULL)
    {
        printf("*** ERREUR OUVERTURE FICHIER EDITION DES INCIDENTS ***\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* DEBUT PROGRAMME                                                            */
/* -------------------------------------------------------------------------- */
    fread(&produitAS, sizeof(PRODUIT), 1, fichierAS);
    if (feof(fichierAS))
        chaineMax(produitAS.numero, sizeof(produitAS.numero));

    fread(&mouvement, sizeof(MOUVEMENT), 1, fichierMouvements);
    if (feof(fichierMouvements))
        chaineMax(mouvement.numeroProduit, sizeof(mouvement.numeroProduit));

    do
    {

/* -------------------------------------------------------------------------- */
/* DEBUT PRODUIT : APPAREILLAGE                                               */
/* -------------------------------------------------------------------------- */
        if (strcmp(produitAS.numero, mouvement.numeroProduit) < 0)
        {
            strcpy(nPro, produitAS.numero);
        }
        else
        {
            strcpy(nPro, mouvement.numeroProduit);
        }

/* -------------------------------------------------------------------------- */
/* INTER1 (Y-a-t'il mise a jour ou incident ?)                                */
/* -------------------------------------------------------------------------- */
        if (strcmp(produitAS.numero, nPro) > 0)
        {

/* -------------------------------------------------------------------------- */
/* GROUPE INCIDENTS                                                           */
/* -------------------------------------------------------------------------- */
            do
            {
                fprintf(fichierIncidents, "%3s  %5d   %c\n",
                        mouvement.numeroProduit,
                        mouvement.quantite,
                        mouvement.code);

                fread(&mouvement, sizeof(MOUVEMENT), 1, fichierMouvements);
                if (feof(fichierMouvements))
                    chaineMax(mouvement.numeroProduit,
                              sizeof(mouvement.numeroProduit));
            }
            while (strcmp(mouvement.numeroProduit, nPro) == 0);
        }
        else
        {

/* -------------------------------------------------------------------------- */
/* DEBUT produitAS                                                            */
/* -------------------------------------------------------------------------- */
            strcpy(produitNS.numero, produitAS.numero);
            strcpy(produitNS.libelle, produitAS.libelle);
            produitNS.quantite = produitAS.quantite;

/* -------------------------------------------------------------------------- */
/* Y-a-t'il des mouvements pour cette mise a jour ?                           */
/* -------------------------------------------------------------------------- */
            if (strcmp(mouvement.numeroProduit, nPro) == 0)
            {
                do
                {
                    if (mouvement.code == 'E')
                        produitNS.quantite += mouvement.quantite;
                    else
                        produitNS.quantite -= mouvement.quantite;

                    fread(&mouvement, sizeof(MOUVEMENT), 1, fichierMouvements);
                    if (feof(fichierMouvements))
                        chaineMax(mouvement.numeroProduit,
                                  sizeof(mouvement.numeroProduit));
                }
                while (strcmp(mouvement.numeroProduit, nPro) == 0);
            }

            printf("%3s   %-20s   %4d\n", produitNS.numero,
                   produitNS.libelle,
                   produitNS.quantite);

            fwrite(&produitNS, sizeof(PRODUIT), 1, fichierNS);

            fread(&produitAS, sizeof(PRODUIT), 1, fichierAS);
            if (feof(fichierAS))
                chaineMax(produitAS.numero, sizeof(produitAS.numero));
        }
    }
    while (!feof(fichierAS) || !feof(fichierMouvements));

/* -------------------------------------------------------------------------- */
/* Fermeture des fichiers                                                     */
/* -------------------------------------------------------------------------- */
    fclose(fichierAS);
    fclose(fichierMouvements);
    fclose(fichierNS);
    fclose(fichierIncidents);

    return 0;
}
