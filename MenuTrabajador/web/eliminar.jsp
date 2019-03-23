<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Trabajador</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <link rel="stylesheet" href="CSS/style.css" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
        <!-- BARRA DE NAVEGACION -->
        <%@include file="navbar.jsp" %>
        <!-- CONTENIDO -->
        <div class="container-fluid m-4">
            <h1 class="my-3">Eliminar Trabajador</h1> 
            <p>Escribe la nómina del trabajador a eliminar.</p>
            <form action="TerniumServlet" method="post">
                <input type="hidden" name="action" value="eliminar">
                <input type="text" name="nomina">
                <button class="btn btn-danger btn-sm" type="submit">Eliminar</button>
            </form>
        </div>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>

