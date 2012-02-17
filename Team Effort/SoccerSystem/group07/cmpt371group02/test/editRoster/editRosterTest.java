/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editRoster;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for testing editRoster.java
 * @author paw818
 */
public class editRosterTest {
    
    editRoster instance;
    
    //these values should be checked with the database before testing
    static final int trueID = 1176;
    static final int falseID = 9999;
    static final int trueTeamID = 60;
    static final int falseTeamID = 9999;
    
    public editRosterTest() {
        instance = new editRoster();
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    /**
     * Test the getUser() with true user_id method of editRoster
     */
     @Test
     public void getUserTrue() throws Exception {
         assertTrue(instance.getUser(trueID));        
     }
     
     /**
     * Test the getUser() with false user_id method of editRoster
     */
     @Test
     public void getUserFalse() throws Exception{
         assertFalse(instance.getUser(falseID));
     }
     
     // The next 4 tests all check both of addUser and removeUser methods with 
     // all cases of true or false user and team ids
     //Note: the database is accessed but not actually checked
     @Test 
     public void addRemoveUserTT() throws Exception{
         
         assertTrue(instance.addUser(trueID, trueTeamID));
         assertTrue(instance.removeUser(trueID));
       
     }
     @Test 
     public void addRemoveUserTF() throws Exception{
         
         assertFalse(instance.addUser(trueID, falseTeamID));
         assertFalse(instance.removeUser(trueID));
       
     }
     @Test 
     public void addRemoveUserFT() throws Exception{
         
         assertFalse(instance.addUser(falseID, trueTeamID));
         assertFalse(instance.removeUser(falseID));
       
     }
     @Test 
     public void addRemoveUserFF() throws Exception{
         
         assertFalse(instance.addUser(falseID, falseTeamID));
         assertFalse(instance.removeUser(falseID));
       
     }
    
    
}
