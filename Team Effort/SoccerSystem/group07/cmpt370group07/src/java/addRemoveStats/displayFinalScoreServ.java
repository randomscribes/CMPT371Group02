/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addRemoveStats;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the servlet used to display the final score of a game on the 
 * addRemoveStats page
 * @author Simon
 */
public class displayFinalScoreServ extends HttpServlet {

    private addRemoveStats usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is instantiated by ajaxAddRemoveStats. It gets the data
     * required to print out the final score
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
        usr = new addRemoveStats();

        String sgame_id = request.getParameter("game_id");

        if (sgame_id.equals("")) {
            ;//out.println("<div style=\"color:red;\">Please select a game</div>");
        } else {
            Integer game_id = Integer.parseInt(sgame_id);

            try {
                String homeTeam = usr.getTeamName(usr.getHomeTeam(game_id));
                String awayTeam = usr.getTeamName(usr.getAwayTeam(game_id));
                int homeScore = usr.numHomeGoals(game_id);
                int awayScore = usr.numAwayGoals(game_id);
                display(homeTeam, awayTeam, homeScore, awayScore, response);
            } catch (SQLException e) {
                out.println("No users found!!");
                //displayACK("ERROR", "No users found!");
            } catch (Exception e) {
                System.out.println(e);
                out.println("No users found!!!!!");
                //displayACK("ERROR", "No users found!");
            } finally {
                out.close();
            }
        }
    }

    private void display(String homeTeam, String awayTeam, int homeScore, int awayScore, HttpServletResponse response) throws SQLException {
        response.setContentType("text/html");

        out.println("<HTML><HEAD><TITLE>");
        out.println("Sports Management System");
        out.println("</TITLE></HEAD><BODY>");

        out.println("<h1><b>" + homeTeam + " " + homeScore + " - " + awayScore + " " + awayTeam + "</b></h1>");

        out.println("</tbody>");
        out.println("</BODY></HTML>");
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
