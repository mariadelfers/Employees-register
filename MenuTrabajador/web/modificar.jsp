<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Trabajador</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <link rel="stylesheet" href="CSS/style.css" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
        <!-- BARRA DE NAVEGACION -->
        <%@include file="navbar.jsp" %>
        <!-- CONTENIDO -->
        <div class="container-fluid m-4">
            <h1 class="my-3">Modificar Trabajador</h1> 
            <p>Escribe la nómina del trabajador a modificar.</p>
            <form action="TerniumServlet" method="post" class="align-middle">
                <input type="hidden" name="action" value="modificar">
                <input type="text" name="nomina">
                <button class="btn btn-warning btn-sm" type="submit">Modificar</button>
            </form>
        </div>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>

