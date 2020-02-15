/* ========================================================================== */
/* Projet : chaines                                                           */
/* -------------------------------------------------------------------------- */
/* chaines.c : utilitaires de traitement de chaines                           */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <string.h>
#include <stdio.h>
#include <math.h>
#include <limits.h>

#include "chaines.h"

/* ========================================================================== */
/* Recherche de la position du premier(pc) et du dernier(dc) caractere non    */
/* blanc d'une chaine.                                                        */
/*                                                                            */
/* Valeur retournee : 0    ==> normal                                         */
/*                    1    ==> chaine vide                                    */
/*                    2    ==> chaine entierement a blanc                     */
/* ========================================================================== */
int pcdc(char* chaine, int* pc, int *dc)
{
   int longChaine;
   int retour;

   retour = 0;
   longChaine = strlen(chaine);

   if (longChaine == 0)
   {
      retour = 1;
   }
   else
   {
      *pc = 0;

      while ((chaine[*pc] == ' ') && (*pc < longChaine))
      {
         (*pc)++;
      }

      if (*pc == longChaine)
      {
         retour = 2;
      }
      else
      {
         *dc = longChaine - 1;
         while (chaine[*dc] == ' ')
         {
            (*dc)--;
         }
      }
   }
   return retour;
}

/* ========================================================================== */
/* Longueur d'une chaine (du premier au dernier caractere non blanc)          */
/* ========================================================================== */
int lchaine(char* chaine)
{
   int longChaine;
   int pc, dc;
   int retour;

   retour = pcdc(chaine, &pc, &dc);

   if (retour == 0)
   {
      longChaine = dc - pc + 1;
   }
   else
   {
      longChaine = 0;
   }
   return longChaine;
}

/* ========================================================================== */
/* Cadrage à gauche d'une chaine : enlevement des blancs avant et apres       */
/* ========================================================================== */
void trim(char* chaine)
{
   int pc, dc;
   int retour;

   retour = pcdc(chaine, &pc, &dc);

   if (retour == 0)
   {
      chaine[dc + 1] = 0;
      strcpy(chaine, chaine + pc);
   }
}

/* ========================================================================== */
/* Inversion d'une chaine                                                     */
/* ========================================================================== */
void inverse(char* chaine)
{
   int i1;          /* Poste de gauche a inverser                             */
   int i2;          /* Poste de droite a inverser                             */
   char permut;     /* Caractere de permutation                               */

   i1 = 0;
   i2 = strlen(chaine) - 1;

   while (i1 < i2)
   {
      permut = chaine[i1];
      chaine[i1] = chaine[i2];
      chaine[i2] = permut;
      i1++;
      i2--;
   }
}

/* ========================================================================== */
/* Placer une sous-chaine dans une chaine, a une certaine position, avec      */
/* cadrage a gauche ou a droite de la position                                */
/* -------------------------------------------------------------------------- */
/* Parametres :                                                               */
/* chaine  : chaine a remplir                                                 */
/* sChaine : sous chaine a placer dans chaine                                 */
/* pos     : position de la sous-chaine dans la chaine (0 : debut)            */
/* sens    : 'g' ==> la sous-chaine est placee a gauche de pos                */
/*           'd' ==> la sous-chaine est placee a droite de pos                */
/* ========================================================================== */
void placeSousChaine(char* chaine, char* sChaine, int pos, char sens)
{
   int lChaine;
   int posFinSChaine;
   int i;

/* -------------------------------------------------------------------------- */
/* Position de la fin de la sous chaine                                       */
/* -------------------------------------------------------------------------- */
   if (sens == 'd')
   {
      posFinSChaine = pos + strlen(sChaine);
   }
   else
   {
      posFinSChaine = pos + 1;
   }

/* -------------------------------------------------------------------------- */
/* Si la position d'insertion est au dela de la fin de la chaine a remplir,   */
/* il faut completer par des blancs                                           */
/* -------------------------------------------------------------------------- */
   lChaine  = strlen(chaine);

   if (lChaine < posFinSChaine)
   {
      for (i = lChaine; i < posFinSChaine; i++)
      {
         chaine[i] = ' ';
      }
      chaine[i] = 0;
   }

/* -------------------------------------------------------------------------- */
/* Placement de la sous-chaine                                                */
/* -------------------------------------------------------------------------- */
   if (sens == 'd')
   {
      memcpy(chaine + pos, sChaine, strlen(sChaine));
   }
   else
   {
      memcpy(chaine + pos - strlen(sChaine) + 1, sChaine, strlen(sChaine));
   }
}

