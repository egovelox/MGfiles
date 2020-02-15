/* ========================================================================== */
/* Projet : statCAInitVente                                                   */
/* -------------------------------------------------------------------------- */
/* Initialisation du fichier des ventes a partir d'un fichier texte           */
/* (vente.txt)                                                                */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <string.h>
#include <stdlib.h>
#include <stdio.h>

#include "C:\C\utilitaires\entetes\chaines.h"

typedef struct
{
   char  noCli[5];
   char  dateFac[11];
   char  noProd[5];
   int   quantite;
   float prixHT;
} VENTE;

/* ========================================================================== */
/* PROGRAMME PRINCIPAL                                                        */
/* ========================================================================== */

int main()
{
   FILE* fichierVentes;
   VENTE vente;

   FILE* fichierTexteVentes;

   char nomfich[201];

   char ligne[81];
   char mot[21];
   double valeur;

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier texte des ventes                                      */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich, "C:\\C\\fichiers\\vente.txt");

   fichierTexteVentes = fopen(nomfich, "rt");

   if (fichierTexteVentes == NULL)
   {
      printf("***** ERREUR OUVERTURE FICHIER vente.txt *****\n");
      exit(1);
   }

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier binaire des ventes                                    */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich, "C:\\C\\fichiers\\vente");

   fichierVentes = fopen(nomfich, "wb");

   if (fichierVentes == NULL)
   {
      printf("***** ERREUR OUVERTURE FICHIER vente *****\n");
      exit(0);
   }

/* -------------------------------------------------------------------------- */
/* Lecture de la premiere vente :                                             */
/* -------------------------------------------------------------------------- */
   fgets(ligne, 80, fichierTexteVentes);

   while(!feof(fichierTexteVentes))
   {
      isole(ligne, vente.noCli);
      isole(ligne, vente.dateFac);
      isole(ligne, vente.noProd);
      isole(ligne, mot); vente.quantite = atoi(mot);
      isole(ligne, mot); chaineDouble(mot, &valeur); vente.prixHT = (float)valeur;

      fwrite(&vente, sizeof(VENTE), 1, fichierVentes);
      fgets(ligne, 80, fichierTexteVentes);
   }

   fclose(fichierVentes);
   fclose(fichierTexteVentes);

   return 0;
}
