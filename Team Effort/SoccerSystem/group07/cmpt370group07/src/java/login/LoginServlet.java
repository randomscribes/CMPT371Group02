/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class that captures that get the username and password parameters from the login.jsp
 *  Redirects user to correct page depending on user type and valid login.
 * @author Steph
 */
public class LoginServlet extends HttpServlet {

    /**
     * Call the correct functions to authenticate and then
     * sets the current session to the logged in user.
     * @param request
     * @param response
     * @throws ServletException
     * @throws java.io.IOException 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        try {

            userBean user = new userBean();
            user.setUserName(request.getParameter("un"));
            user.setPassword(request.getParameter("pw"));



            user = userDAO.login(user);

            //If username and password are valid, login
            if (user.isValid()) {

                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);


                //Determine if user is Admin, Mngr, or Player
                //Admin AccessLevel = 2
                if (user.getAccessLevel().equals(2)) {
                    response.sendRedirect("adminHome.jsp");
                } //Manager Access Level = 1
                else if (user.getAccessLevel().equals(1)) {
                    response.sendRedirect("mngrProfile.jsp");
                } //Player Access Level = 0
                else {
                    response.sendRedirect("playerProfile.jsp");
                }
                //Else if username and password not valid, try again
            } else {
                response.sendRedirect("invalidLogin.jsp"); //error page 
            }
        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }
}