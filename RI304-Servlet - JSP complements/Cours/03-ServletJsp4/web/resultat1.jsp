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
            Attention, <%= nomUtil %> !
        </p>
        <p>
            Votre mot de passe est incorrect.
        </p>
    </body>
</html>