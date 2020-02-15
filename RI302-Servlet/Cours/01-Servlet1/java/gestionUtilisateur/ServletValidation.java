// ==========================================================================
// ServletValidation.java : servlet du projet Servlet1
// --------------------------------------------------------------------------
// Recuperation des parametres saisis sur l'ecran index.html
// ==========================================================================

package gestionUtilisateur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletValidation extends HttpServlet
{
    private Validation validation;
    
    public void init()
    {
        validation = new Validation();
    }


    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException,
                   IOException
    {
        String nomUtil;
        String motPasseUtil;
        int resultatValidation;
        String affiche;

// --------------------------------------------------------------------------
// Remarques sur le codage
// --------------------------------------------------------------------------
// Dans le programme index.html, on a choisi l'encodage utf-8, pour pouvoir 
// utiliser un caractère spécial : '€', qui n'est pas dans la norme 
// iso-8859-1, en affichage comme en saisie. Il faut donc donner a la 
// request, en particulier a la methode getParameter(), le renseignement qui 
// lui permet d'interpreter correctement les caracteres saisis. De meme, il 
// faut preciser le codage utilise dans la reponse. Le type de la reponse 
// (setContentType) doit etre indique avant l'obtention du flux (getWriter). 
// A defaut de tous ces renseignements, tous les textes sont codes en 
// iso-8859-1 !
// --------------------------------------------------------------------------
// Bien entendu, le request.setCharacterEncoding doit etre fait avant la
// lecture des parametres (getParameter).
// --------------------------------------------------------------------------
        request.setCharacterEncoding("utf-8");
        nomUtil = request.getParameter("nomUtil");
        motPasseUtil = request.getParameter("motPasseUtil");
        
        resultatValidation = validation.valider(nomUtil, motPasseUtil);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter sortie = response.getWriter();

        try
        {
            if(resultatValidation == 2)
            {
                affiche = "<!DOCTYPE html>";

                affiche += "<html>";
                affiche += "<head>";
                affiche += "<title>Accès</title>";
                affiche += "<meta http-equiv=\"Content-Type\" ";
                affiche += "content=\"text/html; charset=utf-8\" />";
                affiche += "<link rel=\"stylesheet\" ";
                affiche += "type=\"text/css\" ";
                affiche += "href=\"miseEnPage.css\" />";
                affiche += "</head>";

                affiche += "<body>";
                affiche += "<p>";
                affiche += "Merci, " + nomUtil + ".";
                affiche += "</p>";
                affiche += "<p>";
                affiche += "Vous avez maintenant accès en " + 
                        request.getParameter("choixAcces") + 
                        " au système.";
                affiche += "</p>";
            }
            else
            {
                if(resultatValidation == 1)
                {
                    affiche = "<!DOCTYPE html>";

                    affiche += "<html>";
                    affiche += "<head>";
                    affiche += "<title>Mot de passe incorrect</title>";
                    affiche += "<meta http-equiv=\"Content-Type\" ";
                    affiche += "content=\"text/html; charset=utf-8\" />";
                    affiche += "<link rel=\"stylesheet\" ";
                    affiche += "type=\"text/css\" ";
                    affiche += "href=\"miseEnPage.css\" />";
                    affiche += "</head>";

                    affiche += "<body>";
                    affiche += "<p>";
                    affiche += "Attention, " + nomUtil + " !";
                    affiche += "</p>";
                    affiche += "<p>";
                    affiche += "Votre mot de passe est incorrect.";
                    affiche += "</p>";
                }
                else
                {
                    affiche = "<!DOCTYPE html>";

                    affiche += "<html>";
                    affiche += "<head>";
                    affiche += "<title>Utilisateur inconnu</title>";
                    affiche += "<meta http-equiv=\"Content-Type\" ";
                    affiche += "content=\"text/html; charset=utf-8\" />";
                    affiche += "<link rel=\"stylesheet\" ";
                    affiche += "type=\"text/css\" ";
                    affiche += "href=\"miseEnPage.css\" />";
                    affiche += "</head>";

                    affiche += "<body>";
                    affiche += "<p>";
                    affiche += "Désolé, " + nomUtil + " !";
                    affiche += "</p>";
                    affiche += "<p>";
                    affiche += "Vous êtes inconnu du système.";
                    affiche += "</p>";
                }
            }

            affiche += "</body>";
            affiche += "</html>";

            sortie.println(affiche);
        }
        finally
        {
            sortie.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException,
                   IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException,
                   IOException
    {
        processRequest(request, response);
    }
}
