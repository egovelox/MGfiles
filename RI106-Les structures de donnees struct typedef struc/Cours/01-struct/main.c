/* ========================================================================== */
/* Projet : struct -- Structures de donnees                                   */
/* ========================================================================== */

#include <stdio.h>
#include <string.h>

/* -------------------------------------------------------------------------- */
/* La declaration suivante permet de definir un nouveau type de donnees.      */
/* Elle ne reserve pas d'espace en memoire.                                   */
/* -------------------------------------------------------------------------- */

struct STAGIAIRE
{
    int numero;                     /* Numero du stagiaire                     */
    char nom[51];                   /* Nom du stagiaire                        */
};

int main()
{
    struct STAGIAIRE s;        /* Declaration d'une variable de type STAGIAIRE */

                               /* Remarque : avec le compilateur de C++, il    */
                               /* n'est pas necessaire de repeter le mot       */
                               /* "struct". "STAGIAIRE s" suffit, mais         */
                               /* n'est pas standard...                        */


/* -------------------------------------------------------------------------- */
/* Initialisation des differentes proprietes de la variable s                 */
/* -------------------------------------------------------------------------- */
    s.numero = 10;
    strcpy(s.nom, "Pie");

/* -------------------------------------------------------------------------- */
/* Affichage des differentes proprietes de la variable s                      */
/* -------------------------------------------------------------------------- */
    printf("Stagiaire : %3d  %s\n\n", s.numero, s.nom);

    printf("Adresse numero : %p\n", &s.numero);
    printf("Adresse nom :    %p\n", s.nom);

    return 0;
}
