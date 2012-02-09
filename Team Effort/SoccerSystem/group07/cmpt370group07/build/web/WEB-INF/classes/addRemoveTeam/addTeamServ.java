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
 * Servlet for adding a team to the database.
 * @author Patrick
 */
public class addTeamServ extends HttpServlet {

    private addRemoveTeam usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This method checks for appropriate input and calls the right method to add a team
     * to the database.
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

        // Grab parameters that were filled out in the form
        String steam_name = request.getParameter("team_name");
        String smanager_id = request.getParameter("manager_id");
        String syear = request.getParameter("year");

        if (steam_name.equals("")) {
            out.println("<div style=\"color:red;\">Please enter a team name</div>");
        } else if (smanager_id.equals("")) {
            out.println("<div style=\"color:red;\">Please select a manager</div>");
        } else {
            Integer manager_id = Integer.parseInt(smanager_id);
            Integer year = Integer.parseInt(syear);

            try {
                if (usr.addTeam(steam_name, manager_id, year)) {
                    out.println("<p style=\"color:green;\"> Team" + steam_name + "</p><div style=\"color:green;\"> Added successfully</div>");
                } else {
                    out.println("<p style=\"color:red;\"> Team" + steam_name + "</p><div style=\"color:red;\">Not added to roster</div>");
                }
            } catch (SQLException e) {
                //displayACK("Add User", sfirst_name + slast_name + " Failed!!");
            }//finally {            
            // out.close();
            //}
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
