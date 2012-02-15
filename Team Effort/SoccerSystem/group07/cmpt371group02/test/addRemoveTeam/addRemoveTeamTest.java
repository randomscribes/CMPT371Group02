/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addRemoveTeam;

import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author srw565
 */
public class addRemoveTeamTest {

    public addRemoveTeamTest() {
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
     * Test of addTeam method, of class addRemoveTeam.
     * Tries to add 4 teams to system.
     */
    @Test
    public void testAddTeam() throws Exception {
        System.out.println("addTeam");

        //Test 0 characters team name
        String team_name = "";
        int manager = 0;
        int year = 0;
        addRemoveTeam instance = new addRemoveTeam();
        boolean expResult = true;
        boolean result = instance.addTeam(team_name, manager, year);
        assertEquals(expResult, result);
        System.out.println("Pass: 0 characters team name");

        //test 20 character team name limit
        team_name = "at20characterlimit00";
        manager = 0;
        year = 0;
        result = instance.addTeam(team_name, manager, year);
        assertEquals(expResult, result);
        System.out.println("Pass: 20 character team name");

        //Test below 20 character team name limit
        team_name = "below20char";
        manager = 0;
        year = 0;
        result = instance.addTeam(team_name, manager, year);
        assertEquals(expResult, result);
        System.out.println("Pass: below 20 character team name");

        //test above 20 character team name limit
        team_name = "thisisabovethe20characterlimit";
        manager = 0;
        year = 0;
        result = instance.addTeam(team_name, manager, year);
        assertEquals(expResult, result);
        System.out.println("Pass: above 20 character team name");

    }

    /**
     * Test of removeTeam method, of class addRemoveTeam.
     * Removes all teams just added by the addTeam Test.
     */
    @Test
    public void testRemoveTeam() throws Exception {
        System.out.println("removeTeam");

        //Remove team
        int team_id_r = 57;
        addRemoveTeam instance = new addRemoveTeam();
        boolean expResult = true;
        boolean result = instance.removeTeam(team_id_r);
        assertEquals(expResult, result);
        System.out.println("Pass: remove existing team");

        //Remove team
        team_id_r = 58;
        result = instance.removeTeam(team_id_r);
        assertEquals(expResult, result);
        System.out.println("Pass: remove existing team");

        //Remove team
        team_id_r = 59;
        result = instance.removeTeam(team_id_r);
        assertEquals(expResult, result);
        System.out.println("Pass: remove existing team");

        //Remove team that doesn't exist
        team_id_r = 60;
        expResult = false;
        result = instance.removeTeam(team_id_r);
        assertEquals(expResult, result);
        System.out.println("Pass: remove non-existant team");
    }
}
