/* ========================================================================== */
/* Projet : lectureStagiaires                                                 */
/* -------------------------------------------------------------------------- */
/*          Lecture sequentielle du fichier binaire "stagiaires"              */
/*          Ecriture dans un fichier texte "editStagiaires.txt"               */
/* -------------------------------------------------------------------------- */
/* Ce fichier contient une succession d'enregistrements de type STAGIAIRES    */
/* ========================================================================== */


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct
{
    int numero;
    char nom[51];
} STAGIAIRE;


int main()
{
                            /* ----------------------------------------------- */
    FILE* fichier;          /* Pointeur vers le fichier                        */
                            /*                                                 */
    FILE* edition;          /* Pointeur vers le fichier texte d'edition        */
                            /*                                                 */
    STAGIAIRE s;            /* Variable de type STAGIAIRE destinée aux         */
                            /* lectures ou aux écritures sur le fichier        */
                            /* ----------------------------------------------- */

/* -------------------------------------------------------------------------- */
/* Ouverture en lecture (r) du fichier binaire (b)                            */
/* -------------------------------------------------------------------------- */
    fichier = fopen("C:\\C\\fichiers\\stagiaires", "rb");
    if (fichier == 0)
    {
        printf(" *** Erreur d'ouverture du fichier stagiaires ***");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier et controle d'erreur                                  */
/* -------------------------------------------------------------------------- */
    edition = fopen("C:\\C\\fichiers\\editStagiaires.txt", "wt");
    if (edition == 0)
    {
        printf(" *** ERREUR OUVERTURE FICHIER EDITION ***");
        exit(1);
    }

/* -------------------------------------------------------------------------- */
/* Boucle de lecture et d'affichage du fichier                                */
/* -------------------------------------------------------------------------- */
    printf("LISTE DES STAGIAIRES\n\n");
    fprintf(edition, "LISTE DES STAGIAIRES\n\n");

/* -------------------------------------------------------------------------- */
/* codeRetour reçoit le nombre de blocs effectivement lus.                    */
/* Il est possible d'ecrire le test de la boucle : while (codeRetour !=0).    */
/* while (!feof(fichier)) peut se lire : tant qu'on n'est pas en fin de       */
/* fichier. C'est plus facile a lire.                                         */
/* -------------------------------------------------------------------------- */
    fread(&s, sizeof(STAGIAIRE), 1, fichier);

    while (!feof(fichier))
    {
        printf("%3d  %s\n", s.numero, s.nom);
        fprintf(edition, "%3d  %s\n", s.numero, s.nom);
        fread(&s, sizeof(STAGIAIRE), 1, fichier);
    }

    fclose(fichier);
    fclose(edition);

    return 0;
}
