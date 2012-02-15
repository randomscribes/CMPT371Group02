/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addRemoveTeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet is for removing a team from the database.
 * @author Patrick
 */
public class removeTeamServ extends HttpServlet {

    private addRemoveTeam usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is initiated by ajaxAddRemoveTeam. It checks input and calls
     * methods to remove a team from the database.
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
        usr = new addRemoveTeam();

        String steam_id_rem = request.getParameter("remTeam");  // Grab team id from form
        if (steam_id_rem == "") {
            out.println("<div style=\"color:red;\"> Please enter a team ID</div>");
        } else {
            int team_id_rem = Integer.parseInt(steam_id_rem);   //Parse the ID into an Integer           

            try {
                //If team exists, it will remove and display success message
                if (usr.removeTeam(team_id_rem)) {
                    out.println("<p style=\"color:green;\">" + team_id_rem + "</p><div style=\"color:green;\"> Removed successfully from database</div>");
                } //Else will display unsuccessful message
                else {
                    out.println("<p style=\"color:red;\">" + team_id_rem + "</p><div style=\"color:red;\">Removal from roster unsuccessful</div>");
                }
            } catch (SQLException e) {
                out.println("SQL Exception: " + e);
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
