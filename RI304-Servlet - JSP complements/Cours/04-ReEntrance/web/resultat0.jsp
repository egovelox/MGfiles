<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String nomUtil = request.getParameter("nomUtil"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recapitulatif</title>
        <link rel="stylesheet" type="text/css" href="miseEnPage.css" />
    </head>

    <body>
        <p>
            Désolé, <%= nomUtil %> !
        </p>
        <p>
            Vous êtes inconnu du système.
        </p>
    </body>
</html>