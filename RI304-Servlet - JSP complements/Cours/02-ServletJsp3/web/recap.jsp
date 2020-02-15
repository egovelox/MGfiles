<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8");
    String texte1 = request.getParameter("texte1");
    String texte2 = request.getParameter("texte2");
    String texte3 = request.getParameter("texte3");
    String nomUtil = (String) application.getAttribute("nomUtil");%>

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
