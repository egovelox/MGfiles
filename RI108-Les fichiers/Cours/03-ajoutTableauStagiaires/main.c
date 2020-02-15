/* ========================================================================== */
/* Projet : ajoutTableauStagiaires -- Ajout séquentiel                        */
/* -------------------------------------------------------------------------- */
/* On ajoute 3 stagiaires contenus dans un tableau au fichier                 */
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
    STAGIAIRE tabStag[3];   /* Tableau de 3 variables de type STAGIAIRE a      */
                            /* ajouter au fichier                              */
                            /* ----------------------------------------------- */
    int codeRetour;

/* -------------------------------------------------------------------------- */
/* Ouverture en ajout (a) d'un fichier binaire (b)                            */
/* -------------------------------------------------------------------------- */
    fichier = fopen("C:\\C\\fichiers\\stagiaires", "ab");
    if (fichier == 0)
    {
        printf(" *** Erreur d'ouverture du fichier stagiaire ***\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* Remplissage du tableau de stagiaires :                                     */
/* -------------------------------------------------------------------------- */
    tabStag[0].numero = 150;
    strcpy(tabStag[0].nom, "PERDREAU");
    tabStag[1].numero = 151;
    strcpy(tabStag[1].nom, "BOUVREUIL");
    tabStag[2].numero = 152;
    strcpy(tabStag[2].nom, "TICHODROME");

/* -------------------------------------------------------------------------- */
/* Ecriture du tableau dans le fichier                                  */
/* -------------------------------------------------------------------------- */
    codeRetour = fwrite(tabStag, sizeof(STAGIAIRE), 3, fichier);
    printf("codeRetour = %d\n", codeRetour);

    printf("Fin de l'enregistrement des stagiaires...\n\n");
    fclose(fichier);

    return 0;
}
