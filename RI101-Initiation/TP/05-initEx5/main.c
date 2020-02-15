/* ========================================================================== */
/* initEx5                                                                    */
/* -------------------------------------------------------------------------- */
/* Saisir un nombre (n).                                                      */
/*                                                                            */
/* Si ce nombre est premier, afficher : "n" est un nombre premier.            */
/* sinon, afficher :                    "n" est divisible par "div".          */
/*                                                                            */
/* Recommencer cette op�ration jusqu'� ce que 3 nombres premiers aient ete    */
/* saisis.                                                                    */
/* ========================================================================== */

#include <stdio.h>

int main()
{
    int n;                          /* Nombre saisi par l'utilisateur         */
    int div;                        /* Diviseur du nombre n                   */
    int reste;                      /* Reste de la division de n par div      */

    int nbPremiers;                 /* Nombre de nombres premiers deja saisis */

    nbPremiers = 0;

    while (nbPremiers < 3)
    {

        /* -------------------------------------------------------------------------- */
        /* Pour d�terminer si un nombre n est premier, on va examiner le reste de la  */
        /* division de ce nombre par tous les entiers div  <= n, en commen�ant par 2. */
        /* Si le premier reste nul est egal a n, n est premier...                     */
        /* Un cas particulier est prevu pour la saisie de la valeur 1.                */
        /* -------------------------------------------------------------------------- */

        printf("Entrer un nombre : ");
        scanf("%d", &n);

        if (n == 1)
        {
            printf("1 n'est pas un nombre premier.\n\n");
        }
        else
        {
            div = 2;
            reste = n % div;

            while (reste != 0)
            {
                div ++;
                reste = n % div;
            }

            if (div < n)
            {
                printf("%d est divisible par %d.\n\n", n, div);
            }
            else
            {
                printf("%d est un nombre premier.\n\n", n);
                nbPremiers++;
            }
        }
    }

    printf("FIN DE LA BOUCLE DE SAISIE\n\n");
    return 0;
}

