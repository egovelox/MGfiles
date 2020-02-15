<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8");
    String texte1 = request.getParameter("texte1");
    String texte2 = request.getParameter("texte2");
    String texte3 = request.getParameter("texte3");
    Cookie tableCookies[];
    int iCook;

    String nomUtil = null;
    tableCookies = request.getCookies();

    for (iCook = 0; iCook < tableCookies.length; iCook++)
    {
        if ((tableCookies[iCook].getName()).compareTo("nomUtil") == 0)
        {
            nomUtil = tableCookies[iCook].getValue();
        }
    }
%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Récapitulatif</title>
        <link rel="stylesheet" type="text/css" href="miseEnPage.css" />
    </head>
    <body>
        <h2><%= nomUtil%>, voici le récapitulatif de vos données :</h2>
        <p>
            <br />
            Informations complémentaires saisies :
            <br />
        </p>
        <p>
            <%= texte1%>
        </p>
        <p>
            <%= texte2%>
        </p>
        <p>
            <%= texte3%>
        </p>
    </body>
</html>
