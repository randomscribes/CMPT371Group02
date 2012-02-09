/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package editRoster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import playerManagerProfile.playerManagerProfile;

/**
 *This is the servlet for displaying a single teams roster.
 * @author paw818
 */
public class displayTeamRosterServ extends HttpServlet {

    private editRoster usr;
    private PrintWriter out;
    private playerManagerProfile usrTeam;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is initiated by ajaxEditRoster. It creates a table with a header
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
        usr = new editRoster();

        String steam_id = request.getParameter("viewTeam");

        if (steam_id.equals("")) {
            out.println("<div style=\"color:red;\">Please select a team to view</div>");
        } else {
            Integer team_id = Integer.parseInt(steam_id);

            try {
                Vector rs = usr.getTeam(team_id);
                String title = "Display Team Roster";
                Vector tblHeader = new Vector();
                tblHeader.addElement("Player's ID");
                tblHeader.addElement("Last Name");
                tblHeader.addElement("First Name");
                tblHeader.addElement("Team");
                display(rs, tblHeader, title, response);
            } catch (SQLException e) {
                out.println("No users found");
                //displayACK("ERROR", "No users found!");
            } catch (Exception e) {
                //out.println("No users found. ");
                //displayACK("ERROR", "No users found!");
            } finally {
                out.close();
            }
        }
        out.close();
    }

    /**
     * This method does the bulk of the table creation.
     * @param rows - the content of the table to print
     * @param hdr - the table's header
     * @param title - table's title
     * @param response - servlet response
     */
    private void display(Vector rows, Vector hdr, String title, HttpServletResponse response) throws SQLException, Exception {
        usrTeam = new playerManagerProfile();
        response.setContentType("text/html");

        out.println("<HTML><HEAD><TITLE>");
        out.println("Sports Management System");
        out.println("</TITLE></HEAD><BODY>");

        out.println("<tbody>");
        out.println("<h1 id=\"table_id\">Current Roster:</h1>");
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
            for (int j = 0; j < row.size(); j++) {
                if (j != 3) {
                    out.println("<td valign=Top>" + row.elementAt(j).toString() + "<br></td>");
                } else {
                    out.println("<td valign=Top>" + usrTeam.getTeamName(row.elementAt(3).toString()) + "<br></td>");
                }
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</tbody>");
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
