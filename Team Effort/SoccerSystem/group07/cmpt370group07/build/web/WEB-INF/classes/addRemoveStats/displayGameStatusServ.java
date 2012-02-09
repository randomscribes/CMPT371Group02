/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addRemoveStats;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author saf725
 */
public class displayGameStatusServ extends HttpServlet {

    private addRemoveStats usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is instantiated by ajaxAddRemoveStats. It gets the data
     * required to print out the game status
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
                String gameStatus = usr.getGameStatus(game_id);
                display(gameStatus, response);
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

    private void display(String game_status, HttpServletResponse response) throws SQLException {
        response.setContentType("text/html");

        out.println(game_status);

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
