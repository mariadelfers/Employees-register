package dataAccess;
import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class DBconnection {
    
    private Connection connection = null;
    private static final Logger logger = Logger.getLogger(DBconnection.class.getName());
    
    public DBconnection() {
        String db="pgsql";
        try {
            if (db.equals("pgsql")) {
            //Postgresql DB
            String host = "localhost";
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + host + ":5432/Ternium",
                        user = "admin",
                        password = "admin";
            connection = DriverManager.getConnection(url, user, password);
            } else if (db.equals("mysql")) {
            //MySQL DB
            String host = "localhost";
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + ":3306/Ternium",
                    user = "root",
                    password = "mysql";
            connection = DriverManager.getConnection(url, user, password);
            }
        }
        catch (SQLException sqle) {
            logger.log(Level.SEVERE,sqle.toString(),sqle);
            throw new RuntimeException(sqle);
        }
        catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, e.toString(), e);
        }
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
}
