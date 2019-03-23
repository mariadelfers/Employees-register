package dataAccess;
import model.Trabajador;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class trabajadorDAO {
    private PreparedStatement statement;
    private Connection connection;
    private static final Logger logger = Logger.getLogger(trabajadorDAO.class.getName());
    
    public trabajadorDAO (Connection connection) {
        this.connection = connection;
    }
    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public void addTrabajador (Trabajador trabajador) {
        try { 
            statement = connection.prepareStatement("INSERT INTO ubicaciones.trabajador VALUES (?,?,?)");
            {
                statement.setString(1, trabajador.getNomina());
                statement.setString(2, trabajador.getNombre());
                statement.setString(3, trabajador.getMac());
                statement.executeUpdate();
            }
            statement.close();
        }
        catch (SQLException sqle) {
            logger.log(Level.SEVERE, sqle.toString(), sqle);
            throw new RuntimeException(sqle);
        }
    }
    
    public ArrayList<model.Trabajador> showTrabajador(){
        ArrayList<model.Trabajador> trabajadores = new ArrayList<>();
        Trabajador trabajador = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM ubicaciones.trabajador");
            synchronized (statement) {
                ResultSet results = statement.executeQuery();
                
                while (results.next()){
                    trabajador = new Trabajador();
                    trabajador.setNomina(results.getString("nomina"));
                    trabajador.setNombre(results.getString("nombre"));
                    trabajador.setMac(results.getString("mac"));
                    trabajadores.add(trabajador);
                }
            }
            statement.close();
        } catch (SQLException e){
            System.err.println(e);
        }
        return trabajadores;
    }
    
    public Trabajador buscarTrabajador(String id){
        Trabajador trabajador = null;
        try {
            statement = connection.prepareStatement("SELECT nomina, nombre, mac FROM ubicaciones.trabajador WHERE nomina = ? OR mac = ?");
            synchronized (statement) {
                statement.setString(1, id);
                statement.setString(2, id);
                ResultSet result = statement.executeQuery();
                while (result.next()){
                    trabajador = new Trabajador();
                    trabajador.setNomina(result.getString("nomina"));
                    trabajador.setNombre(result.getString("nombre"));
                    trabajador.setMac(result.getString("mac"));
                }                
            }          
            statement.close();
        } catch (SQLException e){
            System.err.println(e);
        }
        return trabajador;
    }
    
    public String eliminarTrabajador(String id){
        String mensaje = null;
        int row = 0;
        try {
            statement = connection.prepareStatement("DELETE FROM ubicaciones.trabajador WHERE nomina = ?");
            synchronized (statement) {
                statement.setString(1, id);
                row = statement.executeUpdate();
            }
            
            statement.close();
        } catch (SQLException e){
            System.err.println(e);
        }
        if (row == 0){
            mensaje = "Error al eliminar trabajador";
        } else {
            mensaje = "Trabajador eliminado exitosamente";
        }
        return mensaje;
    }
    public void modificarTrabajador(String nominaAntigua,String nomina,String nombre,String mac){
        try {
            statement = connection.prepareStatement("UPDATE ubicaciones.trabajador SET nomina = ?, nombre = ?, mac = ? WHERE nomina = ?");
            synchronized (statement) {
                statement.setString(1, nomina);
                statement.setString(2, nombre);
                statement.setString(3, mac);
                statement.setString(4, nominaAntigua);
                statement.executeUpdate();
            }            
            statement.close();
        } catch (SQLException e){
            System.err.println(e);
        } 
    }
}
