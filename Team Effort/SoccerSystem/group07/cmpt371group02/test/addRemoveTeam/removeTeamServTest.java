/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addRemoveTeam;

import org.jmock.Mockery;
import org.jmock.Expectations;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class removeTeamServTest {
    
    private Mockery mockContext = new Mockery(); 
    
    public removeTeamServTest() {
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
     * Test of processRequest method, of class removeTeamServ.
     */
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("testProcessRequest");

        final HttpServletRequest request = mockContext.mock(HttpServletRequest.class);
        final HttpServletResponse response = mockContext.mock(HttpServletResponse.class);
        
        final removeTeamServ instance = new removeTeamServ();
        mockContext.checking(new Expectations() { {
         oneOf(response).setContentType("text/html");
         ignoring(response);
         oneOf(request).getParameter("remTeam");
         will(returnValue(""));
        }});
        
        try
        {
            instance.processRequest(request, response);
        }
        catch(Exception e)
        {
            
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        mockContext.assertIsSatisfied();
        System.out.println("Jmock testing of removeTeamServ servlet successful");
    
    }
}