/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editStats;

import Connection.ConnectionManager;
import java.sql.*;
import java.util.*;

/**
 * This class provides back-end functionality of the editStats page
 * @author saf725
 */
public class editStats {

    private Connection db;
    private Statement st;

    /**
     * Initializes the class fields.
     */
    public editStats() {
        String table1 = "teams";

        try {
            db = ConnectionManager.getConnection();
            st = db.createStatement();
        } catch (SQLException ex) {
            System.out.println("DB open exception\n");
            System.exit(1);
        }
    }

    /**
     * Gets the id of the home team for a game.
     * @param game_id - id of the game
     * @return the id of the home team
     * @throws SQLException 
     */
    public int getHomeTeam(int game_id) throws SQLException {
        String sql = "SELECT home_team FROM games WHERE game_id=" + game_id;
        ResultSet result = st.executeQuery(sql);
        result.next();
        int home_team = result.getInt("home_team");
        return home_team;//throw new Exception("No games");
    }

    /**
     * Gets the id of the away team for a game.
     * @param game_id - id of the game
     * @return the id of the away team
     * @throws SQLException 
     */
    public int getAwayTeam(int game_id) throws SQLException {
        String sql = "SELECT away_team FROM games WHERE game_id=" + game_id;
        ResultSet result = st.executeQuery(sql);
        result.next();
        int away_team = result.getInt("away_team");
        return away_team;//throw new Exception("No games");
    }
}
