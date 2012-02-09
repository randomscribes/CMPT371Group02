/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addRemoveStats;

import Connection.ConnectionManager;
import dbFunctions.dbFunctions;
import java.sql.*;
import java.util.*;

/**
 * This class provides the back-end functionality of the addRemoveStats.jsp page
 * @author srw565
 */
public class addRemoveStats {

    private Connection db;
    private Statement st;
    private dbFunctions dbf;

    /**
     * Initializes the class fields.
     */
    public addRemoveStats() {
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
     * 
     * @param game_id
     * @return
     * @throws SQLException 
     */
    public String getGameStatus(int game_id) throws SQLException {
        String sql = "SELECT status from games WHERE game_id =" + game_id;
        ResultSet result = st.executeQuery(sql);
        result.next();
        String game_status = result.getString("status");
        return game_status;
    }

    public void setGamePlayed(int game_id) throws SQLException {
        String sql = "UPDATE games SET status = 'Played' WHERE game_id =" + game_id;
        st.executeUpdate(sql);
    }

    /**
     * Gets the number of goals scored by a player in a game
     * @param user_id - player's id
     * @param game_id - game id
     * @return the number of goals scored
     * @throws SQLException 
     */
    public int numGoals(String user_id, int game_id) throws SQLException {
        int iuser_id = Integer.parseInt(user_id);
        String sql = "SELECT goal, COUNT(goal) FROM game_stats WHERE goal=" + iuser_id + " AND game_id=" + game_id;
        ResultSet result = st.executeQuery(sql);
        result.next();
        int numGoals = result.getInt("COUNT(goal)");
        return numGoals;
    }

    /**
     * Gets the total number of goals scored in a game by the home team
     * @param game_id
     * @return
     * @throws SQLException 
     */
    public int numHomeGoals(int game_id) throws SQLException {
        String sql = "SELECT home_score FROM games WHERE game_id=" + game_id;
        ResultSet result = st.executeQuery(sql);
        result.next();
        int numGoals = result.getInt("home_score");
        return numGoals;
    }

    /**
     * Gets the total number of goals scored in a game by the home team
     * @param game_id
     * @return
     * @throws SQLException 
     */
    public int numAwayGoals(int game_id) throws SQLException {
        String sql = "SELECT away_score FROM games WHERE game_id=" + game_id;
        ResultSet result = st.executeQuery(sql);
        result.next();
        int numGoals = result.getInt("away_score");
        return numGoals;
    }

    /**
     * Gets the number of assists gotten by a player in a game
     * @param user_id - player's id
     * @param game_id - game id
     * @return the number of assits scored
     * @throws SQLException 
     */
    public int numAssists(String user_id, int game_id) throws SQLException {
        int iuser_id = Integer.parseInt(user_id);
        String sql = "SELECT assist, COUNT(assist) FROM game_stats WHERE assist=" + iuser_id + " AND game_id=" + game_id;
        ResultSet result = st.executeQuery(sql);
        result.next();
        int numAssists = result.getInt("COUNT(assist)");
        return numAssists;
    }

    /**
     * Adds an assisted goal to the database and adds a goal to the home or away team
     * depending on game_type.
     * @param game_id - id of game
     * @param score_id - id of scoring player
     * @param assist_id - id of assisting player
     * @param game_type - home or away
     * @return true if the goal is successfully added
     * @throws SQLException 
     */
    public boolean addGoal(int game_id, int score_id, int assist_id, String game_type) throws SQLException {
        String sql = "INSERT INTO game_stats VALUE(" + game_id + "," + score_id + "," + assist_id + ")";
        st.executeUpdate(sql);
        if (game_type.equals("home")) {
            sql = "UPDATE games SET home_score=home_score+1 WHERE game_id=" + game_id;
        } else if (game_type.equals("away")) {
            sql = "UPDATE games SET away_score=away_score+1 WHERE game_id=" + game_id;
        }
        st.executeUpdate(sql);
        System.out.println("here");
        return true;
    }

    /**
     * Adds an unassisted goal to the database and adds a goal to the home or away team
     * depending on game_type.
     * @param game_id - id of game
     * @param score_id - id of scoring player
     * @param game_type - home or away
     * @return
     * @throws SQLException 
     */
    public boolean addGoal(int game_id, int score_id, String game_type) throws SQLException {
        String sql = "INSERT INTO game_stats (game_id, goal) VALUE(" + game_id + "," + score_id + ")";
        st.executeUpdate(sql);
        if (game_type.equals("home")) {
            sql = "UPDATE games SET home_score=home_score+1 WHERE game_id=" + game_id;
        } else if (game_type.equals("away")) {
            sql = "UPDATE games SET away_score=away_score+1 WHERE game_id=" + game_id;
        }
        st.executeUpdate(sql);
        return true;
    }

    /**
     * Removes an assisted goal to the database and removes a goal to the home or away team
     * depending on game_type.
     * @param game_id - id of game
     * @param score_id - id of scoring player
     * @param assist_id - id of assisting player
     * @param game_type - home or away
     * @return true if the goal is successfully added
     * @throws SQLException 
     */
    public boolean removeGoal(int game_id, int score_id, int assist_id, String game_type) throws SQLException {
        if (statExists(game_id, score_id, assist_id)) {
            String sql = "DELETE FROM game_stats WHERE game_id=" + game_id + " AND goal=" + score_id + " AND assist=" + assist_id + " LIMIT 1";
            st.executeUpdate(sql);
            if (game_type.equals("home")) {
                sql = "UPDATE games SET home_score=home_score-1 WHERE game_id=" + game_id;
            } else if (game_type.equals("away")) {
                sql = "UPDATE games SET away_score=away_score-1 WHERE game_id=" + game_id;
            }
            st.executeUpdate(sql);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an unassisted goal to the database and removes a goal to the home or away team
     * depending on game_type.
     * @param game_id - id of game
     * @param score_id - id of scoring player
     * @param game_type - home or away
     * @return
     * @throws SQLException 
     */
    public boolean removeGoal(int game_id, int score_id, String game_type) throws SQLException {
        if (statExists(game_id, score_id)) {
            String sql = "DELETE FROM game_stats WHERE game_id=" + game_id + " AND goal=" + score_id + " AND assist IS NULL" + " LIMIT 1";
            st.executeUpdate(sql);
            if (game_type.equals("home")) {
                sql = "UPDATE games SET home_score=home_score-1 WHERE game_id=" + game_id;
            } else if (game_type.equals("away")) {
                sql = "UPDATE games SET away_score=away_score-1 WHERE game_id=" + game_id;
            }
            st.executeUpdate(sql);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if an assisted goal exists in the database
     * @param game_id - id of game
     * @param goal_id - id of scoring player
     * @param assist_id - id of assisting player
     * @return true if the goal is in the database
     * @throws SQLException 
     */
    private boolean statExists(int game_id, int goal_id, int assist_id) throws SQLException {
        String sql = "SELECT * from game_stats WHERE game_id = " + game_id + " AND goal=" + goal_id + " AND assist=" + assist_id;
        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if an unassisted goal exists in the database
     * @param game_id - id of game
     * @param goal_id - id of scoring player
     * @return true if the goal is in the database
     * @throws SQLException 
     */
    private boolean statExists(int game_id, int goal_id) throws SQLException {
        String sql = "SELECT * from game_stats WHERE game_id = " + game_id + " AND goal=" + goal_id + " AND assist IS NULL";
        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the team name given id
     * @param team_id - id of team
     * @return the name of the team
     * @throws SQLException 
     */
    public String getTeamName(int team_id) throws SQLException {
        String sql = "SELECT team_name from teams WHERE team_id =" + team_id;
        ResultSet result = st.executeQuery(sql);
        result.next();
        String team_name = result.getString("team_name");
        return team_name;
    }

    /**
     * Gets the ID of the home team given game ID
     * @param game_id - ID of game
     * @return the ID of the home team
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
     * Gets the ID of the away team given game ID
     * @param game_id - ID of game
     * @return the ID of the home team
     * @throws SQLException 
     */
    public int getAwayTeam(int game_id) throws SQLException {
        String sql = "SELECT away_team FROM games WHERE game_id=" + game_id;
        ResultSet result = st.executeQuery(sql);
        result.next();
        int away_team = result.getInt("away_team");
        return away_team;//throw new Exception("No games");
    }

    /**
     * @param game_id
     * @return A vector containing the players on the home team and their stats 
     *      for the game
     * @throws SQLException 
     */
    public Vector getHomePlayers(int game_id) throws SQLException {
        String sql = "SELECT user_id, IF (jersey_number IS NULL, '', jersey_number) jersey_number, last_name, first_name FROM users WHERE team_id=" + getHomeTeam(game_id) + " ORDER BY last_name";
        ResultSet result = st.executeQuery(sql);

        if (result.next()) {
            return dbf.getRecord(sql);
        } else {
            return dbf.getRecord(sql);//throw new Exception("No games");
        }
    }

    /**
     * @param game_id
     * @return A vector containing the players on the away team and their stats 
     *      for the game
     * @throws SQLException 
     */
    public Vector getAwayPlayers(int game_id) throws SQLException {
        String sql = "SELECT user_id, IF (jersey_number IS NULL, '', jersey_number) jersey_number, last_name, first_name FROM users WHERE team_id=" + getAwayTeam(game_id) + " ORDER BY last_name";
        ResultSet result = st.executeQuery(sql);

        if (result.next()) {
            return dbf.getRecord(sql);
        } else {
            return dbf.getRecord(sql);//throw new Exception("No games");
        }
    }
}
