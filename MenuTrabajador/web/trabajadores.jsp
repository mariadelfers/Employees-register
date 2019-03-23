<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trabajadores</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <link rel="stylesheet" href="CSS/style.css" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
        <!-- BARRA DE NAVEGACION -->
        <%@include file="navbar.jsp" %>
        <!-- CONTENIDO -->
        <div class="container-fluid m-4"> 
            <h1 class="my-3">Trabajadores Registrados</h1>
            <div class="container mt-3">
                <table class="table">
                    <thead class="thead-light text-center">
                        <tr>
                            <th scope="col">Nómina</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">MAC</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="show" items="${trabajadores}">
                            <tr>
                                <td>${show.nomina}</td>
                                <td>${show.nombre}</td>
                                <td>${show.mac}</td>
                                <td>
                                    <form action="TerniumServlet" method="post">
                                        <input type="hidden" name="action" value="modificar">
                                        <input type="hidden" name="nomina" value="${show.nomina}">
                                        <button class="btn btn-warning btn-sm">Modificar</button>
                                    </form>
                                </td>
                                <td>
                                    <form action="TerniumServlet" method="post">
                                        <input type="hidden" name="action" value="eliminar">
                                        <input type="hidden" name="nomina" value="${show.nomina}">
                                        <button class="btn btn-danger btn-sm" type="submit">Eliminar</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>