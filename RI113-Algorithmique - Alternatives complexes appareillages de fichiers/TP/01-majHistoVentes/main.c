/* ========================================================================== */
/* Projet : majHistoVentes  --  mise a jour de l'historique des ventes        */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "C:\C\utilitaires\entetes\chaines.h"


typedef struct
{
    char  noCli[5];
    char  dateFac[11];
    char  noProd[5];
    int   quantite;
    float prixHT;
} VENTE;

typedef struct
{
    char  noComm[7];
    char  noCli[5];
    char  noProd[5];
    int   quantite;
    char  desig[21];
    float prix;
    char  date[11];
} COMMANDE;


/* ========================================================================== */
/* PROGRAMME PRINCIPAL                                                        */
/* ========================================================================== */

int main(int argc, char* argv[])
{

/* -------------------------------------------------------------------------- */
/* VARIABLES                                                                  */
/* -------------------------------------------------------------------------- */
/* Variables pour l'utilisation des fichiers                                  */
/* -------------------------------------------------------------------------- */

    FILE* fichierVentes;
    VENTE vente;

    FILE* fichierVentes1;
    VENTE vente1;

    FILE* fichierCommandes;
    COMMANDE commande;

    FILE* fichierCommandesDep;
    COMMANDE commandeDep;

    char ppNocli[5];
    char dateFacturation[11];

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier binaire des ventes (en entree) (vente)                */
/* -------------------------------------------------------------------------- */
    fichierVentes = fopen("C:\\C\\fichiers\\vente", "rb");

    if (fichierVentes == NULL)
    {
        printf("***** ERREUR OUVERTURE FICHIER vente *****\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier binaire des commandes                                 */
/* -------------------------------------------------------------------------- */
    fichierCommandes = fopen("C:\\C\\fichiers\\comm", "rb");

    if (fichierCommandes == NULL)
    {
        printf("***** ERREUR OUVERTURE FICHIER comm *****\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier binaire des commandes de depannage                    */
/* -------------------------------------------------------------------------- */
    fichierCommandesDep = fopen("C:\\C\\fichiers\\commd", "rb");

    if (fichierCommandesDep == NULL)
    {
        printf("***** ERREUR OUVERTURE FICHIER commd *****\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* Ouverture du fichier binaire des ventes (en sortie) (vente1)               */
/* -------------------------------------------------------------------------- */
    fichierVentes1 = fopen("C:\\C\\fichiers\\vente1", "wb");

    if (fichierVentes1 == NULL)
    {
        printf("***** ERREUR OUVERTURE FICHIER vente1 *****\n");
        exit(0);
    }

/* -------------------------------------------------------------------------- */
/* DEBUT                                                                      */
/* -------------------------------------------------------------------------- */
    if (argc > 1)
    {
        strcpy(dateFacturation, argv[1]);
    }
    else
    {
        printf("Entrer la date de facturation : ");
        gets(dateFacturation);
    }

    fread(&vente,  sizeof(VENTE), 1, fichierVentes);
    if (feof(fichierVentes))
        chaineMax(vente.noCli, sizeof(vente.noCli));

    fread(&commande,  sizeof(COMMANDE), 1, fichierCommandes);
    if (feof(fichierCommandes))
        chaineMax(commande.noCli, sizeof(commande.noCli));

    fread(&commandeDep, sizeof(COMMANDE), 1, fichierCommandesDep);
    if (feof(fichierCommandesDep))
        chaineMax(commandeDep.noCli, sizeof(commandeDep.noCli));

    do
    {

/* -------------------------------------------------------------------------- */
/* DEBUT CLIENT                                                               */
/* -------------------------------------------------------------------------- */
/* Appareillage                                                               */
/* -------------------------------------------------------------------------- */
        if (strcmp(vente.noCli, commande.noCli) < 0)
        {
            strcpy(ppNocli, vente.noCli);
        }
        else
        {
            strcpy(ppNocli, commande.noCli);
        }

        if (strcmp(commandeDep.noCli, ppNocli) < 0)
        {
            strcpy(ppNocli, commandeDep.noCli);
        }

/* -------------------------------------------------------------------------- */
/* Y-a-t'il d'anciennes ventes ?                                              */
/* -------------------------------------------------------------------------- */
        if (strcmp(ppNocli, vente.noCli) == 0)
        {
            do
            {
                vente1 = vente;
                fwrite(&vente1, sizeof(VENTE), 1, fichierVentes1);

                fread(&vente,  sizeof(VENTE), 1, fichierVentes);
                if (feof(fichierVentes))
                    chaineMax(vente.noCli, sizeof(vente.noCli));
            }
            while(strcmp(ppNocli, vente.noCli) == 0);
        }

/* -------------------------------------------------------------------------- */
/* Y-a-t'il des commandes ?                                                   */
/* -------------------------------------------------------------------------- */
        if (strcmp(ppNocli, commande.noCli) == 0)
        {
            do
            {
                strcpy(vente1.noCli, commande.noCli);
                strcpy(vente1.dateFac, dateFacturation);
                strcpy(vente1.noProd, commande.noProd);
                vente1.quantite = commande.quantite;
                vente1.prixHT = commande.quantite * commande.prix;
                fwrite(&vente1, sizeof(VENTE), 1, fichierVentes1);

                fread(&commande,  sizeof(COMMANDE), 1, fichierCommandes);
                if (feof(fichierCommandes))
                    chaineMax(commande.noCli, sizeof(commande.noCli));
            }
            while(strcmp(ppNocli, commande.noCli) == 0);
        }

/* -------------------------------------------------------------------------- */
/* Y-a-t'il des commandes de depannage ?                                      */
/* -------------------------------------------------------------------------- */
        if (strcmp(ppNocli, commandeDep.noCli) == 0)
        {
            do
            {
                strcpy(vente1.noCli, commandeDep.noCli);
                strcpy(vente1.dateFac, dateFacturation);
                strcpy(vente1.noProd, commandeDep.noProd);
                vente1.quantite = commandeDep.quantite;
                vente1.prixHT = commandeDep.quantite * commandeDep.prix;
                fwrite(&vente1, sizeof(VENTE), 1, fichierVentes1);

                fread(&commandeDep,  sizeof(COMMANDE), 1, fichierCommandesDep);
                if (feof(fichierCommandesDep))
                    chaineMax(commandeDep.noCli, sizeof(commandeDep.noCli));
            }
            while(strcmp(ppNocli, commandeDep.noCli) == 0);
        }

/* -------------------------------------------------------------------------- */
/* FIN CLIENT                                                                 */
/* -------------------------------------------------------------------------- */
    }
    while((!feof(fichierVentes)) ||
            (!feof(fichierCommandes)) ||
            (!feof(fichierCommandesDep)));

    fclose(fichierVentes);
    fclose(fichierCommandes);
    fclose(fichierCommandesDep);

    return 0;
}
