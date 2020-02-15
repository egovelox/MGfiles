/* ========================================================================== */
/* Projet : gadInitAncienStock -- Initialisation du fichier ancienStock       */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* -------------------------------------------------------------------------- */
/* Structure PRODUIT                                                          */
/* -------------------------------------------------------------------------- */

typedef struct
{
   char numero[3];
   char libelle[21];
   int  quantite;
} PRODUIT;


int main()
{
   FILE* fichierAS;
   PRODUIT produit;

   char nomfich[81];
   char ligne[81];

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier ancien stock                                          */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich,
      "u:\\bip\\formateur\\gnmi\\c\\cours_algo\\fichiers\\ancienStock");

   fichierAS = fopen(nomfich, "wb");

   if (fichierAS == NULL)
   {
      printf(" *** ERREUR OUVERTURE FICHIER ancienStock ***\n");
      exit(0);
   }

/* -------------------------------------------------------------------------- */
/* Saisie des produits (ancien stock)                                         */
/* -------------------------------------------------------------------------- */
   printf("\n\nNumero du produit : ");
   gets(produit.numero);

   while (produit.numero[0] != 0)
   {
      printf("Libelle du produit : ");
      gets(produit.libelle);
      printf("Quantite : ");
      gets(ligne);
      produit.quantite = atoi(ligne);

      fwrite(&produit, sizeof(PRODUIT), 1, fichierAS);

      printf("\n\nNumero du produit : ");
      gets(produit.numero);
   }

   fclose(fichierAS);

   return 0;
}