/* ========================================================================== */
/* Remplir une chaine avec un caractere, entre deux positions                 */
/* -------------------------------------------------------------------------- */
/* Parametres :                                                               */
/* chaine  : chaine a remplir                                                 */
/* caract  : caractere a placer dans chaine                                   */
/* pos1    : position du premier caractere insere                             */
/* pos2    : position du dernier caractere insere                             */
/* ========================================================================== */

void remplirChaine(char* chaine, char caract, int pos1, int pos2)
{
   int i;
   int lChaine;

/* -------------------------------------------------------------------------- */
/* Si la position de fin d'insertion est au dela de la fin de la chaine       */
/* remplir, il faut completer par des blancs                                  */
/* -------------------------------------------------------------------------- */
   lChaine  = strlen(chaine);

   if (lChaine < pos1)
   {
      for (i = lChaine; i < pos1; i++)
      {
         chaine[i] = ' ';
      }
   }

   if (pos2 >= lChaine)
   {
      chaine[pos2 + 1] = 0;
   }

/* -------------------------------------------------------------------------- */
/* Remplissage                                                                */
/* -------------------------------------------------------------------------- */
   for (i = pos1; i <= pos2; i++) chaine[i] = caract;
}

/* ========================================================================== */
/* Isoler une sous-chaine dans une chaine (les sous-chaines sont separees par */
/* des ;                                                                      */
/* -------------------------------------------------------------------------- */
/* Parametre d'entree   : chaine   ==> chaine a parcourir                     */
/* Parametre de sortie  : mot      ==> mot (sous-chaine) isole                */
/* Valeur retournee     : 0        ==> ; trouve                               */
/*                      : 1        ==> 0 trouve                               */
/* ========================================================================== */

int isole(char *chaine, char *mot)
{
   int i;
   int retour;

   i = 0;
   while ((chaine[i] != ';') && (chaine[i] != 0) && (chaine[i] != '\n'))
   {
      mot[i] = chaine[i];
      i++;
   }
   mot[i] = 0;

   if (chaine[i] == ';')
   {
      strcpy(chaine, chaine + i + 1);
      retour = 0;
   }
   else
   {
      retour = 1;
   }
   return retour;
}

/* ========================================================================== */
/* Mettre tous les caracteres d'une chaine a CHAR_MAX                         */
/* Cette fonction sert a la gestion des fins de fichiers                      */
/* ========================================================================== */

void chaineMax(char* chaine, int tailleTableauChaine)
{
   int i;

   for (i = 0; i < tailleTableauChaine - 1; i++) chaine[i] = CHAR_MAX;
   chaine[i] = 0;
}

/* ========================================================================== */
/* Conversion d'un double en chaine avec point decimal                        */
/* La chaine resultat est cadree a gauche (trim)                              */
/* -------------------------------------------------------------------------- */
/* Parametres :                                                               */
/* r       : double a convertir                                               */
/* ndec    : nombre de decimales a conserver apres la virgule                 */
/* chaine  : chaine resultat                                                  */
/* ========================================================================== */
char* doubleChaine(double r, char ndec, char* chaine)
{
    char format[21];
    char chaineNdec[11];

    strcpy(format, "%15.");
    sprintf(chaineNdec, "%d", ndec);
    strcat(format, chaineNdec);
    strcat(format, "f");

    sprintf(chaine, format, r);
    trim(chaine);
    return chaine;
}

