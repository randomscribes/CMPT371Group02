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
 * This is the servlet to display a table of stats for both teams in a game.
 * @author srw565
 */
public class displayStatsServ extends HttpServlet {

    private addRemoveStats usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is instantiated by ajaxAddRemoveStats. It creates a table with a header
     * and calls display(...) to fill in the table and print it.
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
                Vector rs = usr.getHomePlayers(game_id);
                String title = usr.getTeamName(usr.getHomeTeam(game_id));
                Vector tblHeader = new Vector();
                tblHeader.addElement("#");
                tblHeader.addElement("Last Name");
                tblHeader.addElement("First Name");
                tblHeader.addElement("Goals");
                tblHeader.addElement("Assists");
                display(rs, tblHeader, title, response, game_id);

                Vector rs1 = usr.getAwayPlayers(game_id);
                title = usr.getTeamName(usr.getAwayTeam(game_id));
                tblHeader = new Vector();
                tblHeader.addElement("#");
                tblHeader.addElement("Last Name");
                tblHeader.addElement("First Name");
                tblHeader.addElement("Goals");
                tblHeader.addElement("Assists");
                display(rs1, tblHeader, title, response, game_id);
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

    /**
     * This method does the bulk of the table creation.
     * @param rows - the content of the table to print
     * @param hdr - the table's header
     * @param title - table's title
     * @param response - servlet response
     */
    private void display(Vector rows, Vector hdr, String title, HttpServletResponse response, int game_id) throws SQLException {
        response.setContentType("text/html");

        out.println("<HTML><HEAD><TITLE>");
        out.println("Sports Management System");
        out.println("</TITLE></HEAD><BODY>");

        out.println("<tbody>");
        out.println("<h1 id=\"table_id\">" + title + "</h1>");
        out.println("<table id=\"hor-minimalist-a\" >");


        // print table's header
        out.println("<tr valign=Top>");
        for (int i = 0; i < hdr.size(); i++) {
            out.println("<td valign=Top><b>" + hdr.elementAt(i).toString() + "</b><br></td>");
        }
        out.println("</tr>");
        // print the body of the table
        for (int i = 0; i < rows.size(); i++) {
            out.println("<tr valign=Top>");
            Vector row = (Vector) rows.elementAt(i);
            for (int j = 0; j < 6; j++) {
                if (j != 0 && j != 4 && j != 5) {
                    System.out.println(row.elementAt(j).toString());
                    out.println("<td valign=Top>" + row.elementAt(j).toString());
                }
                if (j == 4) {
                    out.println("<td valign=Top>" + usr.numGoals(row.elementAt(0).toString(), game_id));
                }
                if (j == 5) {
                    out.println("<td valign=Top>" + usr.numAssists(row.elementAt(0).toString(), game_id));
                }
            }
            out.println("</tr>");
        }
        out.println("</table>");
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
