/* ========================================================================== */
/* Projet : statCALitVente -- lecture du fichier vente (vente)                */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

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

/* -------------------------------------------------------------------------- */
/* VARIABLES                                                                  */
/* -------------------------------------------------------------------------- */
/* Variables pour l'utilisation des fichiers                                  */
/* -------------------------------------------------------------------------- */

   char nomfich[201];

   VENTE vente;
   FILE * f_vente;

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier binaire des ventes                                    */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich, "C:\\C\\fichiers\\vente");

   f_vente = fopen(nomfich, "rb");

   if (f_vente == NULL)
   {
      printf("***** ERREUR OUVERTURE FICHIER vente *****\n");
      exit(0);
   }

/* -------------------------------------------------------------------------- */
/* Impression du fichier des ventes                                           */
/* -------------------------------------------------------------------------- */
   printf("FICHIER DES VENTES (vente)\n\n");

   fread(&vente, sizeof(VENTE), 1, f_vente);

   do
   {
      printf("%4s  %10s  %4s  %4d  %9.2f\n",
             vente.noCli,
             vente.dateFac,
             vente.noProd,
             vente.quantite,
             vente.prixHT);

      fread(&vente, sizeof(VENTE), 1, f_vente);
   }
   while(!feof(f_vente));

   fclose(f_vente);

   return 0;
}
