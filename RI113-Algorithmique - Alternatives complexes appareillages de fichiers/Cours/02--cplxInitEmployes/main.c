/* ========================================================================== */
/* Projet : cplxInitEmployes                                                  */
/* -------------------------------------------------------------------------- */
/* initialisation des fichiers ancienEmp, creationEmp, modifEmp               */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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

   char nomfich[81];

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier employe (EMPancien, EMPcreation, EMPmodif)            */
/* -------------------------------------------------------------------------- */
   strcpy(nomfich,
      "u:\\bip\\formateur\\gnmi\\c\\cours_algo\\fichiers\\EMPancien");

   fichierEmp = fopen(nomfich, "wb");

   if (fichierEmp == NULL)
   {
      printf(" *** ERREUR OUVERTURE FICHIER EMPancien ***\n");
      exit(0);
   }

/* -------------------------------------------------------------------------- */
/* Saisie des employes                                                        */
/* -------------------------------------------------------------------------- */
   printf("\n\nNumero de l'employe : ");
   gets(employe.numero);

   while (employe.numero[0] != 0)
   {
      printf("Infos : ");
      gets(employe.infos);

      fwrite(&employe, sizeof(EMPLOYE), 1, fichierEmp);

      printf("\n\nNumero de l'employe : ");
      gets(employe.numero);
   }

   fclose(fichierEmp);

   return 0;
}
