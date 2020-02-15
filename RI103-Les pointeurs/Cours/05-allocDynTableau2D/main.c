/* ========================================================================== */
/* Projet : allocDynTableau2D                                                 */
/* -------------------------------------------------------------------------- */
/* Allocation dynamique d'un tableau � deux dimensions                        */
/* ========================================================================== */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int* tableau;
    int nLig, nCol;

/* -------------------------------------------------------------------------- */
/* Allocation dynamique du tableau (2 lignes, 3 colonnes : 6 postes)          */
/* -------------------------------------------------------------------------- */
    tableau = (int*)calloc(6, sizeof(int));

/* -------------------------------------------------------------------------- */
/* Initialisation du g�n�rateur de nombres al�atoires                         */
/* -------------------------------------------------------------------------- */
    srand((unsigned)time(NULL));

/* -------------------------------------------------------------------------- */
/* On ne peut plus utiliser la notation tab[i][j] car cette notation          */
/* suppose que l'on connaisse la taille d'une ligne. L'allocation dynamique   */
/* ne permet pas d'avoir ce renseignement... On peut malgr� tout utiliser     */
/* deux indices, mais en se chargeant soit m�me du calcul...                  */
/* -------------------------------------------------------------------------- */
    for (nLig = 0; nLig < 2; nLig++)
    {
        for (nCol = 0; nCol < 3; nCol++)
        {
            *(tableau + (3 * nLig) + nCol) = rand() % 100;
        }
    }

/* -------------------------------------------------------------------------- */
/* Affichage du tableau                                                       */
/* -------------------------------------------------------------------------- */
    for (nLig = 0; nLig < 2; nLig++)
    {
        for (nCol = 0; nCol < 3; nCol++)
        {
            printf("tableau[%d][%d] = %5d ",
                   nLig, nCol, *(tableau + (3 * nLig) + nCol));
        }
        printf("\n");
    }
    printf("\n\n");

    return 0;
}
