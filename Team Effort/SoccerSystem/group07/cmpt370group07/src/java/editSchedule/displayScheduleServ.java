package editSchedule;

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
 * This servlet is used to display the games in the database.
 * @author saf725
 */
public class displayScheduleServ extends HttpServlet {

    private editSchedule usr;
    private playerManagerProfile gamesUsr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is instantiated by ajaxEditSchedule. It creates a table head, calls a method
     * to query the database, and passes these to display(...) to print
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

        try {
            Vector rs = usr.getGames();
            String title = "Display Schedule";
            Vector tblHeader = new Vector();
            tblHeader.addElement("GameID");
            tblHeader.addElement("Home Team");
            tblHeader.addElement("Away Team");
            tblHeader.addElement("Location");
            tblHeader.addElement("Date");
            //        tblHeader.addElement("Home Score");
            //       tblHeader.addElement("Away Score");
            //      tblHeader.addElement("Status");
            display(rs, tblHeader, title, response);
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

    /**
     * This method takes a table header and data and prints a table
     * @param rows - vector containing the content of the table
     * @param hdr - table header
     * @param title - table title
     * @param response - servlet response
     */
    private void display(Vector rows, Vector hdr, String title, HttpServletResponse response) throws SQLException, Exception {
        response.setContentType("text/html");

        gamesUsr = new playerManagerProfile();


        out.println("<HTML><HEAD><TITLE>");
        out.println("Sports Management System");
        out.println("</TITLE></HEAD><BODY>");

        out.println("<tbody>");
        out.println("<h1 id=\"table_id\">Schedule</h1>");
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
            //   for (int j = 0; j < row.size(); j++) {

            out.println("<td valign=Top>" + row.elementAt(0).toString() + "<br></td>");
            out.println("<td valign=Top>" + gamesUsr.getTeamName(row.elementAt(1).toString()) + "<br></td>");
            out.println("<td valign=Top>" + gamesUsr.getTeamName(row.elementAt(2).toString()) + "<br></td>");
            out.println("<td valign=Top>" + row.elementAt(3).toString() + "<br></td>");
            out.println("<td valign=Top>" + row.elementAt(4).toString() + "<br></td>");


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
