package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class establishes a connection to the database.
 * @author srw565
 */
public class ConnectionManager {

    static Connection con;
    static String url;

    /**
     * This method establishes the connection to the database
     * @return the connection
     */
    public static Connection getConnection() {

        String url = "jdbc:mysql://edjo.usask.ca/cmpt371group2_TeamEffort";
        String dbname = "cmpt371group2_TeamEffort";
        String usernm = "cmpt371gr2user";
        String passwd = "T33m3ff0rT";

        try {

            Class.forName("com.mysql.jdbc.Driver");

            try {
                con = DriverManager.getConnection(url, usernm, passwd);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return con;
    }
}
