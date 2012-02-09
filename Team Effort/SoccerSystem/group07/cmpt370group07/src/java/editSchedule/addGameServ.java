package editSchedule;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the servlet for adding a game to the season schedule.
 * @author saf725
 */
public class addGameServ extends HttpServlet {

    private editSchedule usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This method is instantiated by ajaxEditSchedule. It checks the input and calls
     * the appropriate methods in editSchedule to add a game to the database.
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
        usr = new editSchedule();

        // Grab parameters that were filled out in the form
        String shome_team_id = request.getParameter("homeTeam");
        String saway_team_id = request.getParameter("awayTeam");
        String sdate = request.getParameter("date");
        String slocation = request.getParameter("location");

        if (shome_team_id.equals("")) {
            out.println("<div style=\"color:red;\">Please select home team!</div>");
        } else if (saway_team_id.equals("")) {
            out.println("<div style=\"color:red;\">Please select away team!</div>");
        } else if (sdate.equals("")) {
            out.println("<div style=\"color:red;\">Please enter a date for this game!</div>");
        } else if (slocation.equals("")) {
            out.println("<div style=\"color:red;\">Please enter a location for this game!</div>");
        } else {
            Integer home_team_id = Integer.parseInt(shome_team_id);
            Integer away_team_id = Integer.parseInt(saway_team_id);
            Integer date = Integer.parseInt(sdate);

            try {
                if (usr.addGame(home_team_id, away_team_id, date, slocation)) {
                    out.println("<p style=\"color:green;\"> User #" + home_team_id + "</p><div style=\"color:green;\"> Game succesfully added.</div>");
                } else {
                    out.println("<p style=\"color:red;\"> User #" + home_team_id + "</p><div style=\"color:red;\">ERROR: Game not added!</div>");
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
