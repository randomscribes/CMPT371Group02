package playerManagerProfile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Gets the message, user_id, and access level from the data passed from ajax function
 * Calls the announcements.java class to add the announcement to the database
 * Returns a message indicating whether successful or not
 * @author scb444
 */
public class announcementsServ extends HttpServlet {

    private announcements ann;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process used by ajaxAdminProfile. It checks input and then
     * calls the right method to add the announcement to the database.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        ann = new announcements();

        String message = request.getParameter("messageArea");

        String suser_id = request.getParameter("user_id");
        Integer user_id = Integer.parseInt(suser_id);

        String saccess = request.getParameter("access");
        Integer access = Integer.parseInt(saccess);

        System.out.println(message);

        if (message.equals("")) {
            out.println("<div style=\"color:red;\"> Please enter an announcement</div>");
        } else {

            try {
                ann.postAnnouncement(message, user_id, access);
                out.println("</label><div style=\"color:green;\"> Announcement posted successfully</div><br/>"
                        + message);
            } catch (SQLException e) {
                System.out.println("Post announcement failed!!");
            }
        }

        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet announcementsServ</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet announcementsServ at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
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
