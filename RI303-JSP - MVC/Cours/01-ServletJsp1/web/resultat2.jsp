<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String nomUtil = request.getParameter("nomUtil");
   String choixAcces = request.getParameter("choixAcces"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accès</title>
        <link rel="stylesheet" type="text/css" href="miseEnPage.css" />
    </head>

    <body>
        <p>
            Merci, <%= nomUtil %>.
        </p>
        <p>
            Vous avez maintenant accès en <%= choixAcces %> au système.
        </p>
    </body>
</html>