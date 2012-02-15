package editSchedule;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is the servlet for removing a game from the server.
 * @author saf725
 */
public class removeGameServ extends HttpServlet {

    private editSchedule usr;
    private PrintWriter out;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is instantiated by ajaxEditSchedule. It checks input and calls the 
     * methods to remove a game from the database.
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

        String sgame_id_rem = request.getParameter("game_id");  // Grab team id from form
        if (sgame_id_rem == "") {
            out.println("<div style=\"color:red;\"> Please enter a Game ID</div>");
        } else {
            int game_id_rem = Integer.parseInt(sgame_id_rem);   //Parse the ID into an Integer           

            try {
                //If team exists, it will remove and display success message
                if (usr.removeGame(game_id_rem)) {
                    out.println("<p style=\"color:green;\">" + game_id_rem + "</p><div style=\"color:green;\"> Removed successfully from schedule</div>");
                } //Else will display unsuccessful message
                else {
                    out.println("<p style=\"color:red;\">" + game_id_rem + "</p><div style=\"color:red;\">Removal from schedule unsuccessful!</div>");
                }
            } catch (SQLException e) {
                out.println("SQL ERROR: " + e);
            } finally {
                out.close();
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
