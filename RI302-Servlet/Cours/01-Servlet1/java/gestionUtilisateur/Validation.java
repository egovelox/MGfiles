// ==========================================================================
// Validation : classe de validation des utilisateurs
// ==========================================================================

package gestionUtilisateur;

import java.util.ArrayList;

public class Validation
{
    private ArrayList<Utilisateur> listeUtilisateurs;
    
    public Validation()
    {
        listeUtilisateurs = new ArrayList();
        listeUtilisateurs.add(new Utilisateur("Oie", "Bernache"));
        listeUtilisateurs.add(new Utilisateur("Vautour", "Fauv€"));
        listeUtilisateurs.add(new Utilisateur("Aigle", "Royal"));
        listeUtilisateurs.add(new Utilisateur("Canard", "Colvert"));
        listeUtilisateurs.add(new Utilisateur("Aigle", "Botté"));
        listeUtilisateurs.add(new Utilisateur("Pie", "GRièche"));
    }
    
// --------------------------------------------------------------------------
// La methode valider() vérifie que le nom et le mot de passe sont dans la
// liste des utilisateurs. 
// --------------------------------------------------------------------------
// Elle retourne : 
// 2 si tout est bon, 1 si seul le nom est bon, 0 si tout est faux.    
// --------------------------------------------------------------------------
    public int valider(String nomUtil, String motPasseUtil)
    {
        int i, retour;
        retour = 0;

        nomUtil = nomUtil.trim();
        
        i = 0;
        while((i < listeUtilisateurs.size()) && (retour < 2))
        {
            if(nomUtil.compareToIgnoreCase(
                    (listeUtilisateurs.get(i)).getNomUtil()) == 0)
            {
                retour = 1;
                if(motPasseUtil.compareTo(
                        (listeUtilisateurs.get(i)).getMotPasseUtil()) == 0)
                {
                    retour = 2;
                }
            }
            i++;
        }
        return retour;
    }
}
