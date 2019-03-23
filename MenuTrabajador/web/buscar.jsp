<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Búsqueda</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <link rel="stylesheet" href="CSS/style.css" type="text/css"/>
        <script type="text/javascript" src="scripts/jquery-3.3.1.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script>
            $(document).ready(function(){
                if ("${buscar.nomina}" == ""){
                    $(".table").hide();
                    $(".noshow").show();
                } else {
                    $(".table").show();
                    $(".noshow").hide();
                }
            });
        </script>
    </head>
    <body>
        <!-- BARRA DE NAVEGACION -->
        <%@include file="navbar.jsp" %>
  
        <!-- CONTENIDO -->
        <div class="container-fluid m-4"> 
            <div class="container mt-3">
                <table class="table">
                    <div class="table">
                        <h1 class="my-3">Resultado de búsqueda</h1>
                    </div>
                    <thead class="thead-light text-center">
                        <tr>
                            <th scope="col">Nómina</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">MAC</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${buscar.nomina}</td>
                            <td>${buscar.nombre}</td>
                            <td>${buscar.mac}</td>
                            <td>
                                <form action="TerniumServlet" method="post">
                                    <input type="hidden" name="action" value="modificar">
                                    <input type="hidden" name="nomina" value="${buscar.nomina}">
                                    <button class="btn btn-warning btn-sm">Modificar</button>
                                </form>
                            </td>
                            <td>
                                <form action="TerniumServlet" method="post">
                                    <input type="hidden" name="action" value="eliminar">
                                    <input type="hidden" name="nomina" value="${buscar.nomina}">
                                    <button class="btn btn-danger btn-sm" type="submit">Eliminar</button>
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="noshow">
                    <h1 class="my-3">No hubo resultados</h1>
                </div>
            </div>
        </div>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>