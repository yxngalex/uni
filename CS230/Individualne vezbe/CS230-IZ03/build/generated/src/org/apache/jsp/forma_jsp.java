package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class forma_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title></title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center> \n");
      out.write("        <h1>Citanje Checkbox podataka</h1>\n");
      out.write("    </center>\n");
      out.write("    <ul>\n");
      out.write("        <li><p><b>FIT oblelezen:</b>\n");
      out.write("                    ");
      out.print( request.getParameter("fit"));
      out.write("\n");
      out.write("                <a href=\"http://www.metropolitan.ac.rs/osnovne-studije/fakultet-informacionih-tehnologija/\">Posetite FIT</a> \n");
      out.write("            </p></li>\n");
      out.write("        <li><p><b>FDU obelezen:</b>\n");
      out.write("                    ");
      out.print( request.getParameter("fdu"));
      out.write("\n");
      out.write("                <a href=\"http://www.metropolitan.ac.rs/fakultet-digitalnih-umetnosti-2/\">Posetite FDU</a>\n");
      out.write("            </p></li>\n");
      out.write("        <li><p><b>FAM oblezen:</b>\n");
      out.write("                    ");
      out.print( request.getParameter("fam"));
      out.write("\n");
      out.write("                <a href=\"http://www.metropolitan.ac.rs/osnovne-studije/fakultet-za-menadzment/\">Posetite FAM</a>\n");
      out.write("            </p></li>\n");
      out.write("    </ul>\n");
      out.write("</body>\n");
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
