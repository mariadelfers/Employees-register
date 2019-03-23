<nav class="navbar navbar-expand-sm navbar-dark bg-dark">

    <a class="navbar-brand" href="index.jsp">Ternium</a>

    <ul class="navbar-nav mr-auto">
        <a class="nav-item nav-link">
            <form action="TerniumServlet" method="post">
                <input type="hidden" name="action" value="registro">
                <button class="btn btn-dark">Registro</button>
            </form>
        </a>
        <a class="nav-item nav-link">
            <form action="TerniumServlet" method="post">
                <input type="hidden" name="action" value="desplegar">
                <button class="btn btn-dark">Trabajadores</button>
            </form>
        </a>
        <a class="nav-item nav-link">
            <form action="TerniumServlet" method="post">
                <input type="hidden" name="action" value="pgEliminar">
                <button class="btn btn-dark">Eliminar</button>
            </form>
        </a>
        <a class="nav-item nav-link">
            <form action="TerniumServlet" method="post">
                <input type="hidden" name="action" value="pgModificar">
                <button class="btn btn-dark">Modificar</button>
            </form>
        </a>
    </ul>

    <form class="form-inline my-auto" action="TerniumServlet" method="post">
        <input type="hidden" name="action" value="buscar">
        <input class="form-control my-auto" type="text" placeholder="Buscar trabajadores" name="nomina">
        <button class="btn btn-warning" type="submit">Buscar</button>
    </form>
</nav>