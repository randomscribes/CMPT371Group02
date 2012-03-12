/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.PrintWriter;
import org.jmock.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
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
public class adminControllerTest {
    
    private Mockery mockContext = new Mockery(); 
    
    public adminControllerTest() {
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
     * Test of processRequest method, of class adminController.
     */
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        final HttpServletRequest request = mockContext.mock(HttpServletRequest.class);
        final HttpServletResponse response = mockContext.mock(HttpServletResponse.class);
        
        final adminController instance = new adminController();

        mockContext.checking(new Expectations() { {
         oneOf(response).setContentType("text/html;charset=UTF-8");
         ignoring(response);
         oneOf(request).getParameter("buttonPressed");
         will(returnValue("Add/Remove Team"));
         will(returnValue("Add/Remove User"));
         will(returnValue("Edit Rosters"));
         will(returnValue("Edit Schedule"));
         will(returnValue("Update Stats"));
         will(returnValue("Post Announcement"));
         will(returnValue(""));
         oneOf(request).getParameter("Season");
         will(returnValue(""));
         oneOf(request).getParameter("Season");
         ignoring(response).getWriter();
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
        System.out.println("Jmock testing of adminController servlet successful");
    }
    
    

   
}
