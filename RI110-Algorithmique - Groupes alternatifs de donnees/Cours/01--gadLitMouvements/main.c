/* ========================================================================== */
/* Projet : gadLitMouvements -- Lecture du fichier mouvements                 */
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

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier mouvement                                             */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich, "C:\\C\\fichiers\\mouvements");

   fichierMouvements = fopen(nomfich, "rb");

   if (fichierMouvements == NULL)
   {
      printf(" *** ERREUR OUVERTURE FICHIER mouvements ***\n");
      exit(0);
   }

/* -------------------------------------------------------------------------- */
/* Boucle sur les mouvements                                                  */
/* -------------------------------------------------------------------------- */
   fread(&mouvement, sizeof(MOUVEMENT), 1, fichierMouvements);

   while (!feof(fichierMouvements))
   {
      printf("%3s  %5d   %c\n", mouvement.numeroProduit,
                                mouvement.quantite,
                                mouvement.code);

      fread(&mouvement, sizeof(MOUVEMENT), 1, fichierMouvements);
   }

   fclose(fichierMouvements);

   return 0;
}
