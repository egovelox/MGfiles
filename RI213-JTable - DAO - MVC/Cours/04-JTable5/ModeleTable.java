// ==========================================================================
// Classe ModeleTable                                     Application JTable5
// -------------------------------------------------------------------------- 
// Modele de table constitue a partir d'un vecteur de lignes et d'un vecteur
// de colonnes (objets "Colonne").
// ==========================================================================

import javax.swing.table.*;
import java.util.*;
import utilitairesMG.divers.*;

public class ModeleTable extends AbstractTableModel
{
    private Vector<Vector<Object>> listeLignes;
    private Vector<Colonne> listeColonnes;

// -------------------------------------------------------------------------- 
// Constructeurs
// -------------------------------------------------------------------------- 
    public ModeleTable()
    {
    }

    public ModeleTable(Vector<Vector<Object>> listeLignes,
                       Vector<Colonne> listeColonnes)
    {
        this.listeLignes = listeLignes;
        this.listeColonnes = listeColonnes;
    }

// -------------------------------------------------------------------------- 
// Initialisation de la liste des lignes
// -------------------------------------------------------------------------- 
    public void setListeLignes(Vector<Vector<Object>> listeLignes)
    {
        this.listeLignes = listeLignes;
    }

// -------------------------------------------------------------------------- 
// Initialisation de la liste des colonnes
// -------------------------------------------------------------------------- 
    public void setListeColonnes(Vector<Colonne> listeColonnes)
    {
        this.listeColonnes = listeColonnes;
    }

// -------------------------------------------------------------------------- 
// Getters pour les differentes listes
// -------------------------------------------------------------------------- 
    public Vector<Vector<Object>> getListeLignes()
    {
        return listeLignes;
    }

    public Vector<Colonne> getListeColonnes()
    {
        return listeColonnes;
    }

// -------------------------------------------------------------------------- 
// getRowCount : nombre de lignes de la JTable
// -------------------------------------------------------------------------- 
    public int getRowCount()
    {
        return listeLignes.size();
    }

// -------------------------------------------------------------------------- 
// getColumnCount : nombre de colonnes de la JTable
// -------------------------------------------------------------------------- 
    public int getColumnCount()
    {
        return listeColonnes.size();
    }

// -------------------------------------------------------------------------- 
// getValueAt : "Object" qui s'affiche en ligne lig et en colonne col
// -------------------------------------------------------------------------- 
    public Object getValueAt(int lig, int col)
    {
        Object valeur;
        Vector<Object> ligne;

        ligne = listeLignes.elementAt(lig);
        valeur = ligne.elementAt(col);

        return valeur;
    }

// -------------------------------------------------------------------------- 
// getColumnClass : 
// retourne un objet Class correspondant au type de la colonne col.
// -------------------------------------------------------------------------- 
// Ce renseignement permet a la JTable d'adapter l'affichage au type de
// donnees de la colonne. Ainsi, les booleens apparaissent en case a cocher, 
// les valeurs numeriques sont cadrees a droite...
// -------------------------------------------------------------------------- 
    public Class getColumnClass(int col)
    {
        Class classe = null;

        try
        {
            classe = Class.forName(listeColonnes.elementAt(col).getType());
        }
        catch (ClassNotFoundException e)
        {
        }
        return classe;
    }
}
