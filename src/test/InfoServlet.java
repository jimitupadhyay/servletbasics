package test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletContext;

@WebServlet("/info") //URL FOR INFO SERVLET
public class InfoServlet extends HttpServlet {
			public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
						ServletOutputStream out = response.getOutputStream();
						out.println("<style>span{ color : blue; }</style>");
						out.println("<html><head><title>Info Servlet</title></head><body> 	");
						out.println("<p>This is INFO Servlet</p><br />");
						
						String requestURL =  request.getRequestURL().toString();
						out.println("<span>Request URL</span><br /> "+ requestURL);
						
						String requestURI = request.getRequestURI();
						out.println("<span>Request URI </span><br />"+  requestURI);
						
						String contextPath = request.getContextPath();
						out.println("<span>Context Path </span><br />"+ contextPath);
						
						String servletPath = request.getServletPath();
						out.println("<span>Servlet Path</span><br /> "+ servletPath);
						
						String queryString = request.getQueryString();
						out.println("<span>Query String </span><br />" + queryString);
						
						String parameter = request.getParameter("a");
						out.println("<span>Parameter Value is </span><br />" + parameter);
						
						String serverName = request.getServerName();
						out.println("<span>Server Name </span><br />"+ serverName);
						
						int serverPort = request.getServerPort();
						out.println("<span>Server Port </span><br />"+ serverPort);
						
						out.println("<span>Remote Address</span><br />"+ request.getRemoteAddr());
						
						out.println("<span>Remote Host </span><br />"+ request.getRemoteHost());
						
						out.println("<span>Remote Port </span><br />"+ request.getRemotePort());
						
						out.println("<span>Remote User </span><br />"+ request.getRemoteUser());
						
						out.println("<h2><span>Headers Information</span></h2><br />");
						
						Enumeration<String> headers = request.getHeaderNames();
						
						while(headers.hasMoreElements()) {
							String header = headers.nextElement();
							out.println("<br /><span>"+ header +"</span><br />" + request.getHeader(header));
						}
						
						ServletContext serverContext = request.getServletContext();
						
						out.println("<span>Servlet Location in HardDisk </span><br />"+ serverContext.getRealPath(""));
						
						out.println("</body></html>");
			}
			public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
						this.doGet(request, response);
			}
}
