package gestionUtilisateur;

// ==========================================================================
// ServletValidation.java : servlet du projet testServlet1
// --------------------------------------------------------------------------
// Recuperation des parametres saisis sur l'ecran index.html
// ==========================================================================

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletValidation extends HttpServlet
{
    private String nomUtil;
    private String motPasseUtil;
    private int temporisation;

// --------------------------------------------------------------------------
// Surcharge de la methode init() heritee de GenericServlet.
// --------------------------------------------------------------------------
// Initialisation d'une propriete qui sera fixe pour toute la vie de la
// Servlet.
// --------------------------------------------------------------------------
    @Override
    public void init() throws ServletException
    {

// --------------------------------------------------------------------------
// getInitParameter("temporisation") permet de lire le parametre 
// d'initialisation de la servlet nomme "temporisation".
// --------------------------------------------------------------------------
// Il s'agit ici de mettre la méthode executeRequete en attente pendant 10000
// milli-secondes (10 secondes). Un client pourra ainsi lancer la methode 
// avant qu'elle ne s'acheve pour un client precedent.
// --------------------------------------------------------------------------
        temporisation = Integer.parseInt(getInitParameter("temporisation"));
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException,
                   IOException
    {
        Validation validation = new Validation();
        int resultatValidation;
        
        ServletContext contexte;
        RequestDispatcher dispatcher;
        HttpSession session;

        request.setCharacterEncoding("utf-8");
        nomUtil = request.getParameter("nomUtil");
        motPasseUtil = request.getParameter("motPasseUtil");
        
        resultatValidation = validation.valider(nomUtil, motPasseUtil);
        
        try
        {
            Thread.sleep(temporisation);
        }
        catch (InterruptedException e)
        {
        }

        contexte = this.getServletContext();
        
        if(resultatValidation == 2)
        {
            session = request.getSession();
            session.setAttribute("nomUtil", nomUtil);
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