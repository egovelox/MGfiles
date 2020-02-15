/* ========================================================================== */
/* Projet : gadMajStock                                                       */
/* -------------------------------------------------------------------------- */
/* Mise à jour du fichier nouveau stock a partir des fichiers ancienStock et  */
/* mouvements                                                                 */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/* -------------------------------------------------------------------------- */
/* Structure PRODUIT                                                          */
/* -------------------------------------------------------------------------- */

typedef struct
{
    char numero[3];
    char libelle[21];
    int  quantite;
} PRODUIT;

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
    PRODUIT produitAS, produitNS;
    MOUVEMENT mouvement;

    FILE* fichierAS;
    FILE* fichierMouvements;
    FILE* fichierNS;

/* -------------------------------------------------------------------------- */
/* Ouverture des fichiers                                                     */
/* -------------------------------------------------------------------------- */
    fichierAS = fopen("C:\\C\\fichiers\\ancienStock", "rb");

    if (fichierAS == NULL)
    {
        printf(" *** ERREUR OUVERTURE FICHIER ancienStock ***\n");
        exit(0);
    }

    fichierMouvements = fopen("C:\\C\\fichiers\\mouvements", "rb");

    if (fichierMouvements == NULL)
    {
        printf(" *** ERREUR OUVERTURE FICHIER mouvements ***\n");
        exit(0);
    }

    fichierNS = fopen("C:\\C\\fichiers\\nouveauStock", "wb");

    if (fichierNS == NULL)
    {
        printf(" *** ERREUR OUVERTURE FICHIER nouveauStock ***\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* DEBUT PROGRAMME                                                            */
/* -------------------------------------------------------------------------- */
    fread(&produitAS, sizeof(PRODUIT), 1, fichierAS);
    fread(&mouvement, sizeof(MOUVEMENT), 1, fichierMouvements);

    do
    {

/* -------------------------------------------------------------------------- */
/* DEBUT PRODUIT                                                              */
/* -------------------------------------------------------------------------- */
        strcpy(produitNS.numero, produitAS.numero);
        strcpy(produitNS.libelle, produitAS.libelle);
        produitNS.quantite = produitAS.quantite;

        if ((!feof(fichierMouvements)) &&
                (strcmp(produitAS.numero, mouvement.numeroProduit) == 0))
        {

/* -------------------------------------------------------------------------- */
/* DEBUT GROUPE MOUVEMENTS                                                    */
/* -------------------------------------------------------------------------- */
            do
            {

/* -------------------------------------------------------------------------- */
/* DEBUT MOUVEMENT                                                            */
/* -------------------------------------------------------------------------- */
                if (mouvement.code == 'E')
                {
                    produitNS.quantite += mouvement.quantite;
                }
                else
                {
                    produitNS.quantite -= mouvement.quantite;
                }


/* -------------------------------------------------------------------------- */
/* FIN MOUVEMENT                                                              */
/* -------------------------------------------------------------------------- */
                fread(&mouvement, sizeof(MOUVEMENT), 1, fichierMouvements);
            }
            while ((!feof(fichierMouvements)) &&
                    (strcmp(produitAS.numero, mouvement.numeroProduit) == 0));

/* -------------------------------------------------------------------------- */
/* FIN GROUPE MOUVEMENTS                                                      */
/* -------------------------------------------------------------------------- */
        }

/* -------------------------------------------------------------------------- */
/* FIN PRODUIT                                                                */
/* -------------------------------------------------------------------------- */
        printf("%3s   %-20s   %4d\n", produitNS.numero,
               produitNS.libelle,
               produitNS.quantite);

        fwrite(&produitNS, sizeof(PRODUIT), 1, fichierNS);
        fread(&produitAS, sizeof(PRODUIT), 1, fichierAS);
    }
    while (!feof(fichierAS));

/* -------------------------------------------------------------------------- */
/* FIN PROGRAMME                                                              */
/* -------------------------------------------------------------------------- */
    fclose(fichierAS);
    fclose(fichierMouvements);
    fclose(fichierNS);

    return 0;
}
