package editSchedule;

import Connection.ConnectionManager;
import dbFunctions.dbFunctions;
import java.sql.*;
import java.util.*;

/**
 * This class provides the back-end functionality for the editSchedul.jsp page.
 * @author saf725
 */
public class editSchedule {

    private Connection db;
    private Statement st;
    private dbFunctions dbf;

    /**
     * Initialize the class fields.
     */
    public editSchedule() {

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
     * Add a game to the database.
     * @param home_team_id - ID of home team
     * @param away_team_id - ID of away team
     * @param date - date of game in format DDMMYY
     * @param location - location of the game
     * @return true if the operation is successful
     * @throws SQLException 
     */
    public boolean addGame(Integer home_team_id, Integer away_team_id, Integer date, String location)
            throws SQLException {
        System.out.println("got to addGame");
        /**
         *  DATE MUST BE IN YYMMDD FORMAT!!!!
         */
        if (!gameConflict(home_team_id, away_team_id, date)) {
            String sql = "INSERT INTO games (home_team, away_team, date, location) values (" + home_team_id + "," + away_team_id + ",'" + date + "','" + location + "')";
            st.executeUpdate(sql);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove a game from the database.
     * @param home_team_id - ID of home team
     * @param away_team_id - ID of away team
     * @param date - date of game in format DDMMYY
     * @param location - location of the game
     * @return true if the operation is successful
     * @throws SQLException 
     */
    public boolean removeGame(Integer game_id) throws SQLException/*, Exception*/ {
        System.out.println("got to removeGame");
        if (getGame(game_id) == true) {
            String sql = "DELETE FROM games where game_id=" + game_id;
            st.executeUpdate(sql);
            return true;
        } else {
            return false;
            //throw new Exception("UserID " + user_id + " was not found!");
        }
    }

    /**
     * @return A vector containing all of the games in the database for printing in a table.
     * @throws SQLException
     * @throws Exception 
     */
    public Vector getGames() throws SQLException, Exception {
        String sql = "SELECT game_id, home_team, away_team, location, date FROM games ORDER BY date";
        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return dbf.getRecord(sql);
        } else {
            throw new Exception("No games found for this season!");
        }
    }

    /**
     * Checks if a game is in the database
     * @param game_id - id of the game to check
     * @return true if the game is in the database
     * @throws SQLException 
     */
    private boolean getGame(Integer game_id) throws SQLException {
        String sql = "SELECT game_id from games WHERE game_id = " + game_id;
        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks that does not have a conflict and can therfore be added.
     * @param home_team_id - ID of home team
     * @param away_team_id - ID of away team
     * @param date - date of game
     * @return True if there is a conflict and the game should not be added.
     * @throws SQLException 
     */
    private boolean gameConflict(Integer home_team_id, Integer away_team_id, Integer date) throws SQLException {
        String sql = "SELECT * from games WHERE (((home_team = " + home_team_id + ") AND (date = '" + date + "')) OR ((away_team = " + home_team_id + ") AND (date = '" + date + "'))) "
                + "OR (((home_team = " + away_team_id + ") AND (date = '" + date + "')) OR ((away_team = " + away_team_id + ") AND (date = '" + date + "')))";

        System.out.println("**Checking for conflict game!**");

        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return true;
        } else {
            return false;
        }
    }
}
