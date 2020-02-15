/* ========================================================================== */
/* Projet : cplxLitEmployes                                                  */
/* -------------------------------------------------------------------------- */
/* Affichage d'un fichier employe (EMPancien, EMPcreation, EMPmodif)          */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/* -------------------------------------------------------------------------- */
/* Structure EMPLOYE                                                          */
/* -------------------------------------------------------------------------- */

typedef struct
{
   char numero[3];
   char infos[21];
} EMPLOYE;


int main()
{
   FILE* fichierEmp;
   EMPLOYE employe;

   char nomfich[201];

   strcpy(nomfich, "C:\\C\\fichiers\\EMPancien");

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier                                                       */
/* -------------------------------------------------------------------------- */
   fichierEmp = fopen(nomfich, "rb");

   if (fichierEmp == NULL)
   {
      printf(" *** ERREUR OUVERTURE FICHIER employes ***\n");
      exit(0);
   }

/* -------------------------------------------------------------------------- */
/* Debut programme                                                            */
/* -------------------------------------------------------------------------- */
   fread(&employe, sizeof(EMPLOYE), 1, fichierEmp);

   do
   {
      printf("%3s   %-20s\n", employe.numero, employe.infos);

      fread(&employe, sizeof(EMPLOYE), 1, fichierEmp);
   }
   while (!feof(fichierEmp));

/* -------------------------------------------------------------------------- */
/* Fermeture du fichier                                                       */
/* -------------------------------------------------------------------------- */
   fclose(fichierEmp);

   return 0;
}
