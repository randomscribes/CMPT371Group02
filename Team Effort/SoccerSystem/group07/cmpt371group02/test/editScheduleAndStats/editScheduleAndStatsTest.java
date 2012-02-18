/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editScheduleAndStats;

import editStats.editStats;
import java.sql.ResultSet;
import Connection.ConnectionManager;
import dbFunctions.dbFunctions;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;
import editSchedule.editSchedule;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adammravnik
 */
public class editScheduleAndStatsTest {
    
    private final editSchedule instance;
    private Connection db;
    private Statement st;
    private dbFunctions dbf;

    
    public editScheduleAndStatsTest() {
        instance = new editSchedule();
        db = (Connection) ConnectionManager.getConnection();
        try {
            st = (Statement) db.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(editScheduleAndStatsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbf = new dbFunctions();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addGame method, of class editSchedule.
     */
    @Test
    public void testAddRemoveGameAndStats() throws Exception {
        System.out.println("addGame test");
        Integer home_team_id = 100;
        Integer away_team_id = 101;
        Integer date = 120101;
        String location = "Jupiter";
        boolean expResult = true;
        boolean result = instance.addGame(home_team_id, away_team_id, date, location);
        assertEquals(expResult, result);
        
        System.out.println("removeGame test");
        Integer game_id = null;
        expResult = true;
        
        String sql = "SELECT game_id FROM games WHERE home_team=100 AND away_team=101";
        ResultSet resultSet = st.executeQuery(sql);
        String res = "";
        String num = "";
        while(resultSet.next())
        {
            num = (resultSet.getString("game_id"));
        }
        game_id = Integer.valueOf(num);
        
        System.out.println("getHomeTeam test");
        editStats editStatsInstance = new editStats();
        int expResultStats = 100;
        int expStatsReturn = editStatsInstance.getHomeTeam(game_id);
        assertEquals(expResultStats, expStatsReturn);
        System.out.println("getHomeTeam passed");
        
        System.out.println("getAwayTeam test");
        editStatsInstance = new editStats();
        expResultStats = 101;
        expStatsReturn = editStatsInstance.getAwayTeam(game_id);
        assertEquals(expResultStats, expStatsReturn);
        System.out.println("getAwayTeam passed");
        
        result = instance.removeGame(game_id);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("testAddRemoveGame passed.");
    }

    /**
     * Test of getGames method, of class editSchedule.
     */
    @Test
    public void testGetGames() throws Exception {
        System.out.println("getGames test");
        Vector result = instance.getGames();
        assertNotNull(result);
        System.out.println("testGetGames passed.");
    }
    
        /**
     * Test of getGames method, of class editSchedule.
     */
    @Test
    public void testGameConflict() throws Exception {
        
        System.out.println("gameConflict test");
        Integer home_team_id = 0;
        Integer date = 120112;
        Integer away_team_id = 0;
        String sql = "SELECT * from games WHERE (((home_team = " + home_team_id + ") AND (date = '" + date + "')) OR ((away_team = " + home_team_id + ") AND (date = '" + date + "'))) "
                + "OR (((home_team = " + away_team_id + ") AND (date = '" + date + "')) OR ((away_team = " + away_team_id + ") AND (date = '" + date + "')))";

        ResultSet result = st.executeQuery(sql);
        boolean resFinal = true;
        if(!result.next())
        {
            resFinal = false;
        }
        assertFalse(resFinal);
        
        System.out.println("testGameConflict passed.");
    }
}
