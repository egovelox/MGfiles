/* ========================================================================== */
/* Projet puissances -- Calcul du carre et du cube d'un nombre entier         */
/* ========================================================================== */

/* ========================================================================== */
/* DECLARATIONS                                                               */
/* ========================================================================== */
/* -------------------------------------------------------------------------- */
/* Declaration des fonctions carre() et cube()                                */
/* -------------------------------------------------------------------------- */
int carre(int nombre);
int cube(int);

#include <stdio.h>                      /* Pour printf()                      */
#include <stdlib.h>                     /* Pour srand() et rand()             */
#include <time.h>                       /* Pour time()                        */

/* ========================================================================== */
/* FONCTION carre                                                             */
/* ========================================================================== */

int carre(int nombre)
{
    return nombre * nombre;
}

/* ========================================================================== */
/* FONCTION cube                                                              */
/* ========================================================================== */

int cube(int nombre)
{
    return nombre * nombre * nombre;
}

/* ========================================================================== */
/* PROGRAMME PRINCIPAL                                                        */
/* ========================================================================== */

int main()
{
    int i;
    int n;

/* -------------------------------------------------------------------------- */
/* Tirage aleatoire de 10 valeurs.                                            */
/* Affichage de ces valeurs, de leur carre et de leur cube.                   */
/* -------------------------------------------------------------------------- */
/* La fonction srand() permet d'initialiser la serie de nombres aleatoires en */
/* utilisant la date et l'heure systeme. A defaut de l'utilisation de cette   */
/* fonction, la serie de nombres sera toujours la meme.                       */
/* -------------------------------------------------------------------------- */

    srand(time(NULL));

    for (i = 0; i < 10; i++)
    {
        n = rand() % 20;
        printf("Nombre : %2d   Carre : %3d   Cube : %5d\n", n, carre(n), cube(n));
    }

    return 0;
}
