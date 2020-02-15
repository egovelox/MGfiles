/* ========================================================================== */
/* Projet : creationStagiaires -- Creation sequentielle d'un fichier binaire  */
/* -------------------------------------------------------------------------- */
/* Ce fichier va contenir une succession d'enregistrements de type STAGIAIRE  */
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
    STAGIAIRE s;            /* Variable de type STAGIAIRE destinée aux         */
                            /* lectures ou aux écritures sur le fichier        */
                            /*                                                 */
    int codeRetour;         /* Variable destinée à tester les codes retour des */
                            /* fonctions liées au fichier. Ce code retour      */
                            /* pourra être commun à plusieurs fichiers         */
                            /* ----------------------------------------------- */

    char ligne[81];         /* Ligne pour les saisies au clavier               */

/* -------------------------------------------------------------------------- */
/* Ouverture en ecriture (w) d'un fichier binaire (b)                         */
/* Attention ! Si le fichier existe deja, il est ECRASE !                     */
/* Si fopen retourne 0, l'ouverture s'est "plantee"                           */
/* -------------------------------------------------------------------------- */
    fichier = fopen("C:\\C\\fichiers\\stagiaires", "wb");
    if (fichier == 0)
    {
        printf(" *** Erreur d'ouverture du fichier stagiaires ***\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* Saisie du premier numero de stagiaire :                                            */
/* -------------------------------------------------------------------------- */
    printf("Numero de stagiaire : ");
    gets(ligne);

/* -------------------------------------------------------------------------- */
/* Boucle de saisie des stagiaires. Cette boucle se termine quand             */
/* l'utilisateur tape Entree en reponse au gets sur le numero. Le 0 final de  */
/* la chaine saisie est en première position (la chaine est vide)             */
/* -------------------------------------------------------------------------- */
    while (ligne[0] != 0)
    {
        s.numero = atoi(ligne);

/* -------------------------------------------------------------------------- */
/* Saisie du nom                                                              */
/* -------------------------------------------------------------------------- */
        printf("Nom : ");
        gets(s.nom);

/* -------------------------------------------------------------------------- */
/* Ecriture de la variable s dans le fichier                                  */
/* -------------------------------------------------------------------------- */
/* codeRetour reçoit le nombre de blocs effectivement écrits.                 */
/* Le nombre de blocs a ecrire est le troisieme parametre du fwrite (ici 1).  */
/* Si codeRetour < 1, il y a eu incident                                      */
/* -------------------------------------------------------------------------- */
        codeRetour = fwrite(&s, sizeof(STAGIAIRE), 1, fichier);
        printf("codeRetour = %d\n", codeRetour);

        printf("\n\nNumero de stagiaire : ");
        gets(ligne);
    }

    printf("Fin de l'enregistrement des stagiaires...\n\n");
    fclose(fichier);

    return 0;
}
