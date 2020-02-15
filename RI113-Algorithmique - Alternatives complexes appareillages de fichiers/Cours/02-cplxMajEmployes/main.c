/* ========================================================================== */
/* Projet : majEmployes                                                       */
/* -------------------------------------------------------------------------- */
/* Mise à jour du fichier EMPnouveauloye stock a partir des fichiers          */
/* EMPancien, EMPcreation et EMPmodif. Des incidents peuvent se produire.     */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "C:\C\utilitaires\entetes\chaines.h"

/* -------------------------------------------------------------------------- */
/* Structure EMPLOYE                                                          */
/* -------------------------------------------------------------------------- */
typedef struct
{
    char numero[3];
    char infos[21];
} EMPLOYE;


int main()
{
    EMPLOYE empA, empC, empM;
    EMPLOYE empN;

    FILE* fichierA;
    FILE* fichierC;
    FILE* fichierM;
    FILE* fichierN;
    FILE* incidents;

    char numEmp[3];     /* Numero de l'employe a traiter                       */

/* -------------------------------------------------------------------------- */
/* Ouverture des fichiers                                                     */
/* -------------------------------------------------------------------------- */
    fichierA = fopen("C:\\C\\fichiers\\EMPancien", "rb");
    if (fichierA == NULL)
    {
        printf(" *** ERREUR OUVERTURE FICHIER EMPancien ***\n");
        exit(0);
    }

    fichierC = fopen("C:\\C\\fichiers\\EMPcreation", "rb");
    if (fichierC == NULL)
    {
        printf(" *** ERREUR OUVERTURE FICHIER EMPcreation ***\n");
        exit(0);
    }

    fichierM = fopen("C:\\C\\fichiers\\EMPmodif", "rb");
    if (fichierM == NULL)
    {
        printf(" *** ERREUR OUVERTURE FICHIER EMPmodif ***\n");
        exit(0);
    }

    fichierN = fopen("C:\\C\\fichiers\\EMPnouveau", "wb");
    if (fichierN == NULL)
    {
        printf(" *** ERREUR OUVERTURE FICHIER EMPnouveau ***\n");
        exit(0);
    }

    incidents = fopen("C:\\C\\fichiers\\EMPincidents.txt", "wt");
    if (incidents == NULL)
    {
        printf("*** ERREUR OUVERTURE FICHIER EDITION DES INCIDENTS ***\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* DEBUT PROGRAMME                                                            */
/* -------------------------------------------------------------------------- */
    fread(&empA, sizeof(EMPLOYE), 1, fichierA);
    if (feof(fichierA)) chaineMax(empA.numero, sizeof(empA.numero));

    fread(&empC, sizeof(EMPLOYE), 1, fichierC);
    if (feof(fichierC)) chaineMax(empC.numero, sizeof(empC.numero));

    fread(&empM, sizeof(EMPLOYE), 1, fichierM);
    if (feof(fichierM)) chaineMax(empM.numero, sizeof(empM.numero));

    do
    {

/* -------------------------------------------------------------------------- */
/* DEBUT EMPLOYE : APPAREILLAGE                                               */
/* -------------------------------------------------------------------------- */
        if (strcmp(empA.numero, empC.numero) > 0)
        {
            strcpy(numEmp, empC.numero);
        }
        else
        {
            strcpy(numEmp, empA.numero);
        }

        if (strcmp(numEmp, empM.numero) > 0)
        {
            strcpy(numEmp, empM.numero);
        }

/* -------------------------------------------------------------------------- */
/* INTER 2 (l'employe est-il dans le fichier EMPancien ?)                     */
/* -------------------------------------------------------------------------- */
        if (strcmp(empA.numero, numEmp) == 0)
        {
            if (strcmp(empC.numero, numEmp) == 0)
            {
                fprintf(incidents, "%2s : INCIDENT(Creation)\n", numEmp);
            }
            else
            {
                if (strcmp(empM.numero, numEmp) == 0)
                {
                    strcpy(empN.numero, empM.numero);
                    strcpy(empN.infos, empM.infos);
                    fwrite(&empN, sizeof(EMPLOYE), 1, fichierN);
                }
                else
                {
                    strcpy(empN.numero, empA.numero);
                    strcpy(empN.infos, empA.infos);
                    fwrite(&empN, sizeof(EMPLOYE), 1, fichierN);
                }
            }

            fread(&empA, sizeof(EMPLOYE), 1, fichierA);
            if (feof(fichierA)) chaineMax(empA.numero, sizeof(empA.numero));
        }
        else
        {
            if (strcmp(empC.numero, numEmp) == 0)
            {
                if (strcmp(empM.numero, numEmp) == 0)
                {
                    fprintf(incidents, "%2s : INCIDENT(Modification)\n", numEmp);
                }
                else
                {
                    strcpy(empN.numero, empC.numero);
                    strcpy(empN.infos, empC.infos);
                    fwrite(&empN, sizeof(EMPLOYE), 1, fichierN);
                }
            }
            else
            {
                fprintf(incidents, "%2s : INCIDENT(Modification)\n", numEmp);
            }
        }

/* -------------------------------------------------------------------------- */
/* INTER 3 (Module de lecture)                                                */
/* -------------------------------------------------------------------------- */
        if (strcmp(empC.numero, numEmp) == 0)
        {
            fread(&empC, sizeof(EMPLOYE), 1, fichierC);
            if (feof(fichierC)) chaineMax(empC.numero, sizeof(empC.numero));
        }
        if (strcmp(empM.numero, numEmp) == 0)
        {
            fread(&empM, sizeof(EMPLOYE), 1, fichierM);
            if (feof(fichierM)) chaineMax(empM.numero, sizeof(empM.numero));
        }

    }
    while (!feof(fichierA) || !feof(fichierC) || !feof(fichierM));

/* -------------------------------------------------------------------------- */
/* Fermeture des fichiers                                                     */
/* -------------------------------------------------------------------------- */
    fclose(fichierA);
    fclose(fichierC);
    fclose(fichierM);
    fclose(fichierN);
    fclose(incidents);

    return 0;
}
