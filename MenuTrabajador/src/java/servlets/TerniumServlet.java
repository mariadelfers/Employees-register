package servlets;

import dataAccess.DBconnection;
import dataAccess.trabajadorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Trabajador;

@WebServlet(name = "TerniumServlet", urlPatterns = {"/TerniumServlet"})
public class TerniumServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "/index.jsp";
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "inicio"; // default action
        }
                
        // perform action and set URL to appropriate page
        if (action.equals("inicio")) {
            url = "/index.jsp";
        } else if (action.equals("registro")) {
            url = "/registro.jsp"; 
        } else if (action.equals("pgEliminar")) {
            url = "/eliminar.jsp";
        } else if (action.equals("pgModificar")) {
            url = "/modificar.jsp";
        } else if (action.equals("agregar")) {
            // get parameters from the request
            String nomina = request.getParameter("nomina");
            String nombre = request.getParameter("nombre");
            String mac = request.getParameter("mac");
            // store data in User object and save User object in database
            Trabajador trabajador = new Trabajador(nomina, nombre, mac);
            DBconnection dbCon = new DBconnection();
            trabajadorDAO tDAO = new trabajadorDAO(dbCon.getConnection());
            tDAO.addTrabajador(trabajador);

            // set User object in request object and set URL
            request.setAttribute("trabajador", trabajador);
            url = "/postregistro.jsp"; // the "thanks" page
        } else if (action.equals("desplegar")) {
            DBconnection dbCon = new DBconnection();
            trabajadorDAO tDAO = new trabajadorDAO(dbCon.getConnection());
            ArrayList<model.Trabajador> trabajadores = tDAO.showTrabajador();
            request.setAttribute("trabajadores", trabajadores);
            url = "/trabajadores.jsp";
        } else if (action.equals("buscar")) {
            DBconnection dbCon = new DBconnection();
            trabajadorDAO tDAO = new trabajadorDAO(dbCon.getConnection());
            String nomina = request.getParameter("nomina");
            Trabajador trabajador = tDAO.buscarTrabajador(nomina);
            request.setAttribute("buscar", trabajador);
            url = "/buscar.jsp";
        } else if (action.equals("eliminar")) {
            DBconnection dbCon = new DBconnection();
            trabajadorDAO tDAO = new trabajadorDAO(dbCon.getConnection());
            String nomina = request.getParameter("nomina");
            String mensaje = tDAO.eliminarTrabajador(nomina);
            request.setAttribute("eliminar", mensaje);
            url = "/posteliminar.jsp";
        }  else if (action.equals("modificar")) {
            DBconnection dbCon = new DBconnection();
            trabajadorDAO tDAO = new trabajadorDAO(dbCon.getConnection());
            String nomina = request.getParameter("nomina");
            Trabajador trabajador = tDAO.buscarTrabajador(nomina);
            request.setAttribute("modificar", trabajador);
            url = "/postmodificar.jsp";
        } else if (action.equals("postmodificado")){
            String nomina = request.getParameter("nomina");
            String nombre = request.getParameter("nombre");
            String mac = request.getParameter("mac");
            String nominaAnterior = request.getParameter("nominaAnterior");
            DBconnection dbCon = new DBconnection();
            trabajadorDAO tDAO = new trabajadorDAO(dbCon.getConnection());
            tDAO.modificarTrabajador(nominaAnterior, nomina, nombre, mac);
            Trabajador trabajador = new Trabajador(nomina, nombre, mac);
            request.setAttribute("trabajador", trabajador);
            url = "/postregistro.jsp";
        }

        // forward request and response objects to specified URL
        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

// HttpServlet methods
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
