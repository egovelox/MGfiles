/* ========================================================================== */
/* Projet : biblGares                                                         */
/* -------------------------------------------------------------------------- */
/* gares.c (enquete RATP) : Fonction liee à la structure GARE :               */
/*                                                                            */
/* litGare : lecture d'un enregistrement du fichier gare connaissant          */
/*           la clef (numero de la gare : numGare)                            */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include "gares.h"
#include <stdio.h>
#include <string.h>


int litGare(GARE *pGare, FILE *fichier)
{

   GARE gare;
   int trouve;
   int i;

/* -------------------------------------------------------------------------- */
/* Boucle de recherche séquentielle                                           */
/* -------------------------------------------------------------------------- */
   trouve = 0;

   i = 0;
   fseek(fichier, i * sizeof(GARE), SEEK_SET);
   fread(&gare, sizeof(GARE), 1, fichier);

   while (!feof(fichier) && trouve == 0)
   {
      if(strcmp(gare.numGare, pGare->numGare) == 0)
      {
         trouve = 1;
         *pGare = gare;
      }

      i++;
      fseek(fichier, i * sizeof(GARE), SEEK_SET);
      fread(&gare, sizeof(GARE), 1, fichier);
   }

   return trouve;
}
