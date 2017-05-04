package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Equip;
import Model.EquipmentList;
import java.util.List;
import Model.Sites;
import Model.EventSites;

public final class eventDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Event Details</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <form action=\"Events\" method=\"POST\">\n");
      out.write("            <label>Event Name</label>\n");
      out.write("            <input type=\"text\" name=\"eventName\" required/>\n");
      out.write("            </br>\n");
      out.write("            <label>Event Time</label>\n");
      out.write("            <input type=\"time\" name=\"eventTime\" required/>\n");
      out.write("            </br>\n");
      out.write("            <label>Event Site (Location)</label>\n");
      out.write("            <select name=\"eventSite\">\n");
      out.write("                ");
 
                    
                if(request.getAttribute("siteList") == null){
                    out.println("request is null");
                }
                
                EventSites list = (EventSites) request.getAttribute("siteList");
                List<Sites> sites = list.getEventSites();
                
                if(sites == null){
                    out.println("sites is null");
                }
            
                for(int ctr = 0; ctr < sites.size(); ctr++)
                {
                    out.println("<option>");
                    out.println(sites.get(ctr).toString());
                    out.println("</option>");
                }
                
      out.write("\n");
      out.write("            </select>    \n");
      out.write("            </br>\n");
      out.write("            <label>Event Equipment</label>\n");
      out.write("            <select name=\"eventEquip\">\n");
      out.write("                ");
 
                
                if(request.getAttribute("equipList") == null){
                    out.println("request is null");
                }
                
                EquipmentList list2 = (EquipmentList) request.getAttribute("equipList");
                List<Equip> equip = list2.getEventEquip();
                
                if(equip == null){
                    out.println("Equip is null");
                }
            
                for(int ctr = 0; ctr < equip.size(); ctr++)
                {
                    out.println("<option>");
                    out.println(equip.get(ctr).toString());
                    out.println("</option>");
                }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("            </br>\n");
      out.write("            <input type=\"submit\" value=\"Process Event\"/> \n");
      out.write("         </form>    \n");
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
