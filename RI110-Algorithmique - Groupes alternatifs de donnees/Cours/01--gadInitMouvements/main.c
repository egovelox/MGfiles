/* ========================================================================== */
/* Projet : gadInitMouvements -- Initialisation du fichier mouvements         */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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
   FILE * fichierMouvements;
   MOUVEMENT mouvement;

   char nomfich[201];
   char ligne[81];

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier mouvement                                             */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich, "C:\\C\\fichiers\\mouvements");

   fichierMouvements = fopen(nomfich, "wb");

   if (fichierMouvements == NULL)
   {
      printf(" *** ERREUR OUVERTURE FICHIER mouvements ***\n");
      exit(0);
   }

/* -------------------------------------------------------------------------- */
/* Saisie des mouvements                                                      */
/* -------------------------------------------------------------------------- */
   printf("\n\nNumero du produit : ");
   gets(mouvement.numeroProduit);

   while (mouvement.numeroProduit[0] != 0)
   {
      printf("Quantite : ");
      gets(ligne);
      mouvement.quantite = atoi(ligne);
      printf("Code : ");
      gets(ligne);
      mouvement.code = ligne[0];

      fwrite(&mouvement, sizeof(MOUVEMENT), 1, fichierMouvements);

      printf("\n\nNumero du produit : ");
      gets(mouvement.numeroProduit);
   }

   fclose(fichierMouvements);

   return 0;
}
