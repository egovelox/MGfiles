/* ========================================================================== */
/* Projet : biblFractions                                                     */
/* -------------------------------------------------------------------------- */
/* fractions.h : DECLARATIONS POUR LA GESTION DES FRACTIONS                   */
/* ========================================================================== */

typedef struct
{
    int Num;
    int Den;
} FRACTION;

void saisie(FRACTION*);
void affiche(FRACTION);
FRACTION somme(FRACTION, FRACTION);
int pgcd(int, int);
