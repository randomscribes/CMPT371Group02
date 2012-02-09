/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addRemoveUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author swacholtz
 */
public class removeUserServ extends HttpServlet {

    private addRemoveUser usr;
    private PrintWriter out;

    /** 
     * This process is initiated by ajaxEditRoster. It checks that all the input from the page
     * is complete and then calls the editRoster's addUser method to add a user to the database.
     * 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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

        String suser_id_rem = request.getParameter("user_id");  // Grab team id from form
        if (suser_id_rem.equals("")) {
            out.println("<div style=\"color:red;\"> Please Enter a user ID</div>");
        } else {
            int user_id_rem = Integer.parseInt(suser_id_rem);   //Parse the ID into an Integer
            try {
                //If team exists, it will remove and display success message
                if (usr.removeUser(user_id_rem)) {
                    out.println("<label style=\"color:green;\">" + user_id_rem + "</label><div style=\"color:green;\"> Removed successfully</div>");
                } //Else will display unsuccessful message
                else {
                    out.println("<label style=\"color:red;\">" + user_id_rem + "</label><div style=\"color:red;\">Removal unsuccessful</div>");
                }
            } catch (SQLException e) {
                displayACK("ERROR", "Attempt to remove user failed! User: " + user_id_rem + " not found!", response);
            } //catch (Exception e) {
            //   displayACK("Remove Team", e.getLocalizedMessage());
            //finally {
            //    out.close();
            //}
        }
        out.close();


    }

    private void displayACK(String op, String txt, HttpServletResponse response) {
        response.setContentType("text/html");

        out.println("<HTML><HEAD><TITLE>");
        out.println("Team Management System");
        out.println("</TITLE></HEAD><BODY>");
        out.println("<H1>" + op + "</H1>");
        out.println("<H2> ==========================================<br>");
        out.println("<H2> " + txt + "<br>");
        out.println("<H2> ==========================================<br>");
        out.println("</BODY></HTML>");
        out.close();
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
