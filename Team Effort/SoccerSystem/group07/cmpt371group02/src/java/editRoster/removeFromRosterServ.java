/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editRoster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *This is the servlet for removing a user from any roster they might be on.
 * @author paw818
 */
public class removeFromRosterServ extends HttpServlet {

    private editRoster usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is initiated by ajaxEditRoster. It checks that a user ID was entered
     * and then calls editRoster's removeUser method to remove the user from the team 
     * they are on.
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
        usr = new editRoster();

        String suser_id_rem = request.getParameter("user_id");  // Grab team id from form
        if (suser_id_rem == "") {
            out.println("<div style=\"color:red;\"> Please enter a user ID</div>");
        } else {
            int user_id_rem = Integer.parseInt(suser_id_rem);   //Parse the ID into an Integer           

            try {
                //If team exists, it will remove and display success message
                if (usr.removeUser(user_id_rem)) {
                    out.println("<label style=\"color:green;\">" + user_id_rem + "</label><div style=\"color:green;\"> Removed successfully from roster</div>");
                } //Else will display unsuccessful message
                else {
                    out.println("<label style=\"color:red;\">" + user_id_rem + "</label><div style=\"color:red;\">Removal from roster unsuccessful</div>");
                }
            } catch (SQLException e) {
                out.println("SQLException: " + e);
            } finally {
                out.close();
            }
        }
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
