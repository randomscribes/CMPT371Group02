package playerManagerProfile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Returns the corresponding stats for an individual user
 * @author scb444
 */
public class getMyStatsServ extends HttpServlet {

    private playerManagerProfile usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        out = response.getWriter();
        usr = new playerManagerProfile();
        Integer user_id = Integer.parseInt(request.getParameter("user_id_stats"));


        try {

            String title = "Upcoming Games";
            Vector tblHeader = new Vector();
            tblHeader.addElement("Goals");
            tblHeader.addElement("Assists");

            display(tblHeader, title, user_id, response);
        } catch (SQLException e) {
            out.println("No games found");
            //displayACK("ERROR", "No users found!");
        } catch (Exception e) {
            out.println("No games found");
            //displayACK("ERROR", "No users found!");
        } finally {
            out.close();
        }
    }

    //This will display the user's three upcoming games in a table
    private void display(Vector hdr, String title, int user_id, HttpServletResponse response) throws SQLException, Exception {
        response.setContentType("text/html");

        out.println("<HTML><HEAD><TITLE>");
        out.println("Sports Management System");
        out.println("</TITLE></HEAD><BODY>");

        out.println("<tbody>");
        //out.println("<h1 id=\"table_id\">Teams</h1>");
        out.println("<table id=\"hor-minimalist-a\" >");


        // print table's header
        out.println("<tr valign=Top>");
        for (int i = 0; i < hdr.size(); i++) {
            out.println("<td valign=Top><b>" + hdr.elementAt(i).toString() + "</b><br></td>");
        }
        out.println("</tr>");
        // print the body of the table


        out.println("<td valign=Top>" + usr.numGoals(user_id) + "<br></td>");
        out.println("<td valign=Top>" + usr.numAssists(user_id) + "<br></td>");


        out.println("</tr>");

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
