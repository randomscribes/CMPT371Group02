package playerManagerProfile;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Returns the list of announcements for the managers and players to see
 * Users will see all posts by administrators and the postings of their team manager
 * It indicates who posted each announcement
 * @author scb444
 */
public class getAnnouncementsServ extends HttpServlet {

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

        System.out.println("HELLOTHERE");

        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        usr = new playerManagerProfile();
        Integer team_id = Integer.parseInt(request.getParameter("team_id"));
        System.out.println("TeamID: " + team_id);

        try {
            Vector rs = usr.getAnnouncements(team_id);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sports Management System</title>");
            out.println("</head>");
            out.println("<body>");

            //Element 0 is the user_id of the poster
            //Element 1 is the message itself
            for (int i = rs.size() - 1; i >= 0; i--) {
                Vector row = (Vector) rs.elementAt(i);
                out.println("<b>" + usr.getPoster(row.elementAt(0).toString()) + ":</b><br/>");
                out.println(row.elementAt(1).toString() + "<br/><br/>");
            }
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
            out.println("No Announcements found 1");
            //displayACK("ERROR", "No users found!");
        } catch (Exception e) {
            out.println("No Announcements found 2");
            //displayACK("ERROR", "No users found!");
        } finally {
            out.close();
        }
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
