/* ========================================================================== */
/* Projet : biblGares                                                         */
/* -------------------------------------------------------------------------- */
/* gares.h (enquete RATP) : structure GARE et fonction de lecture du fichier  */
/* -------------------------------------------------------------------------- */
/* Auteur : Michel Gineste                                                    */
/* ========================================================================== */

#include <stdio.h>

/* -------------------------------------------------------------------------- */
/* Structure GARE                                                             */
/* -------------------------------------------------------------------------- */

typedef struct
{
    char numGare[3];
    char nomGare[31];
} GARE;

/* -------------------------------------------------------------------------- */
/* Fonction de lecture d'une gare                                             */
/* -------------------------------------------------------------------------- */
/* Pour lire le nom d'une gare, il faut initialiser la zone numGare de la     */
/* structure pointee par pGare, puis appeler la fonction. Si la gare est      */
/* trouvee la fonction retourne 1 et remplit nomGare, sinon elle retourne 0   */
/* -------------------------------------------------------------------------- */

int litGare(GARE* pGare, FILE* fichier);
