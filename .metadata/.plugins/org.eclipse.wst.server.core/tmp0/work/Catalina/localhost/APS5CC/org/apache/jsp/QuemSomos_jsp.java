/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.7
 * Generated at: 2018-07-04 15:37:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class QuemSomos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Quem somos</title>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/materialize.css\" type=\"text/css\" rel=\"stylesheet\"\r\n");
      out.write("\tmedia=\"screen,projection\" />\r\n");
      out.write("<link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\"\r\n");
      out.write("\tmedia=\"screen,projection\" />\r\n");
      out.write("<link href=\"css/style2.css\" type=\"text/css\" rel=\"stylesheet\"\r\n");
      out.write("\tmedia=\"screen,projection\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"Menu\">\r\n");
      out.write("\t\t<nav>\r\n");
      out.write("\t\t<div class=\"nav-wrapper\" style=\"background-color: teal;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"brand-logo left\">APS5 CC</a> <a href=\"#\"\r\n");
      out.write("\t\t\t\tdata-target=\"menu-mobile\" class=\"sidenav-trigger right\"><i\r\n");
      out.write("\t\t\t\tclass=\"material-icons\">menu</i></a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">\r\n");
      out.write("\t\t\t\t<li><a href=\"Index.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"Ocorrencias.jsp\">Ocorrências</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"Relatorios.jsp\">Relatórios</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"Cadastrar.jsp\">Cadastrar</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"QuemSomos.jsp\" class=\"z-depth-3\">Quem somos</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<ul id=\"menu-mobile\" class=\"sidenav\">\r\n");
      out.write("\t\t\t\t<li><a href=\"Index.jsp\" class=\"z-depth-3\">Home</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"Ocorrencias.jsp\">Ocorrências</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"Relatorios.jsp\">Relatórios</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"Cadastrar.jsp\">Cadastrar</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"QuemSomos.jsp\">Quem somos</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"parallax-container valign-wrapper\">\r\n");
      out.write("\t\t<div class=\"section no-pad-bot\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<div class=\"row center\">\r\n");
      out.write("\t\t\t\t\t<h5 class=\"header col s12 light\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"font-size: 45px; color: rgb(0, 0, 0)\">Quem Somos</h5>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"parallax\">\r\n");
      out.write("\t\t\t<img src=\"img\\quemsomos.jpg\" alt=\"Unsplashed background img 2\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"col s12 m4 l4\">\r\n");
      out.write("\t\t\t<div class=\"card horizontal\">\r\n");
      out.write("\t\t\t\t<div class=\"card-stacked\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card-content\">\r\n");
      out.write("\t\t\t\t\t<h4>José Henrique</h4>\r\n");
      out.write("\t\t\t\t\t\t<h6>Ciências da Computação</h6>\r\n");
      out.write("\t\t\t\t\t\t<p>RA: D061IH0</p>\r\n");
      out.write("\t\t\t\t\t\t<p>5º Semestre</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"card-action\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">Linkedin</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"col s12 m4 l4\">\r\n");
      out.write("\t\t\t<div class=\"card horizontal\">\r\n");
      out.write("\t\t\t\t<div class=\"card-stacked\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card-content\">\r\n");
      out.write("\t\t\t\t\t<h4>Joel</h4>\r\n");
      out.write("\t\t\t\t\t\t<h6>Ciências da Computação</h6>\r\n");
      out.write("\t\t\t\t\t\t<p>RA: C339EH5</p>\r\n");
      out.write("\t\t\t\t\t\t<p>4º Semestre</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"card-action\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">Linkedin</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"col s12 m4 l4\">\r\n");
      out.write("\t\t\t<div class=\"card horizontal\">\r\n");
      out.write("\t\t\t\t<div class=\"card-stacked\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card-content\">\r\n");
      out.write("\t\t\t\t\t<h4>Joseph</h4>\r\n");
      out.write("\t\t\t\t\t\t<h6>Ciências da Computação</h6>\r\n");
      out.write("\t\t\t\t\t\t<p>RA: N821CE9</p>\r\n");
      out.write("\t\t\t\t\t\t<p>5º Semestre</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"card-action\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">Linkedin</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<footer class=\"page-footer\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<div class=\"col l6 s12\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col l4 offset-l2 s12\">\r\n");
      out.write("\t\t\t\t\t<h5 class=\"white-text\">Links</h5>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=\"grey-text text-lighten-3\" href=\"Index.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=\"grey-text text-lighten-3\"\r\n");
      out.write("\t\t\t\t\t\t\thref=\"Ocorrencias.jsp\">Ocorrências</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=\"grey-text text-lighten-3\" href=\"Relatorios.jsp\">Relatórios</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=\"grey-text text-lighten-3\" href=\"Cadastrar.jsp\">Cadastrar</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=\"grey-text text-lighten-3\" href=\"QuemSomos.jsp\">Quem\r\n");
      out.write("\t\t\t\t\t\t\t\tsomos</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"footer-copyright\">\r\n");
      out.write("\t\t\t<div class=\"container\">© 2018 APS - Ciências da Computação - 4º\r\n");
      out.write("\t\t\t\te 5º Semestre</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/init.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$('.sidenav').sidenav();\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
