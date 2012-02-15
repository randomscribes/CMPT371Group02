/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editRoster;

import Connection.ConnectionManager;
import dbFunctions.dbFunctions;
import java.sql.*;
import java.util.*;

/**
 *This is the class for all the back-end operations of the Edit Roster page. (editRoster.jsp)
 * @author paw818
 */
public class editRoster {

    private Connection db;
    private Statement st;
    private dbFunctions dbf;

    /**
     * Constructor initializes the fields of the class.
     */
    public editRoster() {

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
     * This method adds a user to a team's roster.
     * @param user_id - id of user to add to roster
     * @param team_id - id of team to add user to
     * @return true if operation was succesful
     * @throws SQLException 
     */
    public boolean addUser(Integer user_id, Integer team_id)
            throws SQLException {
        if (getUser(user_id) == true) {
            String sql = "UPDATE users SET team_id = " + team_id + " WHERE user_id =" + user_id;
            st.executeUpdate(sql);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a user from whatever team they are on.
     * @param user_id - id of user to remove
     * @return true if operation successful
     * @throws SQLException 
     */
    public boolean removeUser(Integer user_id) throws SQLException {
        if (getUser(user_id) == true) {
            String sql = "UPDATE users SET team_id = NULL WHERE user_id =" + user_id;
            st.executeUpdate(sql);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param team_id - id of the team to view
     * @return A vector containing a teams roster (for use in a table)
     * @throws SQLException
     */
    public Vector getTeam(int team_id) throws SQLException {
        String sql = "SELECT user_id, last_name, first_name, team_id FROM users WHERE team_id=" + team_id + " ORDER BY last_name";
        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return dbf.getRecord(sql);
        } else {
            return dbf.getRecord(sql);
        }
    }

    /**
     * @return a vector containing every user in the data base (for use in a table)
     * @throws SQLException
     * @throws Exception 
     */
    public Vector getUsers() throws SQLException, Exception {
        String sql = "SELECT user_id, last_name, first_name, IF (team_id IS NULL, '', team_id) team_id FROM users ORDER BY last_name";
        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return dbf.getRecord(sql);
        } else {
            throw new Exception("No users");
        }
    }

    /**
     * Checks if a user exists in the database
     * @param user_id - id of user to check
     * @return true if the user is in the database
     * @throws SQLException 
     */
    public boolean getUser(Integer user_id) throws SQLException {
        String sql = "SELECT user_id from users WHERE user_id = " + user_id;

        System.out.println("got to getUser");

        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return true;
        } else {
            return false;
        }
    }
}
