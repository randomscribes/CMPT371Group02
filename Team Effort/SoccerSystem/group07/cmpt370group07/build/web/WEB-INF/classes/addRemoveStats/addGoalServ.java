/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addRemoveStats;

import editStats.editStats;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the servlet for adding a goal to the database.
 * @author paw818
 */
public class addGoalServ extends HttpServlet {

    private addRemoveStats usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is instantiated by ajaxAddRemoveStats
     * This method checks for appropriate input and then checks whether the goal is 
     * assisted or unnassited and calls the appropriate addGoal(...) function 
     * from addRemoveStats.java to add a goal to the database.
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

        // Grab parameters that were filled out in the form
        String sgame_id = request.getParameter("game_id");
        String sscore_id = request.getParameter("scorePlayer");
        String sassist_id = request.getParameter("assistPlayer");
        String game_type = request.getParameter("game_type");

        System.out.println(sscore_id + ", " + sassist_id + ", " + sgame_id + ", " + game_type);


        if (sgame_id.equals("")) {
            out.println("<div style=\"color:red;\">Please select a game</div>");
        } else if (sscore_id.equals("")) {
            out.println("<div style=\"color:red;\">Please select a player</div>");
        } else {
            Integer game_id = Integer.parseInt(sgame_id);
            Integer score_id = Integer.parseInt(sscore_id);
            if (!sassist_id.equals("")) { //if the goal is assisted
                Integer assist_id = Integer.parseInt(sassist_id);

                try {
                    if (usr.addGoal(game_id, score_id, assist_id, game_type)) {
                        out.println("<p style=\"color:green;\"> Game " + game_id + "</p><div style=\"color:green;\"> Result added successfully</div>");
                    } else;
                    //out.println("<label style=\"color:red;\"> Team" + steam_name + "</label><div style=\"color:red;\">Not added to roster</div>");
                } catch (SQLException e) {
                    out.println("<label style=\"color:red;\"> Result" + "</label><div style=\"color:red;\">not added succesfully. SQL Exception: " + e + " </div>");
                    //displayACK("Add User", sfirst_name + slast_name + " Failed!!");
                } finally {
                    out.close();
                }
            } else //if the goal is unnassisted
            {
                try {
                    if (usr.addGoal(game_id, score_id, game_type)) {
                        out.println("<p style=\"color:green;\"> Game " + game_id + "</p><div style=\"color:green;\"> Result added successfully</div>");
                    } else;
                    //out.println("<label style=\"color:red;\"> Team" + steam_name + "</label><div style=\"color:red;\">Not added to roster</div>");
                } catch (SQLException e) {
                    out.println("<label style=\"color:red;\"> Result" + "</label><div style=\"color:red;\">not added succesfully. SQL Exception: " + e + " </div>");
                    //displayACK("Add User", sfirst_name + slast_name + " Failed!!");
                } finally {
                    out.close();
                }
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
