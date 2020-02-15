/* ========================================================================== */
/* Projet : facturesInitComm                                                  */
/* -------------------------------------------------------------------------- */
/* initialisation du fichier des commandes a partir d'un fichier texte        */
/* (comm.txt)                                                                 */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <string.h>
#include <stdlib.h>
#include <stdio.h>

#include "C:\C\utilitaires\entetes\chaines.h"

typedef struct
{
   char  noComm[7];
   char  noCli[5];
   char  noProd[5];
   int   quantite;
   char  desig[21];
   float prix;
   char  date[11];
} COMMANDE;

/* ========================================================================== */
/* PROGRAMME PRINCIPAL                                                        */
/* ========================================================================== */

int main()
{
   FILE* fichierCommandes;
   COMMANDE commande;

   FILE* fichierTexteCommandes;
   char ligne[81];

   char nomfich[81];

   char mot[21];
   double valeur;

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier texte des commandes                                   */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich, "C:\\C\\fichiers\\comm.txt");

   fichierTexteCommandes = fopen(nomfich, "rt");

   if (fichierTexteCommandes == NULL)
   {
      printf("***** ERREUR OUVERTURE FICHIER comm.txt *****");
      exit(1);
   }

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier binaire des commandes                                 */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich, "C:\\C\\fichiers\\comm");

   fichierCommandes = fopen(nomfich, "wb");

   if (fichierCommandes == NULL)
   {
      printf("***** ERREUR OUVERTURE FICHIER comm *****");
      exit(0);
   }

/* -------------------------------------------------------------------------- */
/* Lecture de la premiere commande :                                          */
/* -------------------------------------------------------------------------- */
   fgets(ligne, 80, fichierTexteCommandes);

   while(!feof(fichierTexteCommandes))
   {
      isole(ligne, commande.noComm);

      isole(ligne, commande.noCli);

      isole(ligne, commande.noProd);

      isole(ligne, mot);
      commande.quantite = atoi(mot);

      isole(ligne, commande.desig);

      isole(ligne, mot);
      chaineDouble(mot, &valeur);
      commande.prix = (float)valeur;

      isole(ligne, commande.date);

      fwrite(&commande, sizeof(COMMANDE), 1, fichierCommandes);
      fgets(ligne, 80, fichierTexteCommandes);
   }

   fclose(fichierCommandes);
   fclose(fichierTexteCommandes);

   return 0;
}
