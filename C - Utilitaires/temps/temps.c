/* ========================================================================== */
/* Projet : temps                                                             */
/* -------------------------------------------------------------------------- */
/* temps.h : utilitaires de gestion de date                                   */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <time.h>
#include <string.h>


/* ===================================================================== */
/* Chaine date sur 6 caracteres (JJ/MM/AA)                               */
/* ===================================================================== */

void getDateSysteme6(char * dateSysteme)
{
   char date[9];

   _strdate(date);

   strncpy(dateSysteme, date + 3, 2);
   dateSysteme[2] = 0;
   strcat(dateSysteme, "/");

   strncat(dateSysteme, date, 2);
   dateSysteme[5] = 0;
   strcat(dateSysteme, "/");

   strncat(dateSysteme, date + 6, 2);
   dateSysteme[8] = 0;
}


/* ===================================================================== */
/* Chaine date sur 8 caracteres (JJ/MM/AAAA)                             */
/* ===================================================================== */

void getDateSysteme8(char * dateSysteme)
{
   char date[9];

   _strdate(date);

   strncpy(dateSysteme, date + 3, 2);
   dateSysteme[2] = 0;
   strcat(dateSysteme, "/");

   strncat(dateSysteme, date, 2);
   dateSysteme[5] = 0;
   strcat(dateSysteme, "/");

   strcat(dateSysteme, "20");
   strncat(dateSysteme, date + 6, 2);
   dateSysteme[10] = 0;
}
