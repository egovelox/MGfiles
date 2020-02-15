/* ========================================================================== */
/* Projet : biblGares                                                         */
/* -------------------------------------------------------------------------- */
/* main.c : initialisation du fichier des gares RATP                          */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "gares.h"

int main()
{
   FILE* fichierGares;
   GARE g;

   char nomfich[81];

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier des gares, en ecriture (ou ajout).                    */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich,"C:\\C\\fichiers\\gares");
   fichierGares = fopen(nomfich, "ab");

   if (fichierGares == NULL)
   {
      printf("\n*** ERREUR OUVERTURE FICHIER GARES ***\n");
      exit (0);
   }

/* -------------------------------------------------------------------------- */
/* Saisie des gares                                                           */
/* -------------------------------------------------------------------------- */
   printf("\n\nSAISIE DES GARES");

   printf("\n\nNumero de la gare : ");
   gets(g.numGare);

   while (g.numGare[0] != 0)
   {
      printf("Nom de la gare : ");
      gets(g.nomGare);

      fwrite(&g, sizeof(GARE), 1, fichierGares);

      printf("\n\nNumero de la gare : ");
      gets(g.numGare);
   }

   fclose(fichierGares);

   return 0;
}
