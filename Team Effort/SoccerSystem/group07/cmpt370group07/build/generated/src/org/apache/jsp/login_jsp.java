package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=windows-1256");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1256\">\n");
      out.write("        <title>Login Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/template.css\">        \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header row\">\n");
      out.write("            <div id=\"header\">\n");
      out.write("                <h1>TeamLeader Soccer Management System Login</h1>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"body row scroll-y\">\n");
      out.write("            <div id=\"container\">\n");
      out.write("                <form id=\"loginform\" action=\"LoginServlet\">\n");
      out.write("                    <fieldset>\n");
      out.write("                        <legend >Login</legend>\n");
      out.write("                        <div class=\"username\">\n");
      out.write("                            <label for=\"username\">Username:</label>\n");
      out.write("                            <input id=\"username\" name=\"un\" type=\"text\" />\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"password\">\n");
      out.write("                            <label for=\"password\">Password:</label>\n");
      out.write("                            <input id=\"password\" name=\"pw\" type=\"password\" />\n");
      out.write("                        </div>                        \n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div id=\"fm-submit\">\n");
      out.write("                            <button type=\"submit\">Login</button>\n");
      out.write("                        </div>\n");
      out.write("                    </fieldset>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\t    \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"footer row\">\n");
      out.write("            TeamLeader 2011 &#169;\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
