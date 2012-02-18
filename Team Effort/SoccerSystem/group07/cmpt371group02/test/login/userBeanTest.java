/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.Date;
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
public class userBeanTest {
    
    userBean instance;
    
    public userBeanTest() {
        instance = new userBean();
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
     * Test of setUser_id method, of class userBean.
     */
    @Test
    public void testSetGetUser_id() {
        System.out.println("setUser_id");
        Integer user_id = 12345;
        
        instance.setUser_id(user_id);
        
        Integer expResult = 12345;
        Integer result = instance.getUser_id();
        assertEquals(expResult, result);
    }

    /**
     * Test of setJersey_number method, of class userBean.
     */
    @Test
    public void testSetGetJersey_number() {
        System.out.println("setJersey_number");
        Integer jersey_number = 11;
        
        instance.setJersey_number(jersey_number);
        
        Integer expResult = 11;
        Integer result = instance.getJersey_number();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFees_paid method, of class userBean.
     */
    @Test
    public void testSetGetFees_paid() {
        System.out.println("setFees_paid");
        short fees_paid = 9874;
        
        instance.setFees_paid(fees_paid);
        
        short expResult = 9874;
        short result = instance.getFees_paid();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhone_number method, of class userBean.
     */
    @Test
    public void testSetGetPhone_number() {
        System.out.println("setPhone_number");
        Integer phone_number = 1234567;
        
        instance.setPhone_number(phone_number);
        
        Integer expResult = 1234567;
        Integer result = instance.getPhone_number();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBirthdate method, of class userBean.
     */
    @Test
    public void testSetGetBirthdate() {
        System.out.println("setBirthdate");
        Date birthdate = new Date("12/01/01");
        
        instance.setBirthdate(birthdate);
        
        Date expResult = new Date("12/01/01");
        Date result = instance.getBirthdate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTeam_id method, of class userBean.
     */
    @Test
    public void testSetGetTeam_id() {
        System.out.println("setTeam_id");
        Integer team_id = 133;
        
        instance.setTeam_id(team_id);
        
        Integer expResult = 133;
        Integer result = instance.getTeam_id();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAddress method, of class userBean.
     */
    @Test
    public void testSetGetAddress() {
        System.out.println("setAddress");
        String address = "123 Fake Street";
        
        instance.setAddress(address);
        
        System.out.println("getAddress");
        
        String expResult = "123 Fake Street";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAccessLevel method, of class userBean.
     */
    @Test
    public void testSetGetAccessLevel() {
        System.out.println("setAccessLevel");
        Integer accessLevel = 0;
        
        instance.setAccessLevel(accessLevel);
        
        System.out.println("getAccessLevel");
        
        Integer expResult = 0;
        Integer result = instance.getAccessLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class userBean.
     */
    @Test
    public void testSetGetFirstName() {
        System.out.println("setFirstName");
        String newFirstName = "Adam";
        
        instance.setFirstName(newFirstName);
        System.out.println("getFirstName");
        
        String expResult = "Adam";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setLastName method, of class userBean.
     */
    @Test
    public void testSetGetLastName() {
        System.out.println("setLastName");
        String newLastName = "Mravnik";
        
        instance.setLastName(newLastName);
        
        System.out.println("getLastName");
        
        String expResult = "Mravnik";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserName method, of class userBean.
     */
    @Test
    public void testSetGetUserName() {
        System.out.println("setUserName");
        String newUsername = "mravnika";
        
        instance.setUserName(newUsername);
        
        System.out.println("getUsername");
        
        String expResult = "mravnika";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setPassword method, of class userBean.
     */
    @Test
    public void testSetGetPassword() {
        System.out.println("setPassword");
        String newPassword = "adamopolis";
        
        instance.setPassword(newPassword);
        
        System.out.println("getPassword");
        
        String expResult = "adamopolis";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }
}
