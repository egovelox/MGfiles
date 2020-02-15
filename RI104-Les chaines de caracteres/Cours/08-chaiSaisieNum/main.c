/* ========================================================================== */
/* Projet : chaiSaisieNum                                                     */
/* -------------------------------------------------------------------------- */
/* Utilisation des chaines pour les saisies numeriques                        */
/* -------------------------------------------------------------------------- */
/* Le couple :                                                                */
/*    gets(ligne); sscanf(ligne, "%d", &i);                                   */
/*                                                                            */
/* est preferable a :                                                         */
/*    scanf("%d", &i);                                                        */
/*                                                                            */
/* car il permet de verifier la saisie avant de faire la conversion en int.   */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int i;
    double x;

    int retour;

    char ligne[81];

    printf("Saisir l'entier i : ");
    gets(ligne);
    retour = sscanf(ligne, "%d", &i);
    printf("Retour : %d   i : %d\n", retour, i);

    printf("\n\nSaisir le double x : ");
    gets(ligne);
    retour = sscanf(ligne, "%lf", &x);
    printf("Retour : %d   x : %lf\n", retour, x);

    return 0;
}
