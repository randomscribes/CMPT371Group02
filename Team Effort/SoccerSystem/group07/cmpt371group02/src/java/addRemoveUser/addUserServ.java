package addRemoveUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the servlet for adding a user to a team's roster.
 * @author srw565
 */
public class addUserServ extends HttpServlet {

    private addRemoveUser usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is initiated by ajaxAddRemoveUser. It checks that all the input from the page
     * is complete and then calls the AddRemoveUser's addUser method to add a user to the database.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        out = response.getWriter();
        usr = new addRemoveUser();

        // Grab parameters that were filled out in the form
        String sfirst_name = request.getParameter("first_name");
        String slast_name = request.getParameter("last_name");
        String susername = request.getParameter("username");
        String spassword = request.getParameter("password");
        String saccess = request.getParameter("access");

        if (sfirst_name.equals("")) {
            out.println("<div style=\"color:red;\"> Please enter a first name</div>");
        } else if (slast_name.equals("")) {
            out.println("<div style=\"color:red;\"> Please enter a last name</div>");
        } else if (susername.equals("")) {
            out.println("<div style=\"color:red;\"> Please enter a username</div>");
        } else if (spassword.equals("")) {
            out.println("<div style=\"color:red;\"> Please enter a password</div>");
        } else if (saccess.equals("")) {
            out.println("<div style=\"color:red;\"> Please select a user type</div>");
        } else {
            char caccess = saccess.charAt(0);

            try {
                usr.addUser(sfirst_name, slast_name, susername, spassword, caccess);
                out.println("<label style=\"color:green;\">" + sfirst_name + " " + slast_name + "</label><div style=\"color:green;\"> Added successfully</div>");
            } catch (SQLException e) {
                //displayACK("Add User", sfirst_name + slast_name + " Failed!!");
            }//finally {            
            // out.close();
            //}
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
