/* ========================================================================== */
/* Projet : tablInitRatp -- initialisation du fichier enquete RATP            */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#include "C:\C\utilitaires\entetes\gares.h"

/* -------------------------------------------------------------------------- */
/* Structure ENQUETE                                                          */
/* -------------------------------------------------------------------------- */

typedef struct
{
   char numGare[3];
   int  mode;
   int  tranche;
}ENQUETE;

int main()
{
   FILE* fichierGares;
   GARE gare;

   FILE* fichierEnquetes;
   ENQUETE enquete;

   char nomfich[81];

   int nbFormulaires;
   int i;
   int icorr;   /* Correction du tirage aleatoire : il s'agit d'augmenter le  */
                /* nombre d'enquetes de certaines tranches au detriment       */
                /* d'autres... Idem pour les modes...                         */

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier des gares, en lecture.                                */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich, "C:\\C\\fichiers\\gares");

   fichierGares = fopen(nomfich, "rb");

   if (fichierGares == NULL)
   {
      printf("\n*** ERREUR OUVERTURE FICHIER gares ***\n");
      exit (0);
   }

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier des enquetes, en ecriture.                            */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich, "C:\\C\\fichiers\\enquetes");

   fichierEnquetes = fopen(nomfich, "wb");

   if (fichierEnquetes == NULL)
   {
      printf("\n*** ERREUR OUVERTURE FICHIER enquetes ***\n");
      exit (0);
   }

/* -------------------------------------------------------------------------- */
/* Initialisation du tirage aleatoire                                         */
/* -------------------------------------------------------------------------- */
   srand(time(NULL));

/* -------------------------------------------------------------------------- */
/* Boucle sur les gares                                                       */
/* -------------------------------------------------------------------------- */
   printf("\n\nCREATION AUTOMATIQUE DES FORMULAIRES D'ENQUETE\n\n");

   fread(&gare, sizeof(GARE), 1, fichierGares);

   while (!feof(fichierGares))
   {

/* -------------------------------------------------------------------------- */
/* Nombre de formulaires d'enquete pour cette gare :                          */
/* -------------------------------------------------------------------------- */
      nbFormulaires = (rand() % 9999) + 1;
      printf("%s : %d formulaires\n", gare.nomGare, nbFormulaires);

/* -------------------------------------------------------------------------- */
/* Boucle de creation des formulaires de la gare :                            */
/* -------------------------------------------------------------------------- */
      for (i = 1; i <= nbFormulaires; i++)
      {
         strcpy(enquete.numGare, gare.numGare);

         enquete.mode = (rand() % 4) + 1;
         if (enquete.mode == 3)
         {
            icorr = rand() % 3;
            if(icorr < 2) enquete.mode -= icorr;
         }
         else
         {
            if (enquete.mode == 4)
            {
               icorr = rand() % 2;
               if(icorr < 1) enquete.mode = 2;
            }
         }

         enquete.tranche = (rand() % 6) + 1;
         if (enquete.tranche > 1 && enquete.tranche < 5)
         {
            icorr = rand() % 3;
            if(icorr == 0) enquete.tranche = 1;
            if(icorr == 1) enquete.tranche = 5;
         }

         fwrite(&enquete, sizeof(ENQUETE), 1, fichierEnquetes);
      }

      fread(&gare, sizeof(GARE), 1, fichierGares);
   }

   fclose(fichierGares);
   fclose(fichierEnquetes);

   return 0;
}

