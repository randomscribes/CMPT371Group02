package playerManagerProfile;

import Connection.ConnectionManager;
import java.sql.*;
import org.apache.commons.lang.StringEscapeUtils;

/** 
 * Class that adds the announcement to the database
 *  Adds the user_id of the user who posted it, the message itself, and the access level of the poster (2 for admin, 1 for manager)
 * @author scb444
 */
public class announcements {

    private Connection db;
    private Statement st;

    /**
     * Initializes the class fields.
     */
    public announcements() {
        try {
            db = ConnectionManager.getConnection();
            st = db.createStatement();
        } catch (SQLException ex) {
            System.out.println("DB open exception\n");
            System.exit(1);
        }
    }

    /**
     * Puts an announcement into the database
     * @param message - message to store
     * @param user_id - id of posting user
     * @param access - access of posting user
     * @throws SQLException 
     */
    public void postAnnouncement(String message, Integer user_id, Integer access) throws SQLException {
        //StringEscapeUtils takes care to adding certain symbols to database
        String values = "'" + user_id + "','" + StringEscapeUtils.escapeSql(message) + "','" + access + "'";
        String sql = "INSERT INTO announcements values (" + values + ")";
        st.executeUpdate(sql);
    }

    /**
     * gets the int access level of a user from their ID
     * @param user_id - ID of user
     * @throws SQLException 
     */
    public void getAccess(Integer user_id) throws SQLException {
        String sql = "SELECT access FROM users WHERE user_id =" + user_id;
        ResultSet result = st.executeQuery(sql);

    }
}
