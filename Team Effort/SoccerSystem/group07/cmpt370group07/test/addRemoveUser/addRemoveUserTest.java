/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addRemoveUser;

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
public class addRemoveUserTest {

    public addRemoveUserTest() {
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
     * Test of addUser method, of class addRemoveUser.
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");

        //Add user with no data
        String first_name = "";
        String last_name = "";
        String username = "r";
        String password = "";
        char access = ' ';
        addRemoveUser instance = new addRemoveUser();
        instance.addUser(first_name, last_name, username, password, access);

        //Add user with very large first name
        first_name = "rehalrbuiehuuvednvdfvnjhbssssssggrtsadrtviooooosgiktnseeeeeeeeauievkldfsnmjkvbtrfgs";
        last_name = "";
        username = "t";
        password = "";
        access = ' ';
        instance.addUser(first_name, last_name, username, password, access);

        //Add user with very long last name
        first_name = "";
        last_name = "gthsergbuitebvuhdnkslguthnseruihnifguvdjslfngjkfnnnnnnnnnuitlsdhnisdgulllrgtuirlrt";
        username = "y";
        password = "";
        access = ' ';
        instance.addUser(first_name, last_name, username, password, access);


        //Add user with 25 character limit password
        first_name = "";
        last_name = "";
        username = "u";
        password = "thisisa25charlimitpasswor";
        access = ' ';
        instance.addUser(first_name, last_name, username, password, access);

        //Add user with 6 character limit username
        first_name = "";
        last_name = "";
        username = "sfg123";
        password = "";
        access = ' ';
        instance.addUser(first_name, last_name, username, password, access);

        //Add user with special characters in first name
        first_name = "njvreuisl#$%";
        last_name = "";
        username = "i";
        password = "";
        access = ' ';
        instance.addUser(first_name, last_name, username, password, access);

        //Add user with special character in username
        first_name = "";
        last_name = "";
        username = "asd#$%";
        password = "";
        access = ' ';
        instance.addUser(first_name, last_name, username, password, access);

        //Add user with special characters in password
        first_name = "";
        last_name = "";
        username = "l";
        password = "qwefsd#$%";
        access = ' ';
        instance.addUser(first_name, last_name, username, password, access);

        //Add user with special characters in last name
        first_name = "";
        last_name = "gbyuuuuer$%#";
        username = "h";
        password = "";
        access = ' ';
        instance.addUser(first_name, last_name, username, password, access);

        //Add user with above 25 character limit password
        first_name = "";
        last_name = "";
        username = "o";
        password = "thisisabovethe25characterlimitforapassword";
        access = ' ';
        instance.addUser(first_name, last_name, username, password, access);

        //Add user with above 6 character limit username
        first_name = "";
        last_name = "";
        username = "sdr4567";
        password = "";
        access = ' ';
        instance.addUser(first_name, last_name, username, password, access);

    }

    /**
     * Test of removeUser method, of class addRemoveUser.
     */
    @Test
    public void testRemoveUser() throws Exception {
        System.out.println("removeUser");

        //Remove existing user
        Integer user_id = 1158;
        addRemoveUser instance = new addRemoveUser();
        boolean expResult = true;
        boolean result = instance.removeUser(user_id);
        assertEquals(expResult, result);

        //Remove existing user
        user_id = 1159;
        result = instance.removeUser(user_id);
        assertEquals(expResult, result);

        //Remove existing user
        user_id = 1160;
        result = instance.removeUser(user_id);
        assertEquals(expResult, result);

        //Remove existing user
        user_id = 1161;
        result = instance.removeUser(user_id);
        assertEquals(expResult, result);

        //Remove existing user
        user_id = 1162;
        result = instance.removeUser(user_id);
        assertEquals(expResult, result);

        //Remove existing user
        user_id = 1163;
        result = instance.removeUser(user_id);
        assertEquals(expResult, result);

        //Remove existing user
        user_id = 1164;
        result = instance.removeUser(user_id);
        assertEquals(expResult, result);

        //Remove existing user
        user_id = 1165;
        result = instance.removeUser(user_id);
        assertEquals(expResult, result);

        //Remove existing user
        user_id = 1166;
        result = instance.removeUser(user_id);
        assertEquals(expResult, result);

        //Remove non-existant user
        expResult = false;
        user_id = 1167;
        result = instance.removeUser(user_id);
        assertEquals(expResult, result);

        //Remove non-existant user
        user_id = 1168;
        result = instance.removeUser(user_id);
        assertEquals(expResult, result);
    }
}
