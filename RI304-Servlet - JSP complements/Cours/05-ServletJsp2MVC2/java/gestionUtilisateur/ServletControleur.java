package gestionUtilisateur;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletControleur extends HttpServlet
{
    private Validation validation;
    
    public void init()
    {
        validation = new Validation();
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
        throws ServletException, IOException
    {
        Integer idEcran;
        
        String nomUtil;
        String motPasseUtil;
        int resultatValidation;

        ServletContext contexte;
        RequestDispatcher dispatcher;
        HttpSession session;

        request.setCharacterEncoding("UTF-8");

// --------------------------------------------------------------------------
// Recuperation du SerletContext pour dispatcher...
// --------------------------------------------------------------------------
        contexte = getServletContext();

// --------------------------------------------------------------------------
// Lecture de l'identifiant de l'ecran (champ cache ou parametre d'index.jsp)
// --------------------------------------------------------------------------
        String numeroEcran = request.getParameter("idEcran");
        idEcran = new Integer(numeroEcran);

// --------------------------------------------------------------------------
// Divers branchements suivant l'ecran qui vient d'appeler ServletControleur
// --------------------------------------------------------------------------
        switch (idEcran)
        {

// --------------------------------------------------------------------------
// On vient de l'ecran accueil
// --------------------------------------------------------------------------
            case 1:
                nomUtil = request.getParameter("nomUtil");
                motPasseUtil = request.getParameter("motPasseUtil");
                resultatValidation = validation.valider(nomUtil, motPasseUtil);

                if(resultatValidation == 2)
                {
                    session = request.getSession();
                    session.setAttribute("nomUtil", nomUtil);
                    dispatcher = 
                            contexte.getRequestDispatcher("/informations.html");
                }
                else
                {
                    if(resultatValidation == 1)
                    {
                        dispatcher = 
                                contexte.getRequestDispatcher("/resultat1.jsp");
                    }
                    else
                    {
                        dispatcher = 
                                contexte.getRequestDispatcher("/resultat0.jsp");
                    }
                }

                break;

// --------------------------------------------------------------------------
// On vient de l'ecran informations.html
// --------------------------------------------------------------------------
            case 4:
                dispatcher = contexte.getRequestDispatcher("/recap.jsp");
                break;

            default:
                dispatcher = contexte.getRequestDispatcher("/accueil.jsp");
        }

        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }
}
