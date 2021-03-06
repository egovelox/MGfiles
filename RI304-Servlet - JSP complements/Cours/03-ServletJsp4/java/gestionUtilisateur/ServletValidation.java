package gestionUtilisateur;

// ==========================================================================
// ServletValidation.java : servlet du projet testServlet4
// --------------------------------------------------------------------------
// Recuperation des parametres saisis sur l'ecran index.html
// ==========================================================================

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
        
        ServletContext contexte;
        RequestDispatcher dispatcher;
        Cookie cookNomUtil;

        request.setCharacterEncoding("utf-8");
        
        nomUtil = request.getParameter("nomUtil");
        motPasseUtil = request.getParameter("motPasseUtil");
        resultatValidation = validation.valider(nomUtil, motPasseUtil);
        
        contexte = getServletContext();
        
        if(resultatValidation == 2)
        {
            cookNomUtil = new Cookie("nomUtil", nomUtil);
            response.addCookie(cookNomUtil);
            dispatcher = contexte.getRequestDispatcher("/informations.html");
        }
        else
        {
            if(resultatValidation == 1)
            {
                dispatcher = contexte.getRequestDispatcher("/resultat1.jsp");
            }
            else
            {
                dispatcher = contexte.getRequestDispatcher("/resultat0.jsp");
            }
        }
        
        dispatcher.forward(request, response);
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