/* ========================================================================== */
/* Conversion d'un double chaine avec virgule decimale                        */
/* La chaine resultat est cadree a gauche (trim)                              */
/* -------------------------------------------------------------------------- */
/* Parametres :                                                               */
/* r       : double a convertir                                               */
/* ndec    : nombre de decimales a conserver apres la virgule                 */
/* chaine  : chaine resultat                                                  */
/* ========================================================================== */
char* doubleChaineFr(double r, char ndec, char* chaine)
{
    char format[21];
    char chaineNdec[11];
    char* adresse;

    strcpy(format, "%15.");
    sprintf(chaineNdec, "%d", ndec);
    strcat(format, chaineNdec);
    strcat(format, "f");

    sprintf(chaine, format, r);

    adresse = strchr(chaine, '.');
    if(adresse != 0) *adresse = ',';
    trim(chaine);
    return chaine;
}

/* ========================================================================== */
/* Conversion d'une chaine de caracteres en reel                              */
/* -------------------------------------------------------------------------- */
/* Parametre d'entree   : chaine   ==> chaine a convertir                     */
/* Parametre de sortie  : r        ==> nombre reel                            */
/* Valeur retournee     : 0        ==> normal                                 */
/*                      : 1        ==> erreur                                 */
/* ========================================================================== */
int chaineDouble(char *chaine, double *r)
{
   char chif[11] = "0123456789";
   int  err;
   char ndec, signe;
   int  i, j, k;
   char chtrav[133];

/* -------------------------------------------------------------------------- */
/* Initialisation de la chaine de travail                                     */
/* -------------------------------------------------------------------------- */
   strcpy(chtrav, chaine);

/* -------------------------------------------------------------------------- */
/* Initialisations                                                            */
/* -------------------------------------------------------------------------- */
   *r = 0;
   err = 0;
   ndec = -1;

/* -------------------------------------------------------------------------- */
/* Cadrage la chaine et arret si elle est vide                                */
/* -------------------------------------------------------------------------- */
   trim(chtrav);
   if (strlen(chtrav) == 0)
   {
      err = 1;
   }
   else

/* -------------------------------------------------------------------------- */
/* Extraction du signe eventuel                                               */
/* -------------------------------------------------------------------------- */
   {
      signe = 1;
      if (chtrav[0] == '-')
      {
         signe = -1;
	      strcpy(chtrav, chtrav + 1);
      }
      if (chtrav[0] == '+')
      {
         strcpy(chtrav, chtrav + 1);
      }

/* -------------------------------------------------------------------------- */
/* Boucle de conversion                                                       */
/* -------------------------------------------------------------------------- */
      i = 0;

      do
      {

/* -------------------------------------------------------------------------- */
/* Les blancs et les points ne comptent pas                                   */
/* -------------------------------------------------------------------------- */
         if((chtrav[i] != '.') && (chtrav[i] != ' '))
         {

/* -------------------------------------------------------------------------- */
/* Virgule decimale                                                           */
/* -------------------------------------------------------------------------- */
            if (chtrav[i] == ',')
            {
               if (ndec == -1)
               {
                  ndec = 0;
               }
               else
               {
                  err = 2;
               }
            }
            else

/* -------------------------------------------------------------------------- */
/* Recherche du chiffre dans le tableau chif                                  */
/* -------------------------------------------------------------------------- */
            {
               k = -1;
               for (j = 0; j < 10; j++)
               {
                  if (chtrav[i] == chif[j]) k = j;
               }
               if (k == -1)
               {
                  err = 3;
               }
               else

/* -------------------------------------------------------------------------- */
/* Le chiffre est trouve ==> calcul                                           */
/* -------------------------------------------------------------------------- */
               {
                  *r = *r * 10 + k;
                  if (ndec >= 0) ndec++;
               }
            }
         }
         i++;
      }
      while ((i < (int)strlen(chtrav)) && (err == 0));
   }


/* -------------------------------------------------------------------------- */
/* Calcul final                                                               */
/* -------------------------------------------------------------------------- */
   if (ndec > 0) *r = *r / pow(10, ndec);
   *r *= signe;
   return(err);
}
