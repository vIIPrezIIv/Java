package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Model.Employee;
import Model.EmployeeList;

public final class selectedDay_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Selected Day</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>\n");
      out.write("            ");
      out.print( request.getAttribute("dayAttribute") );
      out.write("\n");
      out.write("        </h1>\n");
      out.write("        <form action=\"Schedule\" method=\"POST\">\n");
      out.write("            <label>Start Time</label>\n");
      out.write("            <input type=\"text\" name=\"startTime\"/>\n");
      out.write("            </br>\n");
      out.write("            <label>End Time</label>\n");
      out.write("            <input type=\"text\" name=\"endTime\"/>\n");
      out.write("            </br>\n");
      out.write("            <label>Employee List</label>\n");
      out.write("            <select name=\"employee\">\n");
      out.write("                ");
 
                if(request.getAttribute("empList") == null){
                    out.println("request is null");
                }
                EmployeeList list = (EmployeeList) request.getAttribute("empList");
                List<Employee> emps = list.getEmployeeList();
                if(emps == null){
                    out.println("Emps is null");
                }
                //for(Employee e: emps){
                //    e.getFullName()
                //}
              
                
                for(int ctr = 0; ctr < emps.size(); ctr++)
                {
                    out.println("<option>");
                    out.println(emps.get(ctr).toString());
                    out.println("</option>");
                }
                
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("            </select>\n");
      out.write("            </br>\n");
      out.write("            <input type=\"submit\" value=\"Submit\"/> \n");
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
