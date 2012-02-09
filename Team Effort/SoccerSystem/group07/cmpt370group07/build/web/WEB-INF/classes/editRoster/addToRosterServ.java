package editRoster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the servlet for adding a user to a team's roster.
 * @author paw818
 */
public class addToRosterServ extends HttpServlet {

    private editRoster usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is initiated by ajaxEditRoster. It checks that all the input from the page
     * is complete and then calls the editRoster's addUser method to add a user to the database.
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

        // Grab parameters that were filled out in the form
        String suser_id = request.getParameter("user_id");
        String steam_id = request.getParameter("addTeam");

        if (suser_id.equals("")) {
            out.println("<div style=\"color:red;\">Please enter a user</div>");
        } else if (steam_id.equals("")) {
            out.println("<div style=\"color:red;\">Please select a team</div>");
        } else {
            Integer user_id = Integer.parseInt(suser_id);
            Integer team_id = Integer.parseInt(steam_id);

            try {
                if (usr.addUser(user_id, team_id)) {
                    out.println("<label style=\"color:green;\"> User #" + user_id + "</label><div style=\"color:green;\"> Added to roster successfully</div>");
                } else {
                    out.println("<label style=\"color:red;\"> User #" + user_id + "</label><div style=\"color:red;\">Not added to roster</div>");
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
