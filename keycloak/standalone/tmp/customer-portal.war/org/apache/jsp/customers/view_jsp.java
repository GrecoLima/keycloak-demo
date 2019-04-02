package org.apache.jsp.customers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.keycloak.constants.ServiceUrlConstants;
import org.keycloak.example.CustomerDatabaseClient;
import org.keycloak.representations.IDToken;
import org.keycloak.util.KeycloakUriBuilder;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      response.addHeader("X-Powered-By", "JSP/2.2");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Customer View Page</title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"#E3F6CE\">\n");

    String logoutUri = KeycloakUriBuilder.fromUri("/auth").path(ServiceUrlConstants.TOKEN_SERVICE_LOGOUT_PATH)
            .queryParam("redirect_uri", "/customer-portal").build("demo").toString();
    String acctUri = KeycloakUriBuilder.fromUri("/auth").path(ServiceUrlConstants.ACCOUNT_SERVICE_PATH)
            .queryParam("referrer", "customer-portal").build("demo").toString();
    IDToken idToken = CustomerDatabaseClient.getIDToken(request);

      out.write("\n");
      out.write("<p>Goto: <a href=\"/product-portal\">products</a> | <a href=\"");
      out.print(logoutUri);
      out.write("\">logout</a> | <a\n");
      out.write("        href=\"");
      out.print(acctUri);
      out.write("\">manage acct</a></p>\n");
      out.write("Servlet User Principal <b>");
      out.print(request.getUserPrincipal().getName());
      out.write("\n");
      out.write("</b> made this request.\n");
      out.write("<p><b>Caller IDToken values</b> (<i>You can specify what is returned in IDToken in the customer-portal claims page in the admin console</i>:</p>\n");
      out.write("<p>Username: ");
      out.print(idToken.getPreferredUsername());
      out.write("</p>\n");
      out.write("<p>Email: ");
      out.print(idToken.getEmail());
      out.write("</p>\n");
      out.write("<p>Full Name: ");
      out.print(idToken.getName());
      out.write("</p>\n");
      out.write("<p>First: ");
      out.print(idToken.getGivenName());
      out.write("</p>\n");
      out.write("<p>Last: ");
      out.print(idToken.getFamilyName());
      out.write("</p>\n");
      out.write("<h2>Customer Listing</h2>\n");

    java.util.List<String> list = null;
    try {
        list = CustomerDatabaseClient.getCustomers(request);
    } catch (CustomerDatabaseClient.Failure failure) {
        out.println("There was a failure processing request.  You either didn't configure Keycloak properly, or maybe " +
                "you just forgot to secure the database service?");
        out.println("Status from database service invocation was: " + failure.getStatus());
        return;
    }
    for (String cust : list) {
        out.print("<p>");
        out.print(cust);
        out.println("</p>");

    }

      out.write("\n");
      out.write("<br><br>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
