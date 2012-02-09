package addRemoveTeam;

import Connection.ConnectionManager;
import dbFunctions.dbFunctions;
import java.sql.*;
import java.util.*;

/**
 * This class provides the back-end functionality for the Add/Remove Teams page (addRemoveTeam.jsp)
 * @author paw818
 */
public class addRemoveTeam {

    private Connection db;
    private Statement st;
    private dbFunctions dbf;

    /**
     * initializes the class fields
     */
    public addRemoveTeam() {
        String table1 = "teams";

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
     * Add a team to the database.
     * @param team_name - name of team to add
     * @param manager - manager's id of team to add
     * @param year - year that the team is playing in
     * @return true if the operation completed successfully
     * @throws SQLException 
     */
    public boolean addTeam(String team_name, int manager, int year)
            throws SQLException {
        String values = "'" + team_name + "','" + manager + "'," + year + "," + 0 + "," + 0 + ","
                + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0 + "," + 0;
        String sql = "INSERT INTO teams (team_name, manager, year, games_played,"
                + "wins, losses, ties, points, ratio, goals_for, goals_against) values (" + values + ")";
        st.executeUpdate(sql);
        return true;
    }

    /**
     * removes a team from the database
     * @param team_id_r - id of the team to remove
     * @return true if the operation
     * @throws SQLException 
     */
    public boolean removeTeam(int team_id_r) throws SQLException {
        if (getTeam(team_id_r) == true) {
            String sql = "UPDATE users SET team_id = NULL WHERE team_id =" + team_id_r;
            st.executeUpdate(sql);
            sql = "DELETE from teams WHERE team_id = " + team_id_r;
            st.executeUpdate(sql);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return a vector containing all the teams in the database for use in a table 
     * @throws SQLException
     * @throws Exception 
     */
    public Vector getTeam() throws SQLException, Exception {
        String sql = "SELECT * from teams";
        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return dbf.getRecord(sql);
        } else {
            throw new Exception("No teams");
        }
    }

    /**
     * Checks if a team is in the database
     * @param team_id_r - id of team to check
     * @return true if the team is in the database
     * @throws SQLException 
     */
    public boolean getTeam(int team_id_r) throws SQLException {
        String sql = "SELECT team_id from teams WHERE team_id = " + team_id_r;
        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return true;
        } else {
            return false;
        }
    }
}
