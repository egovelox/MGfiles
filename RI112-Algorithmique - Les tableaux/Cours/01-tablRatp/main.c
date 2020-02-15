/* ========================================================================== */
/* Projet : tablRatp -- Statistiques RATP                                     */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "C:\C\utilitaires\entetes\gares.h"
#include "C:\C\utilitaires\entetes\chaines.h"

/* -------------------------------------------------------------------------- */
/* Structure ENQUETE                                                          */
/* -------------------------------------------------------------------------- */

typedef struct
{
    char numGare[3];
    int  mode;
    int  tranche;
} ENQUETE;


/* -------------------------------------------------------------------------- */
/* PROGRAMME PRINCIPAL                                                        */
/* -------------------------------------------------------------------------- */

int main()
{

/* -------------------------------------------------------------------------- */
/* VARIABLES                                                                  */
/* -------------------------------------------------------------------------- */
/* Variables pour l'utilisation des fichiers                                  */
/* -------------------------------------------------------------------------- */
    FILE* fichierEnquetes;
    FILE* fichierGares;
    FILE* edition;

    ENQUETE enquete;
    GARE gare;

/* -------------------------------------------------------------------------- */
/* Critere de reference                                                       */
/* -------------------------------------------------------------------------- */
    char crNumGare[3];

/* -------------------------------------------------------------------------- */
/* Tableau de travail et ses indices                                          */
/* -------------------------------------------------------------------------- */
    int tabGare[7][5];
    int lig;
    int col;

/* -------------------------------------------------------------------------- */
/* Lignes d'edition et variables utilitaires pour l'edition                   */
/* -------------------------------------------------------------------------- */
    char ligneEtoiles[81] = "";       /* ************************************ */
    char ligneEntetes[81] = "";       /* * BUS,CAR * VOITURE  * A PIED   * 2  */
    char ligneTirets[81]  = "";       /* * ------- * ------- * ------- * ---- */

    char ligneGare[81]    = "";       /* GARE: NATION                         */
    char ligneValeurs[81] = "";       /* *  6 H 00 -  9 H 30 *     1250 *     */

    char chaineNum[81];               /* Pour convertir les nombres en chaine */

    char* libelles[7] =
    {
        "*  6 H 00 -  9 H 30 *",
        "*  9 H 30 - 12 H 00 *",
        "* 12 H 00 - 14 H 00 *",
        "* 14 H 00 - 16 H 30 *",
        "* 16 H 30 - 20 H 00 *",
        "* 20 H 00 - 21 H 00 *",
        "* TOTAL             *"
    };

/* -------------------------------------------------------------------------- */
/* DEBUT DU PROGRAMME : OUVERTURE DES FICHIERS                                */
/* -------------------------------------------------------------------------- */
/* Ouverture du fichier des enquetes, en lecture                              */
/* -------------------------------------------------------------------------- */
    fichierEnquetes = fopen("C:\\C\\fichiers\\enquetes", "rb");

    if (fichierEnquetes == NULL)
    {
        printf("***** ERREUR OUVERTURE FICHIER enquetes *****\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier des gares, en lecture                                 */
/* -------------------------------------------------------------------------- */
    fichierGares = fopen("C:\\C\\fichiers\\gares", "rb");

    if (fichierGares == NULL)
    {
        printf("***** ERREUR OUVERTURE FICHIER gares *****\n");
        exit(0);
    }


/* -------------------------------------------------------------------------- */
/* Ouverture du fichier d'edition (edition)                                   */
/* -------------------------------------------------------------------------- */
    edition = fopen("C:\\C\\fichiers\\statsRatp.txt", "wt");

    if (edition == NULL)
    {
        printf("***** ERREUR OUVERTURE FICHIER statsRatp.txt *****\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* DEBUT : preparation des lignes de presentation du tableau                  */
/* -------------------------------------------------------------------------- */
    remplirChaine(ligneEtoiles, '*', 0, 75);

    placeSousChaine(ligneTirets,  "* ----------------- * ", 0, 'd');
    placeSousChaine(ligneEntetes, "*                   * ", 0, 'd');
    for (col = 0; col < 5; col++)
    {
        placeSousChaine(ligneTirets, "-------- * ", 22 + (col * 11), 'd');
        placeSousChaine(ligneEntetes, "         * ", 22 + (col * 11), 'd');
    }

    placeSousChaine(ligneEntetes, "BUS, CAR", 22, 'd');
    placeSousChaine(ligneEntetes, "VOITURE", 33, 'd');
    placeSousChaine(ligneEntetes, "A PIED", 44, 'd');
    placeSousChaine(ligneEntetes, "2 ROUES", 55, 'd');
    placeSousChaine(ligneEntetes, "TOTAL", 66, 'd');

/* -------------------------------------------------------------------------- */
/* Lecture initiale                                                           */
/* -------------------------------------------------------------------------- */
    fread(&enquete, sizeof(ENQUETE), 1, fichierEnquetes);

    do
    {

/* -------------------------------------------------------------------------- */
/* D-GARE                                                                     */
/* -------------------------------------------------------------------------- */
        strcpy(crNumGare, enquete.numGare);

        strcpy(gare.numGare, enquete.numGare);
        litGare(&gare, fichierGares);

        placeSousChaine(ligneGare, "GARE :", 0, 'd');
        placeSousChaine(ligneGare, gare.nomGare, 7, 'd');

        fprintf(edition, "\f%s\n", ligneGare);
        strcpy(ligneGare, "");
        fprintf(edition, "\n%s\n", ligneEtoiles);
        fprintf(edition, "%s\n",   ligneEntetes);
        fprintf(edition, "%s\n",   ligneEtoiles);


/* -------------------------------------------------------------------------- */
/* Initialisation du tableau                                                  */
/* -------------------------------------------------------------------------- */
        for (lig = 0; lig < 7; lig++)
        {

/* -------------------------------------------------------------------------- */
/* D-INIT-LIG                                                                  */
/* -------------------------------------------------------------------------- */
            for (col = 0; col < 5; col++)
            {

/* -------------------------------------------------------------------------- */
/* TT-INIT-COL                                                                */
/* -------------------------------------------------------------------------- */
                tabGare[lig][col] = 0;
            }

/* -------------------------------------------------------------------------- */
/* T-INIT-LIG                                                                  */
/* -------------------------------------------------------------------------- */
        }

/* -------------------------------------------------------------------------- */
/* INTER1 :Boucle sur les enquetes                                                    */
/* -------------------------------------------------------------------------- */
        do
        {

/* -------------------------------------------------------------------------- */
/* TT-ENQUETE                                                    */
/* -------------------------------------------------------------------------- */
            (tabGare[enquete.tranche - 1][enquete.mode - 1])++;
            (tabGare[6][enquete.mode - 1])++;
            (tabGare[enquete.tranche - 1][4])++;
            (tabGare[6][4])++;

            fread(&enquete, sizeof(ENQUETE), 1, fichierEnquetes);
        }
        while ((strcmp(crNumGare, enquete.numGare) == 0) &&
               (!feof(fichierEnquetes)));

/* -------------------------------------------------------------------------- */
/* INTER2 : Affichage du tableau                                              */
/* -------------------------------------------------------------------------- */
        for (lig = 0; lig < 7; lig++)
        {

/* -------------------------------------------------------------------------- */
/* D-AFF-LIG                                                                  */
/* -------------------------------------------------------------------------- */
            placeSousChaine(ligneValeurs, libelles[lig], 0, 'd');

            for (col = 0; col < 5; col++)
            {

/* -------------------------------------------------------------------------- */
/* TT-AFF-COL                                                                 */
/* -------------------------------------------------------------------------- */
                sprintf(chaineNum, "%d", tabGare[lig][col]);
                placeSousChaine(ligneValeurs, chaineNum, 29 + (col * 11), 'g');
                placeSousChaine(ligneValeurs, "*", 31 + (col * 11), 'd');
            }

/* -------------------------------------------------------------------------- */
/* F-AFF-LIG                                                                  */
/* -------------------------------------------------------------------------- */
            fprintf(edition, "%s\n", ligneValeurs);
            strcpy(ligneValeurs, "");

            if (lig < 6) fprintf(edition, "%s\n", ligneTirets);
        }

/* -------------------------------------------------------------------------- */
/* F-GARE                                                                     */
/* -------------------------------------------------------------------------- */
        fprintf(edition, "%s\n", ligneEtoiles);

    }
    while(!feof(fichierEnquetes));

/* -------------------------------------------------------------------------- */
/* FIN                                                                        */
/* -------------------------------------------------------------------------- */
    fclose(fichierEnquetes);
    fclose(fichierGares);
    fclose(edition);

    return 0;
}
