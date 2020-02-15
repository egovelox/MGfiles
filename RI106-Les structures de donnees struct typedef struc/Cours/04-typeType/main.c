/* ========================================================================== */
/* Projet : typeType -- Structures contenant des structures                   */
/* ========================================================================== */

#include <stdio.h>
#include <string.h>

typedef struct
{
    char rue[51];
    char code_postal[6];
    char ville[51];
} ADRESSE;

typedef struct
{
    int numero;                     /* Numero de l'employe                     */
    char nom[51];                   /* Nom de l'employe                        */
    ADRESSE adresse;                /* Adresse de l'employe                    */
} EMPLOYE;


int main()
{
    EMPLOYE employe;

/* -------------------------------------------------------------------------- */
/* Initialisation des differentes proprietes de la variable employe           */
/* -------------------------------------------------------------------------- */
    employe.numero = 10;
    strcpy(employe.nom, "Oie bernache");
    strcpy(employe.adresse.rue, "1, rue des Etangs");
    strcpy(employe.adresse.code_postal, "80230");
    strcpy(employe.adresse.ville, "SAINT VALERY");

/* -------------------------------------------------------------------------- */
/* Affichage des differentes proprietes de la variable employe                */
/* -------------------------------------------------------------------------- */
    printf("Employe : %3d  %s\n\n%s\n%s\n%s\n", employe.numero,
           employe.nom,
           employe.adresse.rue,
           employe.adresse.code_postal,
           employe.adresse.ville);

    return 0;
}
