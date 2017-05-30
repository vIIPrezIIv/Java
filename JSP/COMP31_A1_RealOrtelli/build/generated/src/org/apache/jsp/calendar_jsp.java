package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class calendar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Calendar</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String name = (String)session.getAttribute("loggedUser");
 
            if(name.isEmpty())
            {
                String userName = request.getParameter("user");
                session.setAttribute("loggedUser", userName);
            }
            
            out.println("<h1>");
            out.println(name + " Logged On");
            out.println("</h1>");
        
      out.write("\n");
      out.write("        <h2>Calendar</h2>\n");
      out.write("        ");

            if(name == null)
            {
                
            }
            else
            {
                if(name.equals("manager"))
                {
                    out.println("<form action='SelectedDay' method='POST'>");
                }
                else
                {
                    out.println("<form action='Days' method='POST'>"); 
                }
               
            }
        
      out.write("\n");
      out.write("            <label>Input Day (Ex: 1-31)</label>\n");
      out.write("            <input type=\"number\" name=\"day\" min=\"1\" max=\"31\" required/>\n");
      out.write("            </br>\n");
      out.write("            <label>Input Month</label>\n");
      out.write("            <input type=\"month\" name=\"month\" required/>\n");
      out.write("            </br>\n");
      out.write("            ");

                if(name == null)
                {
                                     
                }
                else
                {
                    if(name.equals("manager"))
                    {
                        out.println("<input type='submit' value='Go To Shift'/>");
                    }
                    
                    if(name.equals("event planner"))
                    {
                        out.println("<input type='submit' value='Add Event Details'/>");
                    }
                }
                out.println("</form>");
            
      out.write("\n");
      out.write("        <form action=\"ProcessEvents\" method=\"POST\">\n");
      out.write("            <input type=\"submit\" value=\"Go To Available Events\"/>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
