/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet redirects the user based on input from the adminHome page.
 * @author srw565
 */
public class adminController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * 
     * This process is used by the adminHome.jsp. It checks which button was pressed and
     * redirects the browser to the appropriate jsp page.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        String button = request.getParameter("buttonPressed");
        String season = request.getParameter("Season");
        if (season == "") { //if season unslelected, then use current year as the season
            Calendar cal = Calendar.getInstance();
            Integer year = cal.get(Calendar.YEAR);
            season = year.toString();
        }


        if (button.equals("Add/Remove Team")) {
            response.sendRedirect("addRemoveTeam.jsp?season=" + season);
        } else if (button.equals("Add/Remove User")) {
            response.sendRedirect("addRemoveUser.jsp?season=" + season);
        } else if (button.equals("Edit Rosters")) {
            response.sendRedirect("editRoster.jsp?season=" + season);
        } else if (button.equals("Edit Schedule")) {
            response.sendRedirect("editSchedule.jsp?season=" + season);
        } else if (button.equals("Update Stats")) {
            response.sendRedirect("editStats.jsp?season=" + season);
        } else if (button.equals("Post Announcement")) {
            response.sendRedirect("postAnnouncement.jsp?season=" + season);
        } else {
            System.out.println("bad admin home redirect");
        }

        request.getParameter("Season");


        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminController at " + request.getContextPath () + "</h1>");
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
