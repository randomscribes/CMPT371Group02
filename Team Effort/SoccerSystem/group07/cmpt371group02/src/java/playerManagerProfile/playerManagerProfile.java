package playerManagerProfile;

import Connection.ConnectionManager;
import dbFunctions.dbFunctions;
import java.sql.*;
import java.util.*;

/**
 * This class returns various information for users
 * @author scb444
 */
public class playerManagerProfile {

    private Connection db;
    private Statement st;
    private dbFunctions dbf;

    public playerManagerProfile() {

        try {
            db = ConnectionManager.getConnection();
            st = db.createStatement();
            dbf = new dbFunctions();
        } catch (SQLException ex) {
            System.out.println("DB open exception\n");
            System.exit(1);
        }
    }

    public void init() {
    }

    //Get Announcements for administrators only
    //Only returns the announcements that were posted by administrators
    public Vector getAnnouncements() throws SQLException, Exception {
        String sql = "SELECT poster, message FROM announcements where (access = 2)";
        ResultSet result = st.executeQuery(sql);

        if (result.next()) {
            System.out.println(dbf.getRecord(sql));
            return dbf.getRecord(sql);
        } else {
            throw new Exception("No announcements found!");
        }
    }

    //Get announcements for players and managers
    //Returns announcements posted by administrators and the team's manager
    public Vector getAnnouncements(Integer team_id) throws SQLException, Exception {
        Integer manager_id = getManager(team_id);
        String sql = "SELECT poster, message FROM announcements where (poster = " + manager_id + ") OR (access = 2)";
        ResultSet result = st.executeQuery(sql);

        if (result.next()) {
            System.out.println(dbf.getRecord(sql));
            return dbf.getRecord(sql);
        } else {
            throw new Exception("No announcements found!");
        }

    }

    //Returns the user's three upcoming games
    public Vector getUpcomingGames(Integer user_id, boolean num_games) throws SQLException, Exception {

        Integer team_id = getUserTeam(user_id);
        String sql;
        ResultSet result;

        if (num_games == false) {
            sql = "SELECT home_team, away_team, location, date FROM games where ((home_team = " + team_id + ") "
                    + "OR (away_team = " + team_id + ")) ORDER BY date LIMIT 0,3";
            result = st.executeQuery(sql);

        } else {
            sql = "SELECT home_team, away_team, location, date FROM games where ((home_team = " + team_id + ") "
                    + "OR (away_team = " + team_id + ")) ORDER BY date";
            result = st.executeQuery(sql);
        }

        if (result.next()) {
            return dbf.getRecord(sql);
        } else {
            throw new Exception("No games found for this season!");
        }

    }

    public int numGoals(int user_id) throws SQLException {
        String sql = "SELECT goal, COUNT(goal) FROM game_stats WHERE goal=" + user_id;
        ResultSet result = st.executeQuery(sql);
        result.next();
        int numGoals = result.getInt("COUNT(goal)");
        return numGoals;
    }

    public int numAssists(int user_id) throws SQLException {
        String sql = "SELECT assist, COUNT(assist) FROM game_stats WHERE assist=" + user_id;
        ResultSet result = st.executeQuery(sql);
        result.next();
        int numAssists = result.getInt("COUNT(assist)");
        return numAssists;
    }

    //Returns the team name based on the team_id
    public String getTeamName(String steam_id) throws SQLException, Exception {
        int team_id = Integer.parseInt(steam_id);
        String sql = "SELECT team_name FROM teams WHERE team_id =" + team_id;

        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            System.out.println(result.getString("team_name"));
            return result.getString("team_name");
        } else {
            throw new Exception("No team found for this id!");
        }
    }

    //Gets the user's team_id based on their user_id
    public Integer getUserTeam(Integer user_id) throws SQLException, Exception {

        System.out.println("got to getuserteam");
        System.out.println("USER_ID: " + user_id);

        String sql = "SELECT team_id FROM users "
                + "WHERE user_id =" + user_id;
        ResultSet result = st.executeQuery(sql);
        if (result.next()) {
            System.out.println(result.getInt("team_id"));
            return result.getInt("team_id");

            //return dbf.getRecord(sql);
        } else {
            throw new Exception("No games found for this season!");
        }
    }

    //Gets the user's team manager based on the team_id
    public Integer getManager(Integer team_id) throws SQLException, Exception {

        String sql = "SELECT manager from teams WHERE team_id =" + team_id;
        ResultSet result = st.executeQuery(sql);

        if (result.next()) {
            System.out.println(result.getInt("manager"));
            return result.getInt("manager");
        } else {
            throw new Exception("No manager found!");
        }

    }

    //Get the announcement poster's name based on the user_id
    public String getPoster(String user_id) throws SQLException, Exception {

        System.out.println("USER_ID: " + user_id);
        String sql = "SELECT first_name from users WHERE user_id =" + user_id;
        ResultSet result = st.executeQuery(sql);

        if (result.next()) {
            System.out.println(result.getString("first_name"));
            return result.getString("first_name");
        } else {
            throw new Exception("No poster found!");
        }

    }
}
