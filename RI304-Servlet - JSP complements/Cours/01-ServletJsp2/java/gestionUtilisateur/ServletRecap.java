package gestionUtilisateur;

// ==========================================================================
// ServletRecap.java : Servlet du projet Servlet2
// --------------------------------------------------------------------------
// Recuperation des parametres saisis sur l'ecran affiche par Donnees.java
// Affichage de ces donnees et de celles de index.html recuperees dans la
// session. 
// ==========================================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletRecap extends HttpServlet
{
   protected void processRequest(HttpServletRequest request,
                                 HttpServletResponse response)
                                 throws ServletException,
                                        IOException
   {
        ServletContext contexte;
        RequestDispatcher dispatcher;
        
        contexte = this.getServletContext();
        dispatcher = contexte.getRequestDispatcher("/recap.jsp");
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
