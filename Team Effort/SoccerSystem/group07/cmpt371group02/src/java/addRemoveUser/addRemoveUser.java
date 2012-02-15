package addRemoveUser;

import Connection.ConnectionManager;
import dbFunctions.dbFunctions;
import java.sql.*;
import java.util.*;

/**
 * This is the java file containing all methods for adding or removing a user
 * from the database, as well as viewing a list of users. (addRemoveUser.jsp)
 * @author saf725
 */
public class addRemoveUser {

    private Connection db;
    private Statement st;
    private dbFunctions dbf;

    /**
     * Initializes the fields of the class
     */
    public addRemoveUser() {
        String table1 = "users";

        try {
            db = ConnectionManager.getConnection();
            st = db.createStatement();
            dbf = new dbFunctions();
        } catch (SQLException ex) {
            System.out.println("DB open exception\n");
            System.exit(1);
        }
    }

    /**
     * Add a user into the database
     * @param first_name    - first name of the user to be added
     * @param last_name     - last name of the user to be added
     * @param username      - username of the user to be added
     * @param password      - password of the user to be added
     * @param access        - access level of the user to be added
     * @throws SQLException 
     */
    public void addUser(String first_name, String last_name, String username, String password, char access)
            throws SQLException {
        String values = "'" + first_name + "','" + last_name + "','" + username + "','" + password + "','" + access + "'";
        String sql = "INSERT INTO users (first_name, last_name, username, password, access"
                + ") values (" + values + ")";
        st.executeUpdate(sql);
    }

    /**
     * Remove a user from the database
     * @param user_id
     * @return
     * @throws SQLException 
     */
    public boolean removeUser(Integer user_id) throws SQLException/*, Exception*/ {
        if (userExists(user_id) == true) {
            String sql = "DELETE from users WHERE user_id =" + user_id;
            st.executeUpdate(sql);
            return true;
        } else {
            return false;
            //throw new Exception("UserID " + user_id + " was not found!");
        }
    }

    /**
     * Get all users in the database
     * @return A vector containing the SQL results of all users in a database
     * @throws SQLException
     * @throws Exception 
     */
    public Vector getUsers() throws SQLException, Exception {
        String sql = "SELECT user_id, first_name, last_name, username, password, access from users";
        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return dbf.getRecord(sql);
        } else {
            throw new Exception("No users");
        }
    }

    /**
     * Determine where a user exists in the database
     * @param user_id   - User ID of the user to search for
     * @return          - Return true if user exists, false otherwise
     * @throws SQLException 
     */
    public boolean userExists(Integer user_id) throws SQLException {
        String sql = "SELECT user_id from users WHERE user_id = " + user_id;

        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return true;
        } else {
            return false;
        }
    }
}